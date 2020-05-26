package decorator;

public class NormalBurger implements Burger{

	@Override
	public void order() {
		System.out.println("You ordered a normal burger!");
		
	}
	
}
