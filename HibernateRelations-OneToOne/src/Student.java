import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{
	@Id
	private int rollNo;
	private String name;
	private int marks;
	
	
	@OneToOne
	private Laptop lap;


	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public Laptop getLap() {
		return lap;
	}


	public void setLap(Laptop lap) {
		this.lap = lap;
	}

	
	
}
