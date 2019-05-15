package main.com.familyTree.controlUsersBean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import main.com.familyTree.loginNeeds.loginBean;
import main.com.familyTree.loginNeeds.user;
import main.com.familyTree.loginNeeds.userAppServiceImpl;


@ManagedBean(name = "controlUsersBean")
@SessionScoped
public class controlUsersBean{
	
	

	@ManagedProperty(value = "#{userFacadeImpl}")
	private userAppServiceImpl userDataFacede; 
	private user theUserOfThisRegisteration;
	private String passwordOfRegisteration;
	private String passwordConfirm;
	
	@ManagedProperty(value = "#{loginBean}")
	private loginBean loginBean; 
	
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void refresh(){
		
		emptyFieldsOFRegisteration();
	}

	public void emptyFieldsOFRegisteration() {
		theUserOfThisRegisteration=new user();
		passwordOfRegisteration="";
		passwordConfirm="";
	}

	
	
	public void showDetails() {
		System.out.println("Dakrory: "+theUserOfThisRegisteration.getImageGoogle());
		System.out.println("Dakrory: "+theUserOfThisRegisteration.getEmail());
		System.out.println("Dakrory: "+theUserOfThisRegisteration.getName());
	}
	
	
public void RegisterNewUser(){
		
		user u_active =userDataFacede.getByEmail(theUserOfThisRegisteration.getEmail());

		if(u_active!=null) {
			
			if(theUserOfThisRegisteration.getAccountType()==user.GoogleAccount) {
				u_active.setImageGoogle(theUserOfThisRegisteration.getImageGoogle());
				u_active.setName(theUserOfThisRegisteration.getName());
				u_active.setTokenId(theUserOfThisRegisteration.getTokenId());
				validateUser(u_active);
			}else {
				PrimeFaces.current().executeScript("swal({\r\n" + 
						"  title: \"This Account Registered Already \",\r\n" + 
						"  text: \"please try again with different account!\",\r\n" + 
						"  icon: \"warning\",\r\n" + 
						"})\r\n" + 
						";");
			}
	
		}else {

			theUserOfThisRegisteration.setDate(Calendar.getInstance());
		validateUser(theUserOfThisRegisteration);
		
		}
		
		
	}

	private void validateUser(user theUserOfThisAccount2) {
		// TODO Auto-generated method stub
		boolean ok=false;
	
			
		if(passwordOfRegisteration.equals(passwordConfirm)&&!passwordOfRegisteration.equals("")&&passwordOfRegisteration!=null){
			ok=true;
		}
		
		
		if(ok){
			
			completeRegisteration(theUserOfThisAccount2);
			
			
		}else{
			pleaseCheck();
			
		}
	}

	private void pleaseCheck() {
		// TODO Auto-generated method stub
		PrimeFaces.current().executeScript("swal({\r\n" + 
				"  title: \"Check this \",\r\n" + 
				"  text: \"Please Make sure that the Passwords are the same!\",\r\n" + 
				"  icon: \"warning\",\r\n" + 
				"})\r\n" + 
				";");
		
	}
	
	private void completeRegisteration(user theUserOfThisAccount2) {
		// TODO Auto-generated method stub
		theUserOfThisAccount2.setPassword(new  Md5PasswordEncoder().encodePassword(passwordOfRegisteration,theUserOfThisAccount2.getEmail()));
		theUserOfThisAccount2.setActive(1);
		theUserOfThisAccount2.setRole(user.ROLE_User);
		
		userDataFacede.adduser(theUserOfThisAccount2);
		
		
		loginBean.setPasswordOfUserLoggedIn(passwordOfRegisteration);
		loginBean.setEmailOfUserLoggedIn(theUserOfThisAccount2.getEmail());
		loginBean.login(theUserOfThisRegisteration.getAccountType());
	
	}

	public void handleImageUpload(FileUploadEvent event) {

		theUserOfThisRegisteration.setImage(event.getFile().getContents());
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
	
	public user getTheUserOfThisRegisteration() {
		return theUserOfThisRegisteration;
	}

	public void setTheUserOfThisRegisteration(user theUserOfThisRegisteration) {
		this.theUserOfThisRegisteration = theUserOfThisRegisteration;
	}

	public String getPasswordOfRegisteration() {
		return passwordOfRegisteration;
	}

	public void setPasswordOfRegisteration(String passwordOfRegisteration) {
		this.passwordOfRegisteration = passwordOfRegisteration;
	}

	public userAppServiceImpl getUserDataFacede() {
		return userDataFacede;
	}

	public void setUserDataFacede(userAppServiceImpl userDataFacede) {
		this.userDataFacede = userDataFacede;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	

	public loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(loginBean loginBean) {
		this.loginBean = loginBean;
	}


	
}
