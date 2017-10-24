package dek;

import dek.api.Screen;

public class Idle implements State {
	public boolean run(Runner runner) {
		Screen.print_centered("Current state is Idle", 100, 20);
		
		return true;
	}
}
