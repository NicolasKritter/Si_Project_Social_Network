package hello.model;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.tables.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>   {

	Utilisateur findByLogin(String login);
//	Utilisateur findById(int id);
	Iterable<Utilisateur> findByNomAndPrenom(String nom,String prenom);
	Iterable<Utilisateur> findByNomContainingOrPrenomContaining(String nom,String prenom);

	void deleteByLogin(String id);
	
//	Set <Utilisateur> findByIdIn(int[] ids);
	
	Set<Utilisateur> findByLoginIn(Set<String> listLogin);
}