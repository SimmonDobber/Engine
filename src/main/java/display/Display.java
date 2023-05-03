package display;

import java.util.Collection;
import java.util.EventListener;

import common.Visual;

public interface Display {

    void draw();

    void setObjectsToDraw(Collection<Visual> objects);

    void addWindowListener(EventListener listener);

    DrawableFactory getDrawableFactory();

}
