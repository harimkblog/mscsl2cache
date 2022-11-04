package upg.mscs.orml2cache.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department", schema="olc2")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    @OneToMany(mappedBy = "department")
    private List<Student> students;

    private String name;
}
