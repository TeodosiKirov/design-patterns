package decorator;

public class ToppingsTester {

	public static void main(String[] args) {
		Burger normalBurger = new NormalBurger();
		Burger normalBurger_1 = new NormalBurger();
		Burger normalBurger_2 = new NormalBurger();		
		
		Burger cheeseBurger = new Cheese(normalBurger);
		cheeseBurger.order();
		Burger eggBurger = new Egg(normalBurger_1);
		eggBurger.order();
		Burger classicBurger = new Classic(normalBurger_2);
		classicBurger.order();
		
	}

}
