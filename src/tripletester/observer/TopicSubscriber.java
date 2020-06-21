package tripletester.observer;

public class TopicSubscriber implements Observer {

	protected int name;
	private Observable topic;
	
	public TopicSubscriber(int name) {
		this.setName(name);
	}

	@Override
	public void update() {
		if(topic == null) {
			System.out.println("No topic");
			return;
		}
		
		String topicName = topic.getUpdate();
		System.out.println(this.getName() + " updated with: " + "Topic is: " + topicName);
		
	}
	@Override
	public void setTopic(Observable topic) {
		this.topic = topic;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}


}
