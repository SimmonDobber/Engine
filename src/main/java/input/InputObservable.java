package input;

import input.inputCombination.InputElement;

public interface InputObservable {

    void attach(InputObserver observer);

    void detach(InputObserver observer);

    void notifyObservers(InputElement inputElement);

}
