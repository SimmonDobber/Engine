package input.inputCombination;

import java.util.Set;

import input.InputHandler;

public class ComplexInputCombination implements InputCombination {

    private final InputHandler inputHandler;
    private final Set<InputElement> elements;

    public ComplexInputCombination(InputHandler inputHandler, Set<InputElement> elements) {
        this.inputHandler = inputHandler;
        this.elements = elements;
    }

    @Override
    public boolean isActive() {
        for (InputElement element : this.elements) {
            if (!this.inputHandler.isActive(element)) {
                return false;
            }
        }
        return true;
    }
}
