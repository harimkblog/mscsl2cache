package upg.mscs.orml2cache.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department", schema="olc2")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private int id;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    private List<Student> students;

    private String name;

    @Override
    public String toString() {
        return String.join( ",", ""+ id, name);
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
