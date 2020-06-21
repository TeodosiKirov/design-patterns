package tripletester.chainofresponsibility;

import tripletester.MainTester;
import tripletester.observer.Topic;

public class WarningLogger extends Logger {

	public WarningLogger() {
		this.level = Logger.WARNING;
	}

	@Override
	protected void writeMessage(String message) {
		System.out.println("Shipment to: " + message);
	}

	@Override
	protected void logOrder(Topic topic) {
		MainTester.addOrder(this, topic);
	}


	
}
