package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import abschluss.ano.ipa.ipavorbereitung.config.generic.ExtendedEntity;
import abschluss.ano.ipa.ipavorbereitung.domain.contactdata.Contactdata;
import jakarta.persistence.*;

@Entity
@Table(name = "basicData")
public class Basicdata extends ExtendedEntity {

    @Column(name = "saluation", nullable = true)
    private String salutation;

    @Column(name = "firstName", nullable = true)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "dateOfBirth", nullable = false)
    private String dateOfBirth;
/*
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contactData_id", referencedColumnName = "id")
    private Contactdata contactdata;
*/
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
