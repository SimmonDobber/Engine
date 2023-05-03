package engine.input.inputCombination;

import input.inputCombination.ActionType;
import input.inputCombination.InputElement;
import org.junit.Test;

import static input.inputCombination.ActionType.DOWN;
import static input.inputCombination.ActionType.UP;
import static org.junit.Assert.assertEquals;

public class InputElementTest {

	@Test
	public void accessors_test() {
		//given
		ActionType[] inputActions = new ActionType[] { UP, UP, DOWN, DOWN, DOWN, UP };
		InputElement[] output = new InputElement[inputActions.length];
		//when
		for (int i = 0; i < inputActions.length; i++) {
			inputActions[i] = UP;
			output[i] = new InputElement(inputActions[i], null);
		}
		//then
		for (int i = 0; i < inputActions.length; i++) {
			assertEquals(inputActions[i], output[i].getActionType());
		}
	}

}
