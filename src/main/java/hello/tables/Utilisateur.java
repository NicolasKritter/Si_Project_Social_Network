// Generated with WSg.

package hello.tables;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name="utilisateur")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "login")
public class Utilisateur implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** Primary key. */
    protected static final String PK = "login";


//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(unique=true, nullable=false, precision=10)
//    private int id;
  
    @Id
    @Column(nullable=false, length=40)
    private String login;

    @Column(nullable=false, length=20)
    private String nom;
    
//    @Column(nullable=false, length=20)
//    private String role;
    
    
   
    @Column(nullable=false, length=200)
    private String password;

// 
//    @Column(name="photo_profile", length=200)
//    private String photoProfile;
    
    
    @Column(nullable=false, length=20)
    private String prenom;
    
//    @JsonManagedReference(value="UtilisateurEcole")
    @OrderBy("dateDebut DESC")
    @ManyToOne( optional = false)
    private Ecole ecole;
    
//    @JsonBackReference  (value="UtilisateurContenus")
    @OrderBy("date DESC")
    @OneToMany(mappedBy="utilisateur",cascade = CascadeType.ALL)
    private   Set<Contenus> contenus;
    

    
//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY,mappedBy="utilisateur",cascade = CascadeType.ALL,orphanRemoval = true)
//    private Set<DemandesAmis> demandesAmis;
    //TODO mettre les amis en Set<> ?


    
    /** Default constructor. */
    public Utilisateur() {
    	super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
//    public int getId() {
//        return id;
//    }


    
    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
//    public void setId(int aId) {
//        id = aId;
//    }



    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setLogin(String aEmail) {
    	login = aEmail;
    }


    /**
     * Access method for nom.
     *
     * @return the current value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter method for nom.
     *
     * @param aNom the new value for nom
     */
    public void setNom(String aNom) {
        nom = aNom;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }


    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter method for prenom.
     *
     * @param aPrenom the new value for prenom
     */
    public void setPrenom(String aPrenom) {
        prenom = aPrenom;
    }

    
    public Set<Contenus> getContenus() {
        return contenus;
    }

    /**
     * Setter method for activite.
     *
     * @param aActivite the new value for activite
     */
    public void setContenus(Set<Contenus> acontenus) {
    	contenus = acontenus;
    }

    public void addActivite(Contenus activite) {
    	this.getContenus().add(activite);
    }
    

    /**
     * Access method for voyage.
     *
     * @return the current value of voyage
     */
    public Ecole getEcole() {
        return ecole;
    }

    /**
     * Setter method for voyage.
     *
     * @param aVoyage the new value for voyage
     */
    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    
    /**
     * Compares the key for this instance with another Utilisateur.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Utilisateur and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Utilisateur)) {
            return false;
        }
        Utilisateur that = (Utilisateur) other;
        if (this.getLogin() != that.getLogin()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Utilisateur.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Utilisateur)) return false;
        return this.equalKeys(other) && ((Utilisateur)other).equalKeys(this);
    }



    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Utilisateur |");
        sb.append(" id=").append(getLogin());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", new Integer(getLogin()));
        return ret;
    }

}
