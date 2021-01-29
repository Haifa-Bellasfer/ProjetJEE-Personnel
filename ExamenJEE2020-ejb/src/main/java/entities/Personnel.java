package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Personnel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486015292778116931L;
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private Date datRec;
	private String login;
	private String password;
	@Enumerated(EnumType.STRING)
	private Post post;
	@ManyToOne
	private Zone zone;
	@OneToOne(mappedBy="perso")
	private Zone zon;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDatRec() {
		return datRec;
	}
	public void setDatRec(Date datRec) {
		this.datRec = datRec;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

	
	public Zone getZon() {
		return zon;
	}
	public void setZon(Zone zon) {
		this.zon = zon;
	}
	public Personnel(String nom, String prenom, int age, Date datRec, String login, String password, Post post) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.datRec = datRec;
		this.login = login;
		this.password = password;
		this.post = post;
		
	}
	public Personnel() {
		super();
	}
	
	
	
	
}
