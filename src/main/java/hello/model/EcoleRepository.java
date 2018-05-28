package hello.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.tables.Contenus;
import hello.tables.Ecole;

public interface EcoleRepository extends JpaRepository<Ecole, Long> {

	Ecole findById(int id);
	Iterable<Ecole> findByidIn(int[] id);
		
	
	
	

}