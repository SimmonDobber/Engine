package input;

import common.Observer;
import input.inputCombination.InputCombination;
import input.inputCombination.InputCombinationFactory;

public interface Input {

    void addInputListener(Observer observer);

    void addInputContentListener(InputObserver observer);

    void removeInputListener(Observer observer);

    void removeInputContentListener(InputObserver observer);

    int getMouseX();

    int getMouseY();

    InputCombination getCurrentInputCombination();

    InputCombinationFactory getInputCombinationFactory();

    void initializeInputListener();

    void resetInputListener();

}
