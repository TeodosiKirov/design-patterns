package tripletester;

import java.util.ArrayList;
import tripletester.chainofresponsibility.ErrorLogger;
import tripletester.chainofresponsibility.InfoLogger;
import tripletester.chainofresponsibility.Logger;
import tripletester.chainofresponsibility.WarningLogger;
import tripletester.observer.Observer;
import tripletester.observer.Topic;
import tripletester.observer.TopicSubscriber;
import tripletester.state.Context;
import tripletester.state.StartState;
import tripletester.state.State;
import tripletester.state.StopState;

public class MainTester {

	public static StartState startState = new StartState();
	public static StopState stopState = new StopState();
	public static Logger chain = getChain();
	public static ArrayList<Logger> loggedOrders = new ArrayList<Logger>();
	public static ArrayList<Logger> packageStorage = new ArrayList<Logger>();

	public static void addOrder(Logger logger, Topic topic) {

		try {
			loggedOrders.add(logger.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		for (Observer subscriber : topic.getSubscribers()) {
			State subscriberState = ((Context) subscriber).getState();

			if (((State) subscriberState).getStateName().equals("START_STATE")) {
				for (Logger loggedOrder : loggedOrders) {
					if (loggedOrder.getLevel() == ((TopicSubscriber) subscriber).getName()) {
						stopState.applyState((Context) subscriber);
						break;
					}
				}
			}
		}
	}

	public static void completePendingOrders(Topic topic) {
		for (Observer subscriber : topic.getSubscribers()) {
			State subscriberState = ((Context) subscriber).getState();

			if (((State) subscriberState).getStateName().equals("STOP_STATE")) {
				for (Logger loggedOrder : loggedOrders) {
					if (loggedOrder.getLevel() == ((TopicSubscriber) subscriber).getName()) {
						try {
							packageStorage.add(loggedOrder.clone());
						} catch (CloneNotSupportedException e) {
							e.printStackTrace();
						}
						loggedOrders.remove(loggedOrder);
						startState.applyState((Context) subscriber);
						break;
					}
				}
			}
		}
	}
	
	public static void printOrders() {
		System.out.println("\nCurrent orders:");
		for (Logger loggedOrder : loggedOrders) {
			loggedOrder.printOrder();
		}
	}

	public static void addPackage(Logger logger) {

		try {
			packageStorage.add(logger.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public static void printStorage() {
		System.out.println("\nStorage:");
		for (Logger _package : packageStorage) {
			_package.printOrder();
		}
	}

	private static Logger getChain() {
		Logger infoLogger = new InfoLogger();
		Logger warningLogger = new WarningLogger();
		Logger errorLogger = new ErrorLogger();

		infoLogger.setNextLogger(warningLogger);
		warningLogger.setNextLogger(errorLogger);
		return infoLogger;
	}

	public static void main(String[] args) {
		Topic topic = new Topic();

		Observer ivan = new Context(1);
		Observer georgi = new Context(2);
		Observer maria = new Context(3);

		startState.applyState((Context) ivan);
		startState.applyState((Context) georgi);
		startState.applyState((Context) maria);

		topic.subscribe(ivan);
		topic.subscribe(georgi);
		topic.subscribe(maria);
		topic.setName("Package collection.");

		chain.logMessage(1, "Plovdiv", topic);
		chain.logMessage(2, "Sofia", topic);
		chain.logMessage(3, "Germany", topic);
		chain.logMessage(2, "Shushmanci", topic);

		
		printOrders();
		printStorage();
		
		completePendingOrders(topic);
		printOrders();
		printStorage();
		
		chain.logMessage(1, "Plovdiv", topic);
		chain.logMessage(2, "Pazardjik", topic);
		chain.logMessage(3, "Serbia", topic);
		
		completePendingOrders(topic);
		printOrders();
		printStorage();

	}
}