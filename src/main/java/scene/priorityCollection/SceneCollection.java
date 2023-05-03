package scene.priorityCollection;

import java.util.Collection;

import common.Visual;

public class SceneCollection {

	private final PriorityCollection priorityCollection;


	public SceneCollection(PriorityCollection priorityCollection) {
		this.priorityCollection = priorityCollection;
	}

	public Visual getTopObjectOnPosition(int x, int y) {
		Visual topObjectOnPosition = null;
		Collection<Visual> visuals = this.priorityCollection.getObjectCollection();
		for (Visual visual : visuals) {
			boolean isCursorInObjectBorders = visual.getDrawable().inBorders(x, y);
			boolean isPixelOnCursorPositionTransparent = visual.getDrawable().isPixelOnPositionTransparent(x, y);
			if (isCursorInObjectBorders && !isPixelOnCursorPositionTransparent) {
				topObjectOnPosition = visual;
			}
		}
		return topObjectOnPosition;
	}

	public void setLowerThan(Visual inserted, Visual contained) {
		this.priorityCollection.setLowerThan(inserted, contained);
	}

	public void setHigherThan(Visual inserted, Visual contained) {
		this.priorityCollection.setHigherThan(inserted, contained);
	}

	public void setOnLowest(Visual inserted) {
		this.priorityCollection.setOnLowest(inserted);
	}

	public void setOnHighest(Visual inserted) {
		this.priorityCollection.setOnHighest(inserted);
	}

	public void clear() {
		this.priorityCollection.clear();
	}

	public void remove(Visual removed) {
		this.priorityCollection.remove(removed);
	}

	public Collection<Visual> getObjectCollection() {
		return this.priorityCollection.getObjectCollection();
	}

	public Visual getLowest() {
		return this.priorityCollection.getLowest();
	}

	public Visual getHighest() {
		return this.priorityCollection.getHighest();
	}

}
