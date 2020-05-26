package decorator;

public class Cheese extends BurgerToppings{

	public Cheese(Burger normalBurger) {
		super(normalBurger);
	}
	public void order() {
		normalBurger.order();
		OrderWithTopping(normalBurger);
	}
	private void OrderWithTopping(Burger normalBurger) {
		System.out.println("You added cheese to your burger!");
	}
}
