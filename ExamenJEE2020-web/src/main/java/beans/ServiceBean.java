package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Personnel;
import entities.Post;
import entities.Zone;
import interfaces.ServiceRemot;

@SessionScoped
@ManagedBean
public class ServiceBean {

	@EJB
	ServiceRemot service;
	private String login;
	private int id;
	private  Personnel p;
	private List<Zone> zones ;
	private String ref;
	private float dimension;
	
	
	
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Personnel getP() {
		return p;
	}
	public void setP(Personnel p) {
		this.p = p;
	}
	public ServiceRemot getService() {
		return service;
	}
	public void setService(ServiceRemot service) {
		this.service = service;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	

	public List<Zone> getZones() {
		return zones;
	}
	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}
	
	
	@PostConstruct
	public void getZone() {
		List<Zone> z1 = service.getZoneById();
		System.out.println(z1);
		
		for (Zone zone : z1) {
			if(zone.getPerso().getPost().equals(Post.gardeNuit)) {
				zones.add(zone);
			}
			
		}
	
	}
}
