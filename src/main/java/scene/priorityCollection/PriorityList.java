package scene.priorityCollection;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import common.Visual;

public class PriorityList implements PriorityCollection {

	private final List<Visual> objects;

	public PriorityList() {
		this.objects = new LinkedList<>();
	}

	@Override
	public void setLowerThan(Visual inserted, Visual contained) {
		for (int i = 0; i < this.objects.size(); i++) {
			if (this.objects.get(i).equals(contained)) {
				this.objects.add(i, inserted);
				return;
			}
		}
	}

	@Override
	public void setHigherThan(Visual inserted, Visual contained) {
		for (int i = 0; i < this.objects.size(); i++) {
			if (this.objects.get(i).equals(contained)) {
				this.objects.add(i + 1, inserted);
				return;
			}
		}
	}

	@Override
	public void setOnLowest(Visual inserted) {
		if (!this.objects.contains(inserted)) {
			this.objects.add(0, inserted);
		}
	}

	@Override
	public void setOnHighest(Visual inserted) {
		if (this.objects.contains(inserted)) {
			this.objects.add(this.objects.size(), inserted);
		}
	}

	@Override
	public void clear() {
		this.objects.clear();
	}

	@Override
	public void remove(Visual removed) {
		this.objects.remove(removed);
	}

	@Override
	public Collection<Visual> getObjectCollection() {
		return this.objects;
	}

	@Override
	public Visual getLowest() {
		return this.objects.get(0);
	}

	@Override
	public Visual getHighest() {
		return this.objects.get(this.objects.size() - 1);
	}
}
