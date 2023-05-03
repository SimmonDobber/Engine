package threader.synchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import threader.CountLatch;
import threader.ThreaderBean;

public class SynchronizedList<T> implements SynchronizedCollection<T> {

	private final List<T> list;
	private final CountLatch countLatch;

	public SynchronizedList() {
		this.list = Collections.synchronizedList(new ArrayList<>());
		this.countLatch = ThreaderBean.getThreader().getCountLatch();
	}

	@Override
	public synchronized T takeElement() {
		if (!this.list.isEmpty()) {
			T element = this.list.get(0);
			this.list.remove(element);
			return element;
		} else {
			return null;
		}
	}

	@Override
	public synchronized void put(T element) {
		this.list.add(element);
		this.countLatch.countDown();
	}

	@Override
	public synchronized boolean isEmpty() {
		return this.list.isEmpty();
	}

}
