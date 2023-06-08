package button.radioButton;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Getter;

public class RadioButtonBundle {

    private final List<RadioButton> radioButtons;
    private final boolean unselectable;
    @Getter
    private RadioButton selectedRadioButton;

    public RadioButtonBundle(boolean unselectable) {
        this.radioButtons = new LinkedList<>();
        this.unselectable = unselectable;
    }

    public RadioButtonBundle(List<RadioButton> radioButtons, boolean unselectable) {
        this.radioButtons = radioButtons;
        this.unselectable = unselectable;
        for (RadioButton radioButton : radioButtons) {
            radioButton.setRadioButtonBundle(this);
        }
    }

    public RadioButtonBundle(List<RadioButton> radioButtons, int selectedRadioButtonIndex, boolean unselectable) {
        this.radioButtons = radioButtons;
        this.unselectable = unselectable;
        for (RadioButton radioButton : radioButtons) {
            radioButton.setRadioButtonBundle(this);
        }
        if (selectedRadioButtonIndex >= 0) {
            this.selectedRadioButton = radioButtons.get(selectedRadioButtonIndex);
        }
    }

    public RadioButtonBundle() {
        this(false);
    }

    public RadioButtonBundle(List<RadioButton> radioButtons) {
        this(radioButtons, false);
    }

    public RadioButtonBundle(List<RadioButton> radioButtons, int selectedRadioButtonIndex) {
        this(radioButtons, selectedRadioButtonIndex, false);
    }

    public void update(RadioButton currentlySelected) {
        if (this.selectedRadioButton != currentlySelected) {
            this.selectedRadioButton.setSelected(false);
        }
        if (currentlySelected.isSelected() && this.unselectable) {
            currentlySelected.setSelected(false);
            this.selectedRadioButton = null;
        } else {
            currentlySelected.setSelected(true);
            this.selectedRadioButton = currentlySelected;
        }
    }

    public void unset() {
        if (this.selectedRadioButton != null) {
            this.selectedRadioButton.setSelected(false);
            this.selectedRadioButton = null;
        }
    }

    public List<Boolean> getBundleState() {
        return this.radioButtons.stream()
                .map(RadioButton::isSelected)
                .toList();
    }

    public int getSelectedRadioButtonIndex() {
        return IntStream.range(0, this.radioButtons.size())
                .filter(i -> this.radioButtons.get(i).equals(this.selectedRadioButton))
                .findFirst()
                .orElse(-1);
    }

    public void addRadioButton(RadioButton radioButton) {
        if (!this.radioButtons.contains(radioButton)) {
            radioButton.setRadioButtonBundle(this);
            this.radioButtons.add(radioButton);
        }
    }

    public void removeRadioButton(RadioButton radioButton) {
        this.radioButtons.remove(radioButton);
    }

}
