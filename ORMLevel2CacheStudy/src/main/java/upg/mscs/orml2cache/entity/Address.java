package upg.mscs.orml2cache.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name="address", schema="olc2")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    private String streetAddress;
    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return String.join("~", ""+id, streetAddress, city, state, country );
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Address))
            return false;
        return this.id == ((Address)o).id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
