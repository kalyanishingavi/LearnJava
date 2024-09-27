package Practice02;

public class Student {
	private String name;
	private int id;
	private String city;
	
	Student(){
		super();
	}
	
	Student(String name,int id, String city){
		this.name = name;
		this.id = id;
		this.city = city;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCity() {
		return this.city;
		
	}
	
	public String toString() {
		return "Id = "+id+" Name = "+name+" City = "+city;
	}
}
