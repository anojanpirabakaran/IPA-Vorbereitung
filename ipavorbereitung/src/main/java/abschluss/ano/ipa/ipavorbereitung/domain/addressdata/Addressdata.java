package abschluss.ano.ipa.ipavorbereitung.domain.addressdata;

import abschluss.ano.ipa.ipavorbereitung.config.generic.ExtendedEntity;
import abschluss.ano.ipa.ipavorbereitung.domain.city.City;
import jakarta.persistence.*;

@Entity
@Table(name = "addressData")
public class Addressdata extends ExtendedEntity {

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "street_number", nullable = true)
    private String streetNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
