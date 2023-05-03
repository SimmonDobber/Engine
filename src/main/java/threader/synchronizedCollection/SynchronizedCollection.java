package threader.synchronizedCollection;

public interface SynchronizedCollection<T> {

	T takeElement();

	void put(T element);

	boolean isEmpty();

}
