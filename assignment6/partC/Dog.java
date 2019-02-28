package partC;

import java.util.Calendar;

public class Dog extends Pet implements Boardable{
	private String size;
	private Calendar boardStart = Calendar.getInstance();
	private Calendar boardEnd = Calendar.getInstance();
	Dog (String name, String ownerName, String color, String s){
		super(name, ownerName, color);
		size = s;
	}
	public String getSize() {
		return size;
	} 
	public String toString() {
		return "DOG: " + getPetName() + " owned by " + getOwnerName() + ", color: " + getColor() + ", sex: " + getSex() + ", size: " + getSize();
	}
	public void setBoardStart(int month, int day, int year) {
		boardStart.set(2017, 2, 3);
	}
	public void setBoardEnd(int month, int day, int year) {
		boardEnd.set(2018, 1, 1);
	}
	public boolean boarding(int month, int day, int year) {
		Calendar temp  = Calendar.getInstance();
		temp.set(month, day, year);
		if(temp.getTimeInMillis() >= boardStart.getTimeInMillis() && temp.getTimeInMillis() <= boardEnd.getTimeInMillis()) {
			return true;
		}else {
			return false;
		}
	}
}

