import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Laptop {

	@Id
	private int lId;
	private String lName;
	
	@ManyToMany
	private List<Student> st= new ArrayList<>();

	

	public List<Student> getSt() {
		return st;
	}

	public void setSt(List<Student> st) {
		this.st = st;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}


	
	
	
}
