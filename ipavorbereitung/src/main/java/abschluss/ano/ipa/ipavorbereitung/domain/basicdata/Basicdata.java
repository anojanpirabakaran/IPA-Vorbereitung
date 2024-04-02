package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import abschluss.ano.ipa.ipavorbereitung.config.generic.ExtendedEntity;
import abschluss.ano.ipa.ipavorbereitung.domain.addressdata.Addressdata;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressData_id", referencedColumnName = "id")
    private Addressdata addressdata;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contactData_id", referencedColumnName = "id")
    private Contactdata contactdata;

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Addressdata getAddressdata() {
        return addressdata;
    }

    public void setAddressdata(Addressdata addressdata) {
        this.addressdata = addressdata;
    }

    public Contactdata getContactdata() {
        return contactdata;
    }

    public void setContactdata(Contactdata contactdata) {
        this.contactdata = contactdata;
    }
}
