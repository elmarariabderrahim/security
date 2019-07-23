package org.sid;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.sid.dao.EtudiantRepository;
import org.sid.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecuriteApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext cxt= SpringApplication.run(SecuriteApplication.class, args);
		EtudiantRepository etudiantRepository=cxt.getBean(EtudiantRepository.class);
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("khalid", "khalid", df.parse("1997-01-21")));
		etudiantRepository.save(new Etudiant("abdell", "abdell", df.parse("1997-01-21")));
		etudiantRepository.save(new Etudiant("9awss", "9awss", df.parse("1997-01-21")));
		
		List<Etudiant> 	etds=etudiantRepository.findAll();
		
		for(Etudiant e:etds){
			System.out.println("+++"+e.getNom());
		}
	}

}
