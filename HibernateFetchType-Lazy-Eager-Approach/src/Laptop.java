import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Laptop 
{
	@Id
	private int lId;
	private String brand;
	private double price;
	
	@ManyToOne
	private Student st;

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}
	
	
	

}
