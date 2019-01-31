public class Test {

	public static void main(String[] args) {
		Student ash = new Student("Ash", 10);
		Student bob = new Student("Bob", 11);

		Course math = new Course("math");
		math.registerStudent(ash);
		math.registerStudent(bob);
		System.out.println(math.isFull());

		Student[] stuArr = math.getStudents(); 
		System.out.println(stuArr[0].getId());  
		System.out.println(stuArr[1].getName());      
		// System.out.println(math.getStudents()[0].toString());
	}
}

class Student{
	private String name;
	private int id;

	Student(String name, int id){
		this.name = name;
		this.id = id;
		System.out.println("my name is " + name + id);
	}

	public String getName(){ //Is this accessor method?
		return this.name;
	}

	public int getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setId(int id){
		this.id = id;
	}
}

class Course{    //Does this class also need accessor method?
	String title;
	int numberOfStudent = 0;
	Student[] studentArr = new Student[10];
	Course(String title){
		this.title = title;
	}

	public Student[] getStudents(){
		return studentArr;
	}

	public boolean isFull(){
		if(this.numberOfStudent <10){
			return false;
		}else{
			return true;
		}
	}

	public void registerStudent(Student a){
		if(this.numberOfStudent < 10){
			studentArr[numberOfStudent] = a;
			this.numberOfStudent++; 
		}else{
			throw new RuntimeException(this.title + " is full!");
		}
	}

}


