package hello.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import hello.tables.Utilisateur;


@Component(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	//Repository que j'ai créé qui va aller chercher les utilisateurs dans la DB
	private  UtilisateurRepository userDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Utilisateur user = userDao.findByEmail(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
	}
//Ajoute les rôles  (Tu définis les rôles que tu veux, tu peux aussi mettre d'autres fonctions
	//pour retourner les rôles selon certains critères
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}


}