// Generated with WSg.

package hello.tables;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
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

@Entity(name="ecole")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ecole implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Primary key. */
	/** Primary key. */
    protected static final String PK = "id";
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=11)
    private int id;
    @Column(name="nom", nullable=false, length=255)
    private String nom;
    
    @Column(name="update_key", nullable=true, length=255)
    private String key;

//    @JsonBackReference (value="EcoleContenus")
    @OrderBy("date ASC")
    @OneToMany(mappedBy="ecole",cascade =CascadeType.ALL,orphanRemoval = true)
    private Set<Contenus> contenus;
    
  
    @OneToMany(mappedBy="ecole",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Utilisateur> utilisateur;
    

    /** Default constructor. */
    public Ecole() {
        super();
    }



    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	/**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String anom) {
        nom = anom;
    }


    public Set<Contenus> getContenus() {
        return contenus;
    }

    public void setContenus(Set<Contenus> contenus) {
        this.contenus = contenus;
    }
    
    public void addContenus(Contenus contenus) {
    	this.getContenus().add(contenus);
    }


    public Set<Utilisateur> getUtilisateurs() {
        return utilisateur;
    }


    public void setUtilisateur( Set<Utilisateur> aUtilisateur) {
        utilisateur = aUtilisateur;
    }
    
    public void addUtilisateur(Utilisateur utilisateur) {
    	this.getUtilisateurs().add(utilisateur);
    }
    
   

    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Ecole)) {
            return false;
        }
        Ecole that = (Ecole) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Ecole)) return false;
        return this.equalKeys(other) && ((Ecole)other).equalKeys(this);
    }


    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Ecole |");
        sb.append(" id=").append(getId());
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
        ret.put("id", new Integer(getId()));
        return ret;
    }


}
