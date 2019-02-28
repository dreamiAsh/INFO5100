package partC;

import java.util.Calendar;

public class Cat extends Pet implements Boardable{
	private String hairLength;
	private Calendar boardStart = Calendar.getInstance();
	private Calendar boardEnd = Calendar.getInstance();
	Cat (String name, String ownerName, String color, String hLength){
		super(name, ownerName, color);
		hairLength = hLength;
	}
	public String getHairLength() {
		return hairLength;
	} 
	public String toString() {
		return "CAT: " + getPetName() + " owned by " + getOwnerName() + ", color: " + getColor() + ", sex: " + getSex() + ", hairlength: " + getHairLength();
	}
	public void setBoardStart(int month, int day, int year) {
		boardStart.set(year, month, day);
	}
	public void setBoardEnd(int month, int day, int year) {
		boardEnd.set(year, month, day);
	}
	public boolean boarding(int month, int day, int year) {
		Calendar temp  = Calendar.getInstance();
		temp.set(year, month, day);
		if(temp.getTimeInMillis() >= boardStart.getTimeInMillis() && temp.getTimeInMillis() <= boardEnd.getTimeInMillis()) {
			return true;
		}else {
			return false;
		}
	}
}

