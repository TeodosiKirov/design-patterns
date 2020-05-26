package decorator;

public class BurgerToppings implements Burger{
	protected Burger normalBurger;

	public BurgerToppings (Burger normalBurger) {
		this.normalBurger = normalBurger;
	}
	@Override
	public void order() {
		this.normalBurger.order();
		
	}
}
