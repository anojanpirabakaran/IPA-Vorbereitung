package abschluss.ano.ipa.ipavorbereitung.domain.contactdata;

import abschluss.ano.ipa.ipavorbereitung.config.generic.ExtendedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "contactData")
public class Contactdata extends ExtendedEntity {

    @Column(name = "mail", nullable = false)
    private String email;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;




}
