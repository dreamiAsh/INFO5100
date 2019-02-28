package partC;

public class Pet {
	public static final String[] sexName = {"MALE", "FEMALE", "SPAYED", "NEUTERED"};
	private String petName, ownerName, color;
	protected static int sex;
	public static void main(String[] args) {
		
		Cat c1 = new Cat("liuliu", "Lucy", "white", "long");
		c1.setSex(3);
		c1.setBoardStart(1, 1, 2019);
		c1.setBoardEnd(1, 8, 2019);
		System.out.println(c1);
		System.out.println(c1.boarding(1, 3, 2019));
		
		Dog d1 = new Dog("MM", "Peter", "Brown", "small");
		d1.setSex(2);
		d1.setBoardStart(1, 1, 2019);
		d1.setBoardEnd(1, 8, 2019);
		System.out.println(d1);
		System.out.println(d1.boarding(2, 3, 2019));
	}
	public Pet (String name, String oName, String c){
		petName = name;
		ownerName = oName;
		color = c;
	} 
	public String getPetName() {
		return petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getColor() {
		return color;
	}
	public void setSex(int sexid) {
		sex = sexid;
	}
	public String getSex() {  // Should return the string equivalent of the gender, e.g the string “MALE” etc. 
		return sexName[sex];
	}
	public String toString() {  // Should return the name, owner’s name, age, color, and gender (use getSex()); 
		return getPetName() + " owened by " + getOwnerName() + ", color: " + getColor() + ", sex: " + getSex();
	}

}
