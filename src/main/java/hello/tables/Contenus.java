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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name="contenus")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contenus implements Serializable {

  
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Primary key. */
    protected static final String PK = "id";

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;

    @Column(nullable=true, length=60)
    private Date date;
    @Column(nullable=false)
    private String content;

    @Column(nullable=false, length=255)
    private String titre;
    
    @Column(nullable=true, length=255)
    private String photo;
    
//    @JsonManagedReference(value="UtilisateurContenus") 
    @ManyToOne(optional=false,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
   private  Utilisateur utilisateur;
    

    
//    @JsonManagedReference(value="EcoleContenus")
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade=CascadeType.PERSIST)
	  private Ecole ecole;



    
    
    
    public Contenus() {
        super();
    }
    

    
    public String getPhoto() {
    	return photo;
    }
    
    public void setPhoto(String aphoto) {
    	photo = aphoto;
    }
    
    public Date getDate() {
    	return date;
    }
    
    public void setDate(Date aDate) {
    	date = aDate;
    }
 

    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Setter method for utilisateur.
     *
     * @param aUtilisateur the new value for utilisateur
     */
    public void setUtilisateur(Utilisateur aUtilisateur) {
        utilisateur = aUtilisateur;
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
     * Access method for commentaire.
     *
     * @return the current value of commentaire
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter method for commentaire.
     *
     * @param aCommentaire the new value for commentaire
     */
    public void setContent(String content) {
       this.content = content;
    }

    /**
     * Access method for note.
     *
     * @return the current value of note
     */
//    public int getNote() {
//        return note;
//    }
//
//    /**
//     * Setter method for note.
//     *
//     * @param aNote the new value for note
//     */
//    public void setNote(int aNote) {
//        note = aNote;
//    }

    /**
     * Access method for titre.
     *
     * @return the current value of titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Setter method for titre.
     *
     * @param aTitre the new value for titre
     */
    public void setTitre(String aTitre) {
        titre = aTitre;
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
     * Compares the key for this instance with another Activite.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Activite and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Contenus)) {
            return false;
        }
        Contenus that = (Contenus) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Activite.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Contenus)) return false;
        return this.equalKeys(other) && ((Contenus)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Contenus |");
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
