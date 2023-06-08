package button;

import java.util.Objects;

import common.Command;
import display.Drawable;
import input.inputCombination.InputCombination;

public class SimpleButton extends ComplexButton {

    public SimpleButton(Drawable drawable, InputCombination activationCombination, Command action) {
        super(drawable, new InputCombination[] { activationCombination }, new Command[] { action });
    }

    @Override
    public void update() {
        InputCombination activationCombination = this.actions.keySet()
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
        if (activationCombination == null || activationCombination.isActive()) {
            this.actions.get(activationCombination).execute();
        }
    }
}
