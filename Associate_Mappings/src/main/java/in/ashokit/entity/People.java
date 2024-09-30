package in.ashokit.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class People {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="people_chocolates",
	joinColumns = {
	        @JoinColumn(name = "people_id")
	    },
	    inverseJoinColumns = {
	        @JoinColumn(name = "chocolate_id")
	    })
	private List<Chocolate> chocolate;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Chocolate> getChocolate() {
		return chocolate;
	}
	public void setChocolate(List<Chocolate> chocolate) {
		this.chocolate = chocolate;
	}
	
	

}
