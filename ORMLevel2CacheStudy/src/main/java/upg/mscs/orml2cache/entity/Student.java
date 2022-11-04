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
}
