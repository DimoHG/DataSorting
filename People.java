package helloWorld;

public class People {
	private String name;
	private int birthDate;
	private int number;

	
	public People(int number, String name, int birthDate) {
		this.name=name;
		this.birthDate=birthDate;
		this.number=number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
	

}
