package main.com.familyTree.nodes;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
	
	
	@NamedQuery(name="node.getAll",
		     query="SELECT c FROM node c"
		     )
	,
	@NamedQuery(name="node.getById",
	query = "from node d where d.id = :id"
			)
	,
	@NamedQuery(name="node.getByNameAndFatherAndGrand",
	query = "from node d where d.firstName = :firstName and d.fatherId.firstName =:fatherIdName and d.grandPaId.firstName =:grandPaIdName"
			)
	
	,
	@NamedQuery(name="node.getSonsOfParent",
	query = "from node d where d.fatherId = :fatherId"
			)
	
	,
	@NamedQuery(name="node.getSonsOfGrand",
	query = "from node d where d.grandPaId = :grandPaId"
			)
	
	
	
})

@Entity
@Table(name = "node")
public class node {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;


	@Column(name = "firstName")
	private String firstName;
	

	@ManyToOne
	@JoinColumn(name = "fatherId")
	private node fatherId;
	

	@ManyToOne
	@JoinColumn(name = "motherId")
	private node motherId;
	

	@ManyToOne
	@JoinColumn(name = "grandPaId")
	private node grandPaId;

	
	@Column(name = "comfirmNum")
	private Integer comfirmNum;

	
	@Column(name = "date")
	private Calendar date;
	
	@Column(name = "lastUpdate")
	private Calendar lastUpdate;

	@Column(name="image")
	@Lob
	private byte[] image;

	
	
	
	
	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getFirstName() {
		return firstName;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public node getFatherId() {
		return fatherId;
	}





	public void setFatherId(node fatherId) {
		this.fatherId = fatherId;
	}





	public node getMotherId() {
		return motherId;
	}





	public void setMotherId(node motherId) {
		this.motherId = motherId;
	}





	public node getGrandPaId() {
		return grandPaId;
	}





	public void setGrandPaId(node grandPaId) {
		this.grandPaId = grandPaId;
	}





	public Integer getComfirmNum() {
		return comfirmNum;
	}





	public void setComfirmNum(Integer comfirmNum) {
		this.comfirmNum = comfirmNum;
	}





	public Calendar getDate() {
		return date;
	}





	public void setDate(Calendar date) {
		this.date = date;
	}





	public Calendar getLastUpdate() {
		return lastUpdate;
	}





	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}





	public byte[] getImage() {
		return image;
	}





	public void setImage(byte[] image) {
		this.image = image;
	}





	public String getphoto() {
		if(getImage()!=null ) {
			String imageString= new String(Base64.encodeBase64(image));
		
			return "data:image/png;base64, "+imageString;
			
		}else {
			return "/resources/images/comment-img3.jpg";
		}
	}
	
	

}
