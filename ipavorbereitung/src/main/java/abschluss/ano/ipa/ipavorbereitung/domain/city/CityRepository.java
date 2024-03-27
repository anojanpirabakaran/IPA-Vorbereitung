package abschluss.ano.ipa.ipavorbereitung.domain.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {

boolean existsByPostalCode(int postalCode);
}
