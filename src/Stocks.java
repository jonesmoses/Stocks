
public class Stocks { //Class that creates the object Stock
	static double price;
	public static int time;
	public Stocks(){ //Default constructor
		time = 9;
		time = time++;
		price = 0;
	}
	public Stocks(double p){ //Overloaded constructor
		time = 9;
		time = time++;
		this.price = p;
	}
	public static double changePrice(double p){ //Method that changes the price of the stock
		price = p;
		return price;
	}
	public static int getTime(){ //Method used to return the time
		time++;
		return time;
	}
	public static double getPrice(){ //Method used to return the price of the stock
		return price;
	}
	public String toString(){	//Method that rerutns the stock as a string
		return ("Stock Price:$" +price+ " @ " + time);
	}
}
