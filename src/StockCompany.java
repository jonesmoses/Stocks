import java.util.*;
public class StockCompany {
	static Scanner input = new Scanner(System.in); //declare Scanner that will be used for a few methods
	static String bussName;
	static String id;							//Fields for constructor
	static String password;
	static double stckPrice;
	static ArrayStack<Double> stockStack = new ArrayStack<>();
	static ArrayStack<Double> highStack = new ArrayStack<>();    // Stacks that will be used for methods
	static ArrayStack<Double> lowStack = new ArrayStack<>();
	static int [] stackLocation = new int[1];
	static StockCompany [] company = new StockCompany[10];	// Arrays that will be used in methods (Were not too necessary)
	static Stocks [] stockArr = new Stocks[10];
	static StockCompany business;
	static Stocks stock1;					//Objects to be used in methods
	public StockCompany(){ //Default constructor
		bussName = null;
		this.id = null;
		this.password = null;
		this.stckPrice = 0;
	}
	public StockCompany(String oBussName, String oId, String oPassword ){ //Overloaded constructor
		bussName = oBussName;
		id = oId;
		password = oPassword;
	}
	public String toString(){ // Method to obtain name of business and price of stock
		return ("Business: " + bussName + ", Price: $" + stckPrice);
	}
	public static StockCompany addBusiness(){ //Method to add business
		System.out.println("Enter a business name");
		input.nextLine();
		bussName = input.nextLine(); //Creates name of business
		
		System.out.println("Enter an ID number for this business (MUST BE AT LEAST 8 CHARACTERS LONG)");
		id = input.nextLine(); //Creates ID
		
		if(id.length() < 8) //Checks to see if ID is shorter than 8 characters 
		{	
			System.out.println("ERROR PLEASE ENTER ID WITH AT LEAST 8 CHARACTERS"); //if shorter than 8 programs asks for user to 
			System.out.println("Enter an ID number for this business");				// input ID again
			id = input.next();
			if(id.length() < 8) { //checks again to see if ID is shorter than 8 characters
			for (int i = 0; i < 1; i++){
				int randID; 
				randID= (int)(Math.random()*10000000 + 22222222);
				id = id.valueOf(randID);
				System.out.println("ERROR... \n GENERATING RANDOM ID...... \n Your randomly generated ID is " + id); 
				//If still too short after second attempt program randomly generates 8digit ID for user
			}
		}
	}	
		for(;;){ //infinite loop 
			System.out.println("Enter a password (MUST BE AT LEAST 8 CHARACTERS LONG)"); 
		password = input.next();
		if (password.length()>= 8) // Checks to see if the password is 8 characters or more
			break;					// If true, loop breaks and takes password & if not loop continues
		}
		System.out.println("Enter a price");
		stckPrice = input.nextDouble();  // Price is created
		stockStack.push(stckPrice);   
		stock1 = new Stocks(stckPrice); //Creates both objects from user input
		business = new StockCompany(bussName,id,password);
		return business;
	}
	public static void displayBus(){
		System.out.println("Enter your ID");
		String id2 = input.next();
		System.out.println("Enter a password");     //Asks user for login info
		String password2 = input.next();
			
			if(id2.equals(id) && password2.equals(password)){ //Checks to see if user input matches one previously stores
				System.out.println(business.toString()); //If there is a match 
			}
			else {
				System.out.println("ERROR: INCORRECT PASSWORD/ID. \n PLEASE TRY AGAIN!!");	//If login information is wrong loop will check again
				for(;;){ //infinite loop 
					System.out.println("Enter your ID");
					id2 = input.next();
					System.out.println("Enter a password");     //Asks user again for login info
					password2 = input.next();
					if(id2.equals(id) && password2.equals(password)){ // Checks to see if the password is 8 characters or more
						System.out.println(business.toString());
						break;	
						}				// If true, loop breaks and takes password & if not loop continues
				}
				}
			}
	public static void logChanges(){// Method that allows user to log a change to the stock price
		System.out.println("Enter the new price of the stock obtained an hour ago");
		double newPrice = input.nextDouble();   // Asks user for new price of stock
		stockStack.push(newPrice);
		highStack.push(newPrice);					//New price is added to both the object stock and the stack
		lowStack.push(newPrice);
		stock1.changePrice(newPrice);
	}
	public static void displayAllRev(){ //Method that prints out the stack in reverse
		ArrayStack<Double> tempStack = new ArrayStack<>();  //Temporary stack that will hold reversed values
		while(!stockStack.empty()){
			tempStack.push(stockStack.pop());  //Elements from the original stack are being popped off and pushed into the new stack
		}
		System.out.print("(Reverse)");
		tempStack.display();				//Values in stack are printed in reverse
	}
	public static void displayHigh(){ //Method used to print the highest value stock
		double max =0 , temp;                          //variables used to hold values
		ArrayStack<Double> tempStack = new ArrayStack<>();	
		for (double i = 0; i < 1; i++){
			temp = highStack.pop();     //Temporary stack holds the last element of stack
			if (temp > max){      	//Top of stack is then compared to "max" value  
				max = temp;			// If larger than value, the max becomes equivalent to the temporary value
				System.out.println("The highest stock price is : $" +max+ " at the " + stock1.getTime()+ "th hour of the day ");
				//Prints out highest priced stock
			}
			else
				continue;
		}
	}
	public static void displayLow(){ //Method used to print out the lowest stock value
		double min = 100000000, temp;	//variables used to hold values, will be a lot like displayHigh(), but in reverse
		ArrayStack<Double> tempStack = new ArrayStack<>();
		for (double i = 0; i < 1; i++){		
			temp = stockStack.pop();  //Temporary stack holds the last element of stack
			if (temp < min){	//Top of stack is then compared to "minimum" value 
				min = temp;		// If smaller than value, the max becomes equivalent to the temporary value
				System.out.println("The lowest stock price is : $" +min+ " at the " + stock1.getTime()+ "th hour of the day ");
				//Prints out lowest priced stock
			}		
			else
				continue;
		}
	}
	public static void dayEnd(){ //Method that user will select when they want to call it a day 
		System.out.println("STACK EMPTYING PLEASE WAIT");
		System.out.println("..........................");
		stockStack.pop(); //empties stack
		System.out.flush();
		System.out.println("------------------------");
		System.out.println("LOGGING OUT.... GOODBYE!!!");
		System.out.println("------------------------");
		
	}
	public static void welcomePage(){ //Page that first appears when program is ran
		System.out.println("------------------------");
		System.out.println("WELCOME TO MYSTOCK MOBILE");
		System.out.println("------------------------");
	}
	public static void menu(){ //Menu that will drive the program
		welcomePage();
		System.out.println("     MAIN MENU  ");
		System.out.println("******************");
		System.out.println("Would you like to \n 1.Register a new business \n 2.Login \n 3.Log changes in stock prices \n 4.Display prices \n 5.Find highest stock price \n 6.Find lowest stock price \n 7.Exit app ");
		int choice = input.nextInt();
		switch(choice){
		case 1:
			addBusiness();
			menu();
			break;
		case 2: 
			displayBus();
			menu();
			break;
		case 3:
			logChanges();
			menu();
			break;
		case 4:
			displayAllRev();
			menu();
			break;
		case 5:
			displayHigh();
			menu();
			break;
		case 6:
			displayLow();
			menu();
			break;
		case 7: 
			dayEnd();
			menu();
			break;
		default: 
				menu();
		}
	}
}