package facade;

public class Cheese implements Burger {

	@Override
	public void order() {
		System.out.println("Ordered a cheesburger!");
		
	}

}
