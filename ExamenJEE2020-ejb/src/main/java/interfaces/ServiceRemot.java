package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Parking;
import entities.Personnel;
import entities.Post;
import entities.User;
import entities.Zone;


@Remote
public interface ServiceRemot {
	public void addUser(User u);
	public Personnel getEmployeByEmailAndPassword(String email, String password);
	
	public void ajouterPersonnel(Personnel personnel);
	public void ajoutParkingetZones(Parking parking, List<Zone>listeZones);
	public List<Personnel> listerPersonnel();
	public void affecterPersonnelZone(int idzone, int idGarde, Post poste);
	public List<Zone> getZoneById();


}
