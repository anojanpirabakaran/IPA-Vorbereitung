package abschluss.ano.ipa.ipavorbereitung.domain.contactdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactdataRepository extends JpaRepository<Contactdata, String> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String mail);
}
