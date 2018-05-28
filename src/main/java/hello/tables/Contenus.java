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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name="contenus")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contenus implements Serializable {

  
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;

    @Column(nullable=true, length=60)
    private Date date;
    @Column(nullable=false)
    private String content;
//    @Column(nullable=false, precision=2)
//    private int note;
//    @Column(nullable=false, precision=2)
//    private int flags;
    
    @Column(nullable=false, length=255)
    private String titre;
    
    @Column(nullable=true, length=255)
    private String photo;
    
        
    @ManyToOne(optional=false,cascade = CascadeType.MERGE)
    private  Utilisateur utilisateur;
    
//    @Column(name="nb_likes",nullable=true,length=3)
//    private int nbLikes;
//    @Column(name="nb_commentaires",nullable=true,length=3)
//    private int nbCommentaires;
    
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade=CascadeType.PERSIST)
    private Ecole ecole;
    
//    @OrderBy("date ASC")
//    @JsonIgnore
//    @OneToMany(mappedBy="activite",fetch=FetchType.LAZY,cascade= CascadeType.ALL,orphanRemoval = true)
//    private Set<Commentaires> commentaires;
//    @JsonIgnore
//    @OneToMany(fetch=FetchType.LAZY,mappedBy="activite",cascade=CascadeType.ALL,orphanRemoval = true)
//    private Set<Likes> likes;

  
    
//    public int getFlags() {
//        return flags;
//    }
//
//    /**
//     * Setter method for flags.
//     *
//     * @param aFlags the new value for flags
//     */
//    public void setFlags(int aFlags) {
//        flags = aFlags;
//    }
    
    
    
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
 
//    public void addCommentaire(Commentaires commentaire) {
//      	 
//    	this.getCommentaires().add(commentaire);
//    	
//    }
//    
//    public void addLike(Likes like) {
//     	 
//    	this.getLikes().add(like);
//    	
//    }
    
//    public int getNbLikes() {
//    	return nbLikes;
//    }
//    public void setNbLikes(int nbLikes) {
//    	this.nbLikes = nbLikes;
//    }
//    
//    public int getNbCommentaires() {
//    	return nbCommentaires;
//    }
//    public void setNbCommentaires(int nbCommentaires) {
//    	this.nbCommentaires = nbCommentaires;
//    }
    
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
    public String getCommentaire() {
        return content;
    }

    /**
     * Setter method for commentaire.
     *
     * @param aCommentaire the new value for commentaire
     */
    public void setCommentaire(String content) {
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
     * Access method for commentaires.
     *
     * @return the current value of commentaires
     */
//    public Set<Commentaires> getCommentaires() {
//        return commentaires;
//    }
//
//    /**
//     * Setter method for commentaires.
//     *
//     * @param aCommentaires the new value for commentaires
//     */
//    public void setCommentaires(Set<Commentaires> aCommentaires) {
//        commentaires = aCommentaires;
//    }
//
//    /**
//     * Access method for likes.
//     *
//     * @return the current value of likes
//     */
//    public Set<Likes> getLikes() {
//        return likes;
//    }
//
//    /**
//     * Setter method for likes.
//     *
//     * @param aLikes the new value for likes
//     */
//    public void setLikes(Set<Likes> aLikes) {
//        likes = aLikes;
//    }

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
        StringBuffer sb = new StringBuffer("[Activite |");
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
