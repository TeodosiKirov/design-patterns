package decorator;

public class Classic extends BurgerToppings{

	public Classic(Burger normalBurger) {
		super(normalBurger);
	}
	
	public void order() {
		normalBurger.order();
		OrderWithTopping(normalBurger);
	}
	private void OrderWithTopping(Burger normalBurger) {
		System.out.println("You added classic sauce to your burger!");
	}

}
