package upg.mscs.orml2cache.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employee", schema="olc2")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String name;

    @OneToOne
    private Address address;
    @ManyToOne
    private Department department;
    @ManyToMany()
    private Set<Course> courses;

    @Override
    public String toString() {
        return String.join( "~", ""+ id, name, ""+address.getId(), ""+department.getId());
    }

    public String studentCourseMap() {
        return String.join( "~", ""+ id,  ""+courses.stream().findFirst().get().getId());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Student))
            return false;
        return this.id == ((Student)o).id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}
