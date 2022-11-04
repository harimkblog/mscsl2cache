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

    @Override
    public String toString() {
        return String.join( "~", ""+ id, name);
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Course))
            return false;
        return this.id == ((Course)o).id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
