package dek;

public class Runner {
	
	
	State currentState = new Idle();
	
	public void go() {
		while(true) {
			currentState.run(this);
		}
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
