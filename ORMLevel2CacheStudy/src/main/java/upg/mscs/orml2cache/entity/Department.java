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

    @Override
    public String toString() {
        return String.join( "~", ""+ id, name);
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Department))
            return false;
        return this.id == ((Department)o).id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
