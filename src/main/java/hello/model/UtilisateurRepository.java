package hello.model;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.tables.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>   {

	Utilisateur findByEmail(String email);
	Utilisateur findById(int id);
	Iterable<Utilisateur> findByNomAndPrenom(String nom,String prenom);
	Iterable<Utilisateur> findByNomContainingOrPrenomContaining(String nom,String prenom);

	void deleteById(int id);
	
	Set <Utilisateur> findByIdIn(int[] ids);
	
	Set<Utilisateur> findByIdIn(Set<Integer> listeAmis);
}