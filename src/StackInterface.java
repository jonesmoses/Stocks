// Author: Moses Jones
public interface StackInterface<E> {
	E push(E obj);
	E pop();
	E peek();
	boolean empty();
}
