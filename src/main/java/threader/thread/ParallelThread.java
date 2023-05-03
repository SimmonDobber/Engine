package threader.thread;

import java.util.function.Consumer;

import lombok.Getter;
import threader.ThreaderBean;
import threader.synchronizedCollection.SynchronizedCollection;
import threader.synchronizedCollection.SynchronizedList;

public class ParallelThread<T> implements ThreadedConsumer {

	@Getter
	private final Thread thread;
	private final SynchronizedCollection<T> synchronizedCollection;
	private final Consumer<SynchronizedCollection<T>> parallelOperation;
	private final Consumer<T> consumer;

	public ParallelThread(Consumer<SynchronizedCollection<T>> parallelOperation, Consumer<T> consumer) {
		this.synchronizedCollection = new SynchronizedList<>();
		this.parallelOperation = parallelOperation;
		this.consumer = consumer;
		this.thread = new Thread(() -> this.parallelOperation.accept(this.synchronizedCollection));
		ThreaderBean.getThreader().addConsumer(this);
		this.thread.start();
	}

	public void consume() {
		while (!this.synchronizedCollection.isEmpty()) {
			this.consumer.accept(this.synchronizedCollection.takeElement());
		}
	}

}
