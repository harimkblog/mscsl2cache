package upg.mscs.orml2cache.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="address", schema="olc2")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    @OneToOne
    private Student student;

    private String streetAddress;
    private String city;
    private String state;
    private String country;
}
