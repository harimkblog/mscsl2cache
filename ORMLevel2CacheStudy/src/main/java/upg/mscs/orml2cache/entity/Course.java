package upg.mscs.orml2cache.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="address", schema="olc2")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    @ManyToMany()
    private Set<Student> students;

    private String name;
}
