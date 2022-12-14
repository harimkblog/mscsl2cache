package upg.mscs.orml2cache.entity;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="course", schema="olc2")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private int id;

    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    //private Set<Student> students = new HashSet<>();

    private String name;

    @Override
    public String toString() {
        return String.join( ",", ""+ id, name);
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
