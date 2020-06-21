package tripletester.chainofresponsibility;

import tripletester.observer.Topic;

public abstract class Logger implements Cloneable {

	public static int INFO = 1;
	public static int WARNING = 2;
	public static int ERROR = 3;

	private String name;

	protected int level;
	protected Logger nextLogger;

	public void setNextLogger(Logger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message, Topic topic) {

		if (this.level <= level) {
			this.writeMessage(message);
		}

		if (this.level == level) {
			this.name = message;
			this.logOrder(topic);
		}

		if (this.nextLogger != null) {
			this.nextLogger.logMessage(level, message, topic);
		}

	}
	
	public int getLevel() {
		return level;
	}

	public void printOrder() {
		this.writeMessage(name);
	}
	

	@Override
	public Logger clone() throws CloneNotSupportedException {
		return (Logger) super.clone();
	}

	abstract protected void writeMessage(String message);

	abstract protected void logOrder(Topic topic);

}
