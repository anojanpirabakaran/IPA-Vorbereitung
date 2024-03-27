package abschluss.ano.ipa.ipavorbereitung.domain.city;

import abschluss.ano.ipa.ipavorbereitung.config.generic.ExtendedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City extends ExtendedEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "postal_code", nullable = false)
    private int postalCode;

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
