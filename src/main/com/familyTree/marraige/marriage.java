package main.com.familyTree.marraige;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import main.com.familyTree.nodes.node;



/**
 * 
 * @author Ahmed.Dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="marriage.getAll",
		     query="SELECT c FROM marriage c"
		     )
	,
	@NamedQuery(name="marriage.getById",
	query = "from marriage d where d.id = :id"
			)
	
	
	,
	@NamedQuery(name="marriage.getWomanMarriedManWithId",
	query = "from marriage d where d.manId = :manId"
			)
	
	
	
	
	
})

@Entity
@Table(name = "marriage")
public class marriage {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	

	@ManyToOne
	@JoinColumn(name = "manId")
	private node manId;
	

	@ManyToOne
	@JoinColumn(name = "womanId")
	private node womanId;
	

	public static int STATE_MARRIED=0;
	public static int STATE_DEFORCED=1;
	
	@Column(name = "state")
	private Integer state;
	
	@Column(name = "date")
	private Calendar date;
	
	@Column(name = "lastUpdate")
	private Calendar lastUpdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public node getManId() {
		return manId;
	}

	public void setManId(node manId) {
		this.manId = manId;
	}

	public node getWomanId() {
		return womanId;
	}

	public void setWomanId(node womanId) {
		this.womanId = womanId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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


	

}
