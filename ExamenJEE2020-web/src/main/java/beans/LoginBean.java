package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Personnel;
import entities.User;
import interfaces.ServiceRemot;


@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {
	@EJB
	ServiceRemot service;
	private Boolean loggedIn; 
    private String login;
	private String password;
	
	
	
	
	
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
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
	public ServiceRemot getService() {
		return service;
	}
	public void setService(ServiceRemot service) {
		this.service = service;
	}

	
	public String doLogin() {
		String lien = "null";

		Personnel user = service.getEmployeByEmailAndPassword(login, password);
		System.out.println(user);
		
		if (user != null ) {
			
		lien = "/pages/zone?faces-redirect=true";
		loggedIn = true;
		
		
		}

		else {
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return lien ;
		}
		
	

	
		public String doLogout() {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "/pages/login?faces-redirect=true";
			}

}
