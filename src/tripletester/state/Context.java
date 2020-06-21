package tripletester.state;

import tripletester.observer.TopicSubscriber;

public class Context extends TopicSubscriber{

	private State state;
	
	public Context(int name) {
		super(name);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
