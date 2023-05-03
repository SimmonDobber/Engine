package common;

public interface Command {

	void execute();

	Command BLANK = () -> {
	};

}
