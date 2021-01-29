package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Parking;
import entities.Personnel;
import entities.Post;
import entities.User;
import entities.Zone;

import interfaces.ServiceRemot;

@Stateless
@LocalBean
public class ServiceImp implements ServiceRemot {

	@PersistenceContext
	EntityManager em; 
	
	
	@Override
	public void addUser(User u) {
		em.persist(u);
		
	}


	@Override
	public Personnel getEmployeByEmailAndPassword(String email, String password) {
		TypedQuery<Personnel> query =
				em.createQuery("SELECT e FROM Personnel e WHERE e.login=:email AND e.password=:password", Personnel.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				Personnel user = null;
				
				try {
				user = query.getSingleResult();
				
				}
				catch (Exception e) {
				System.out.println("Erreur :" +e);
				}
				System.out.println(user);
				return user;
	}


	@Override
	public void ajouterPersonnel(Personnel personnel) {
		em.persist(personnel);	
	}


	@Override
	public void ajoutParkingetZones(Parking parking, List<Zone> listeZones) {
		
		
		
		parking.setZones(listeZones);
		em.persist(parking);
		for (Zone zone : listeZones) {
			zone.setPark(parking);
			em.persist(zone);
		}
	}


	@Override
	public List<Personnel> listerPersonnel() {
		List<Personnel> emp = em.createQuery("Select e from Personnel e", Personnel.class).getResultList();
		return emp;
	}


	@Override
	public void affecterPersonnelZone(int idzone, int idGarde, Post poste) {
	

		Zone e = em.find(Zone.class, idzone);
		Personnel d = em.find(Personnel.class, idGarde);
		e.setPerso(d);
		
		em.merge(e);
		d.setZon(e);
		em.persist(d);
		
	}


	@Override
	public List<Zone> getZoneById() {
		List<Zone> emp = em.createQuery("Select e from Zone e ", Zone.class).getResultList();
		return emp;
	}
	



}
