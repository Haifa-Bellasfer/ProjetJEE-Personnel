package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parking implements Serializable {
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	private String design;
	private String adrs;
	private String cap;
	
	@OneToMany(mappedBy="park")
	private List<Zone> zones;

	public Parking(String design, String adrs, String cap) {
		super();

		this.design = design;
		this.adrs = adrs;
		this.cap = cap;
	
	}

	public Parking() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getAdrs() {
		return adrs;
	}

	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	
	
	

}
