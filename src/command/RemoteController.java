package command;

public class RemoteController {
	
	private Command command;

	public void SetCommand(Command command) {
		this.command = command;
	}
	
	public void Execute() {
		System.out.println("Executing command!\n");
		this.command.execute();
	}
	
}
