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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="ecole")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ecole implements Serializable {

    /** Primary key. */

	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=11)
    private int id;
    @Column(name="commentaire_recule", nullable=true, length=255)
    private String nom;

    @JsonBackReference(value="activite")
    @OrderBy("date ASC")
    @OneToMany(mappedBy="ecole",cascade =CascadeType.ALL,orphanRemoval = true)
    private Set<Contenus> contenus;
    
    @JsonBackReference(value="ecole")
    @OneToMany(fetch = FetchType.LAZY,mappedBy="ecole",cascade = CascadeType.ALL,orphanRemoval = true)
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

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for commentaireRecule.
     *
     * @return the current value of commentaireRecule
     */
    public String getCommentaireRecule() {
        return nom;
    }

    /**
     * Setter method for commentaireRecule.
     *
     * @param aCommentaireRecule the new value for commentaireRecule
     */
    public void setCommentaireRecule(String aCommentaireRecule) {
        nom = aCommentaireRecule;
    }

   



    /**
     * Access method for activite.
     *
     * @return the current value of activite
     */
    public Set<Contenus> getContenus() {
        return contenus;
    }

    /**
     * Setter method for activite.
     *
     * @param aActivite the new value for activite
     */
    public void setContenus(Set<Contenus> contenus) {
        this.contenus = contenus;
    }
    
    public void addContenus(Contenus contenus) {
    	this.getContenus().add(contenus);
    }



    /**
     * Access method for utilisateur.
     *
     * @return the current value of utilisateur
     */
    public Set<Utilisateur> getUtilisateurs() {
        return utilisateur;
    }

    /**
     * Setter method for utilisateur.
     *
     * @param aUtilisateur the new value for utilisateur
     */
    public void setUtilisateur( Set<Utilisateur> aUtilisateur) {
        utilisateur = aUtilisateur;
    }
    
    public void addUtilisateur(Utilisateur utilisateur) {
    	this.getUtilisateurs().add(utilisateur);
    }
    
   


    
    /**
     * Compares the key for this instance with another Voyage.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Voyage and the key objects are equal
     */
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

    /**
     * Compares this instance with another Voyage.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Ecole)) return false;
        return this.equalKeys(other) && ((Ecole)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
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
