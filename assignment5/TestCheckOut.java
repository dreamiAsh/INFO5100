package package1;
import java.util.ArrayList;
import java.util.List;

public class TestCheckOut {
	public static void main(String[] args) {
		 Checkout checkout = new Checkout();
		 checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
		 checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
		 checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "HotFudge", 50));
		 checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
		 System.out.println("\nNumber of items: " + checkout.numberOfItems()+ "\n");
		 System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
		 System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
		 System.out.println("\nCost + Tax: " + (checkout.totalCost() +
		 checkout.totalTax()) + "\n");
		 System.out.println(checkout);
		 checkout.clear();
		 checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
		 checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel",50));
		 checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
		 checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
		 checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
		 checkout.enterItem(new Candy("Candy Corn", 3.0, 109));
		 System.out.println("\nNumber of items: " + checkout.numberOfItems()+ "\n");
		 System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
		 System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
		 System.out.println("\nCost + Tax: " + (checkout.totalCost() +
		 checkout.totalTax()) + "\n");
		 System.out.println(checkout);
	}
	
}
class Checkout{
	List<DessertItem> list = new ArrayList<>();
	DessertShoppe shop = new DessertShoppe();
	Checkout(){
		
	}
	public int numberOfItems() {
		return list.size();
	}
	public void enterItem(DessertItem item) {
		list.add(item);
	}
	public void clear() {
		list.clear();
	}
	
	public double totalCost() {
		int total = 0;
		for(DessertItem item : list) {
			total += item.getCost();
		}
		return shop.cents2dollarsAndCents(total);
	}
	public double totalTax() {
		int totalTax = (int)(totalCost() * shop.taxRate * 100);
		return shop.cents2dollarsAndCents(totalTax);
	}
	
	public String toString() {
		String name = "\n          " + shop.shopName;
		String res = "\n" + name + "\n\n" + "        -----------------------" + "\n\n";
		for(DessertItem item : list) {
			String name1 = "";
			String name2 = "";
			
			String cost = shop.cents2dollarsAndCents(item.getCost()) + "";
			if(item.getName().length() > 22) {
				String[] nameArr = item.getName().split(" ");
				for(int i=0; i<nameArr.length; i++) {
					if(i<4) name1 += nameArr[i] + " ";
					else name2 += nameArr[i] + " ";
				}
			}else {
				name1 = item.getName();
			}
			String fullName = name1;
			for(int i = 0; i < 40 - name1.length() - cost.length(); i++) {
				fullName += " ";
			}
			fullName += cost;
			
			res += "\n" + item.getUnitPrice();
			if(name2 != "") {
				res += "\n" + fullName + "\n";
				res += name2 + "\n";
			}else {
				res += "\n" + fullName + "\n";
			}
		}
		double Ftotal =  (totalTax() + totalCost())*1000;
		Ftotal = shop.cents2dollarsAndCents((int)Ftotal);
		res += "\n\nTax                                 " + totalTax();
		res +="\n\nToalCost                           " + Ftotal + "\n\n";
		res += "     -----------------------------";
		return res;
	}
}

class DessertShoppe{
	double taxRate = 0.1;
	String shopName = "M & M Dessert Shoppe";
	
	public double cents2dollarsAndCents(int cents) {
		return (double)(Math.round((double)cents/10))/100;
	}
}

abstract class DessertItem{
	public String name;
	public String type;
	DessertItem(String name, String type){
		this.name = name;
		this.type = type;
	}
	public final String getName() {
		return this.name;
	}
	public abstract String getUnitPrice();
	public abstract int getCost();
	
}

class Candy extends DessertItem{
	String name;
	double weight;
	double price;
	Candy(String name, double weight, double price){
		super(name, "candy");
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	public int getCost() {
		return (int)(weight * price * 10);
	}
	public String getUnitPrice() {
		return weight + " lbs. @ " + price/100 + " /lb.";
	}
}
class Cookie extends DessertItem{
	String name;
	double number;
	double price;
	Cookie(String name, double number, double price){
		super(name, "cookie");
		this.name = name;
		this.number = number;
		this.price = price;
	}
	public int getCost() {
		return (int)(price/12 * number * 10);
	}
	public String getUnitPrice(){
		return number + " @ " + price/100 + " /dz.";
	}
}
class IceCream extends DessertItem{
	String name;
	double price;
	IceCream(String name, double price) {
		super(name, "icecream");
		this.name = name;
		this.price = price;
	}
	public int getCost() {
		return (int)price *10;
	}
	public String getUnitPrice(){
		return "";
	}
}
class Sundae extends IceCream{
	String name;
	double price;
	Sundae(String iceName, double icePrice, String name, double price){
		super(iceName + " with " + name, icePrice + price);
		this.name = iceName + " with " + name;
		this.price = icePrice + price;
	}
}






