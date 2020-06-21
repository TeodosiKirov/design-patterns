package tripletester.chainofresponsibility;

import tripletester.MainTester;
import tripletester.observer.Topic;

public class ErrorLogger extends Logger {

	public ErrorLogger() {
		this.level = Logger.ERROR;
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
