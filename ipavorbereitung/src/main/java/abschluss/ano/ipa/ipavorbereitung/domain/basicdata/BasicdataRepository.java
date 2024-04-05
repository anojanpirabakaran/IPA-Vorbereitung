package abschluss.ano.ipa.ipavorbereitung.domain.basicdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicdataRepository extends JpaRepository<Basicdata, String> {

    boolean existsByFirstName(String firstname);

    boolean existsByLastName(String lastname);

    boolean existsByDateOfBirth(String birthDate);
}
