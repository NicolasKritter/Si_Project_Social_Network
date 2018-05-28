package hello.model;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.tables.Contenus;

import hello.tables.Utilisateur;

//TODO changer utilisateur par voyage
public interface ContenusRepository extends JpaRepository<Contenus, Long> {

//TODO enlever les //	//Utilisateur findByUtilisateur(String utilisateur);
	Contenus findById(int id);
	
	Iterable<Contenus> findByEcoleId(int voyageId);
	

	Iterable<Contenus> findByEcoleIdOrderByDateDesc(int ecoleId);

//	Iterable<Contenus> findFirst40ByFlagsGreaterThanOrderByFlagsDesc(int nbFlag);
	
	//Iterable<Activite> find(@Param("ids") Set<Integer> ids);
}//@Param("ids")Set<Integer> 