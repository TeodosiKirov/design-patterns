package decorator;

public class Egg extends BurgerToppings{

	public Egg(Burger normalBurger) {
		super(normalBurger);
	}
	
	public void order() {
		normalBurger.order();
		OrderWithTopping(normalBurger);
	}
	private void OrderWithTopping(Burger normalBurger) {
		System.out.println("You added eggs to your burger!");
	}
}
