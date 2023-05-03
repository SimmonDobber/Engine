package scene;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import common.Interactive;
import common.Visual;
import display.Display;
import display.DisplayBean;
import display.HoverMark;
import input.Input;
import input.InputBean;
import input.inputCombination.InputCombination;
import scene.priorityCollection.PriorityCollection;
import scene.priorityCollection.PriorityList;
import scene.priorityCollection.SceneCollection;

public class SceneBean implements Scene {

	private static SceneBean scene;
	private final Display display;
	private final Input input;
	private final Map<String, SceneCollection> objectCollections;
	private final Map<InputCombination, Interactive> globallyActivatedObjects;
	private SceneCollection currentObjectCollection;

	private SceneBean() {
		this.display = DisplayBean.getDisplay();
		this.input = InputBean.getInput();
		this.objectCollections = new HashMap<>();
		this.globallyActivatedObjects = new HashMap<>();
	}

	public static Scene getScene() {
		if (scene == null) {
			scene = new SceneBean();
		}
		return scene;
	}

	@Override
	public void updateAndDraw() {
		if (this.currentObjectCollection != null) {
			updateTopObjectHoverMark();
			updateGloballyActivatedObjects();
			this.display.setObjectsToDraw(scene.getCurrentObjectCollection());
			this.display.draw();
		}
	}

	private void updateTopObjectHoverMark() {
		HoverMark hoverMark = HoverMark.getHoverMark();
		if (this.currentObjectCollection != null) {
			this.currentObjectCollection.remove(hoverMark);
		}
		Visual topObject = getTopObject();
		if (topObject instanceof Interactive) {
			((Interactive) topObject).update();
			hoverMark.fitHoverMarkToDrawable(topObject.getDrawable());
			this.currentObjectCollection.setHigherThan(hoverMark, topObject);
		}
	}

	private void updateGloballyActivatedObjects() {
		for (InputCombination activationCombination : this.globallyActivatedObjects.keySet()) {
			if (activationCombination.isActive()) {
				this.globallyActivatedObjects.get(activationCombination).update();
			}
		}
	}

	@Override
	public void initializeListeners() {
		this.input.addInputListener(this);
	}

	@Override
	public void addObjectLowerThan(Visual inserted, Visual contained) {
		this.currentObjectCollection.setLowerThan(inserted, contained);
	}

	@Override
	public void addObjectHigherThan(Visual inserted, Visual contained) {
		this.currentObjectCollection.setHigherThan(inserted, contained);
	}

	@Override
	public void addOnHighest(Visual inserted) {
		this.currentObjectCollection.setOnHighest(inserted);
	}

	@Override
	public void addOnLowest(Visual inserted) {
		this.currentObjectCollection.setOnLowest(inserted);
	}

	@Override
	public void clear() {
		this.currentObjectCollection.clear();
	}

	@Override
	public void removeObject(Visual removed) {
		this.currentObjectCollection.remove(removed);
	}

	@Override
	public Collection<Visual> getCurrentObjectCollection() {
		Collection<Visual> currentObjectCollection = null;
		if (this.currentObjectCollection != null) {
			currentObjectCollection = this.currentObjectCollection.getObjectCollection();
		}
		return currentObjectCollection;
	}

	@Override
	public Visual getTopObject() {
		Visual topObject = null;
		int x = this.input.getMouseX();
		int y = input.getMouseY();
		if (this.currentObjectCollection != null) {
			topObject = this.currentObjectCollection.getTopObjectOnPosition(x, y);
		}
		return topObject;
	}

	@Override
	public void switchCollection(String collectionName) {
		this.currentObjectCollection = this.objectCollections.get(collectionName);
	}

	@Override
	public void addCollection(String collectionName) {
		PriorityCollection priorityCollection = new PriorityList();
		SceneCollection sceneCollection = new SceneCollection(priorityCollection);
		this.objectCollections.put(collectionName, sceneCollection);
	}

	@Override
	public void removeCollection(String collectionName) {
		if (this.objectCollections.containsKey(collectionName)) {
			boolean isCurrentCollectionToBeRemoved = this.objectCollections.get(collectionName).equals(this.currentObjectCollection);
			if (isCurrentCollectionToBeRemoved) {
				this.currentObjectCollection = null;
			}
			this.objectCollections.get(collectionName).clear();
			this.objectCollections.remove(collectionName);
		}
	}

	@Override
	public void addGloballyActivatedObject(InputCombination activationCombination, Interactive object) {
		this.globallyActivatedObjects.put(activationCombination, object);
	}

	@Override
	public void removeGloballyActivatedObject(Interactive object) {
		this.globallyActivatedObjects.values().remove(object);
	}

}
