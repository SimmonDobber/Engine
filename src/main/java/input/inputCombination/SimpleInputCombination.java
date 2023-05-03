package input.inputCombination;

import input.InputHandler;

public class SimpleInputCombination implements InputCombination {

    private final InputHandler inputHandler;
    private final InputElement element;

    public SimpleInputCombination(InputHandler inputHandler, InputElement element) {
        this.inputHandler = inputHandler;
        this.element = element;
    }

    @Override
    public boolean isActive() {
        return inputHandler.isActive(element);
    }
}
