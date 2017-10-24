package dek;

public interface State {
	/**
	 * Run one 'step' of the state
	 * @param runner The state runner
	 * @return false if you want to exit
	 */
	public boolean run(Runner runner);
}
