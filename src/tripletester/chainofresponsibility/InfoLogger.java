package tripletester.chainofresponsibility;

import tripletester.MainTester;
import tripletester.observer.Topic;

public class InfoLogger extends Logger {

	public InfoLogger() {
		this.level = Logger.INFO;
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
