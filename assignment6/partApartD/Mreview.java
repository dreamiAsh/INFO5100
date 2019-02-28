package partApartD;

import java.util.*;

public class Mreview implements Comparable<Mreview>
{
  private String title;   
  private ArrayList<Integer> ratings = new ArrayList<>(); 
  
  Mreview(){}
  //Sets title to "" and creates an empty ArrayList to ratings.
  
  Mreview(String title){
	  this.title = title;
  }
  Mreview(String title, Integer rate){
	  this.title = title;
	  this.ratings.add(rate);
  }
  
  // methods
  public String getTitle(){
	  return title;
  }
  public void addRating(int r) {
	  ratings.add(r);
  }
  public double aveRating() {
	  double res = 0;
	  for(Integer i : ratings) {
		  res += (double)i;
	  }
	  return ratings.size() == 0 ? res : res/ratings.size();
  }
  public int numRatings() {
	  return ratings.size();
  }
  
  public int compareTo(Mreview obj){ 
	  return this.title.compareTo(obj.title);
  }
  public boolean equals(Object obj) { 
	  Mreview t = (Mreview) obj;
	  if (this.title.equals(t.title)) {
		  return true;
	  } else {
		  return false;
	  }
  }
  public String toString(){
	  return getTitle() + ", average " + aveRating() + " out of " + numRatings();
  }
}












