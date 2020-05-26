package facade;

public class BurgerTester {

	public static void main(String[] args) {
		BurgerFacade burger = new BurgerFacade();
		
		burger.CheeseOrder();
		burger.ClassicOrder();
		burger.EggOrder();
		
		
	}

}
