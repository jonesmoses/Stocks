
public class ArrayStack <E> implements StackInterface <E>{
	static Stocks stock;
	private E[] theData;
	private int topOfStack = -1;
	private static final int INITIAL_CAPACITY = 10;
	public ArrayStack(){
		this.theData = (E[]) new Object[INITIAL_CAPACITY];
	}
	public ArrayStack(int size){
		this.theData = (E[]) new Object[size];
	}
	@Override
	public E push(E obj) {
				if(this.topOfStack == this.theData.length - 1){
			System.out.println("Stack Overflow!");
			return null;
		}		
		topOfStack++;
		this.theData[topOfStack] = obj;
		return obj;		
	}
	@Override
	public E pop() {
		if(this.empty()){
			System.out.println("Stack Overflow!!");
			return null;
		}
		return this.theData[topOfStack--];
	}
	@Override
	public E peek() {
		if(this.empty()){
			System.out.println("Stack Empty!");
			return null;
		}
		return this.theData[topOfStack];
	}
	@Override
	public boolean empty() {
		return (topOfStack == -1);
	}
	public void display(){
		System.out.println("Stock prices for the day: ");
		for(int i = 0; i <= topOfStack; i++){
			System.out.println("$" +this.theData[i] + " at the " + stock.getTime()+ "th hour today");
		}
	}
}
