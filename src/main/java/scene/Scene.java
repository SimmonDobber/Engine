package scene;

import java.util.Collection;

import common.Interactive;
import common.Observer;
import common.Visual;
import input.inputCombination.InputCombination;

public interface Scene extends Observer {

    void updateAndDraw();

    void addObjectLowerThan(Visual inserted, Visual contained);

    void addObjectHigherThan(Visual inserted, Visual contained);

    void addOnHighest(Visual inserted);

    void addOnLowest(Visual inserted);

    void clear();

    void removeObject(Visual removed);

    Collection<Visual> getCurrentObjectCollection();

    Visual getTopObject();

    void switchCollection(String collectionName);

    void addCollection(String collectionName);

    void removeCollection(String collectionName);

    void initializeListeners();

    void addGloballyActivatedObject(InputCombination activationCombination, Interactive object);

    void removeGloballyActivatedObject(Interactive object);

}
