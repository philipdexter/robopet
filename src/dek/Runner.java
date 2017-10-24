package dek;

import dek.api.Screen;

public class Runner {
	
	State currentState = new Idle();
	
	public void go() {
		while(true) {
			if (!currentState.run(this)) {
				break;
			}
		}
		Screen.print_centered("bye", 100, 20);
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public State getState() {
		return this.currentState;
	}
	
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.go();
	}

}
