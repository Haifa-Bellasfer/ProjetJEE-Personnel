package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Zone implements Serializable {
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	private String ref;
	private float dimension;
	
	@OneToMany(mappedBy="zone")
	private List<Personnel> perssonels;
	@ManyToOne
	private Parking park;
	@OneToOne
	private Personnel perso;

	
	public Zone(String ref, float dimension) {
		super();
		
		this.ref = ref;
		this.dimension = dimension;
		
	
	}
	public Zone() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public float getDimension() {
		return dimension;
	}
	public void setDimension(float dimension) {
		this.dimension = dimension;
	}
	public List<Personnel> getPerssonels() {
		return perssonels;
	}
	public void setPerssonels(List<Personnel> perssonels) {
		this.perssonels = perssonels;
	}
	public Parking getPark() {
		return park;
	}
	public void setPark(Parking park) {
		this.park = park;
	}
	
	public Personnel getPerso() {
		return perso;
	}
	public void setPerso(Personnel perso) {
		this.perso = perso;
	}


	
	

}
