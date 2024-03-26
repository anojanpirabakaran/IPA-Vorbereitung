package abschluss.ano.ipa.ipavorbereitung;

import abschluss.ano.ipa.ipavorbereitung.domain.basicdata.Basicdata;
import abschluss.ano.ipa.ipavorbereitung.domain.basicdata.BasicdataRepository;
import abschluss.ano.ipa.ipavorbereitung.domain.contactdata.Contactdata;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IpavorbereitungApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpavorbereitungApplication.class, args);
	}
}
