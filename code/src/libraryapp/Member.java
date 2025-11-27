package libraryapp;

public class Member {
	private String memberID;
	private String firstName;
	private String lastName;
	private int age;
	
	public Member(String memberIDIn, String firstNameIn, String lastNameIn, int ageIn) {
		
		this.memberID = memberIDIn;
		this.firstName = firstNameIn;
		this.lastName = lastNameIn;
		this.age = ageIn;
		
		
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getID() {
		return memberID;
	}
	public int getAge() {
		return age;
	}
	
	public void setFirstName(String firstNameIn) {
		firstName = firstNameIn;
	}
	public void setLastName(String lastNameIn) {
		lastName = lastNameIn;
	}
	public void setAge(int ageIn) {
		age = ageIn;
	}
}
