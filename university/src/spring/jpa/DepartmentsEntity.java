package spring.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "departments", schema = "university", catalog = "postgres")
public class DepartmentsEntity {
    private int id;
    private String name;
    private Collection<TeachersEntity> teachers;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentsEntity that = (DepartmentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "department")
    public Collection<TeachersEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<TeachersEntity> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "DepartmentsEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
