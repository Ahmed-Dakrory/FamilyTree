package main.com.familyTree.loginNeeds;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="user.getAll",
		     query="SELECT c FROM user c"
		     )
	,
	@NamedQuery(name="user.getById",
	query = "from user d where d.id = :id"
			)
	
	,
	@NamedQuery(name="user.getByEmail",
	query = "from user d where d.email = :email"
			)
	
	,
	@NamedQuery(name="user.getAllWithRole",
	query = "from user d where d.role = :role"
			)
	
	,
	@NamedQuery(name="user.getByMailAndPassword",
	query = "from user d where d.email = :email and d.password = :password and active = :active"
			)
	
})

@Entity
@Table(name = "user")
public class user {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	
	@Column(name = "email")
	private String email;
	

	@Column(name = "password")
	private String password;
	

	@Column(name = "tokenId")
	private String tokenId;
	
	
	@Column(name = "imageGoogle")
	private String imageGoogle;
	
	

	public static int NormalAccount=0;
	public static int GoogleAccount=1;
	
	@Column(name = "accountType")
	private int accountType;

	public static int ROLE_ADMIN=0;
	public static int ROLE_User=1;

	@Column(name = "role")
	private Integer role;
	
	
	@Column(name="image")
	@Lob
	private byte[] image;


	@Column(name = "active")
	private Integer active;
	

	@Column(name = "date")
	private Calendar date;

	@Column(name = "lastUpdate")
	private Calendar lastUpdate;

	

	public Calendar getLastUpdate() {
		return lastUpdate;
	}





	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}







	public Integer getRole() {
		return role;
	}




	public void setRole(Integer role) {
		this.role = role;
	}




	public byte[] getImage() {
		return image;
	}




	public void setImage(byte[] image) {
		this.image = image;
	}




	public Integer getActive() {
		return active;
	}




	public void setActive(Integer active) {
		this.active = active;
	}


	
	
	public String getTokenId() {
		return tokenId;
	}





	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}





	public int getAccountType() {
		return accountType;
	}





	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}





	public Calendar getDate() {
		return date;
	}





	public void setDate(Calendar date) {
		this.date = date;
	}





	public String getRoleString() {
		if(role==ROLE_ADMIN) {
			return "Admin";
		}else {
			return "User";
		}
	}

	
	
	public String getImageGoogle() {
		return imageGoogle;
	}





	public void setImageGoogle(String imageGoogle) {
		this.imageGoogle = imageGoogle;
	}





	public String getphoto() {
		if(getImage()!=null ||getImageGoogle()!=null) {
			if(accountType==NormalAccount) {
				String imageString= new String(Base64.encodeBase64(image));
		
				return "data:image/png;base64, "+imageString;
			}else {
				return getImageGoogle();
			}
		}else {
			return "/resources/images/comment-img3.jpg";
		}
	}

}
