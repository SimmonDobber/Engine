package scene.priorityCollection;

import java.util.Collection;

import common.Visual;

public interface PriorityCollection {

    void setLowerThan(Visual inserted, Visual contained);

    void setHigherThan(Visual inserted, Visual contained);

    void setOnLowest(Visual inserted);

    void setOnHighest(Visual inserted);

    void clear();

    void remove(Visual removed);

    Collection<Visual> getObjectCollection();

    Visual getLowest();

    Visual getHighest();

}
