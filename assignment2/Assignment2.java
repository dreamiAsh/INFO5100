
import java.util.Arrays;

/*
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to finish the extra credit question. 
 * The deadline of this assignment is 01/25/2019 23:59 PST.
 * Please feel free to contact Fiona for any questions.
 * TA office hour: Tuesday 1 pm -- 4 pm
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
    	//write your code here
    	this.name = name;
    	this.age = age;
    	this.gender = gender;
    	this.salary = salary;
    }
    
    // Getter for `name`. Return the current `name` data
    public String getName() {
    	//write your code here
    	return this.name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
    	//write your code here
    	this.name = name;
    	
    }
    
    
    public void raiseSalary(double byPercent) {
    	this.salary = this.salary * ( 1 + byPercent);
    	System.out.println(this.salary);
    }
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2{
    // Assignment
    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        //write your code here
    	if(employee != null) {
    		if(employee.salary <= 8900.00) {
    			double res = employee.salary * 0.062;
        		System.out.println(res);
        		return employee.salary * 0.062;
        	}else {
        		
        		System.out.println(106800.00 * 0.062);
        		return 106800.00 * 0.062;
        	}
    	}else {
    		return 0;
    	}
    	
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public static double insuranceCoverage(Employee employee) {
        //write your code here
    	if(employee != null) {
    		if(employee.age < 35) {
    			return employee.salary * 0.03;
    		}else if(employee.age >= 35 && employee.age <= 50) {
    			return employee.salary * 0.04;
    		}else if(employee.age > 50 && employee.age < 60) {
    			return employee.salary * 0.05;
    		}else if(employee.age >= 60) {
    			return employee.salary * 0.06;
    		}
    	}else {
    		return 0;
    	}
    	return 0;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public static void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
    	Employee[] employees = new Employee[] {e1, e2, e3};
    	
    	Arrays.sort(employees, (a, b) -> Double.compare(a.salary, b.salary));
    	
    	for (Employee i : employees) {
    		System.out.println(i.name + " " + i.salary);
    	}
    	    	
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)  
     */
    public static void tripleSalary(Employee employee) {
        //write your code here
    	System.out.println(employee.salary * 3);
    }
   


    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     Your Answer:
     Because when we put param in a function, the functurn will generate a new variable to store the old variable's value or reference. 
     So although the new variable changed value, it does not influent the old variable's value or reference.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2100);
        Employee c = new Employee("Ash", 18, Gender.FEMALE, 2300);
        
        a.raiseSalary(0.1);
        new Assignment2().socialSecurityTax(a);
        System.out.println(Assignment2.insuranceCoverage(a));
        
        System.out.println("----------------sortSalary---------------");
        sortSalary(a, b, c);
        System.out.println("---------------tripleSalary----------------");
        tripleSalary(c);
        System.out.println("-------------------------------");
        
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);//
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
        
        
        // test
        System.out.println("----------------test---------------");
        int x = 1, y = 2;
        System.out.println("Before: x=" + x);
        System.out.println("Before: y=" + y);
        swap2(x, y);//
        System.out.println("After: x=" + x);
        System.out.println("After: y=" + y);
    }
    
    public static void swap2(int x, int y) {
    	int temp = x;
    	x = y;
    	y = temp;
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}