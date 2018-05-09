package journals;

public class Animal {
	String type;
	String gender;
	public Animal(){
		type = "dd";
		gender = "aa";
	}
	
	public Animal(String ty, String gen){
		type = ty;
		gender = gen;
	}
	public String getType(){
		return type;
	}
	
	public String getGender(){
		return gender;
	}
}
