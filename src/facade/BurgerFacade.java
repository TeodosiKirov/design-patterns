package facade;

public class BurgerFacade {
	private Burger cheeseBurger;
	private Burger classicBurger;
	private Burger eggBurger;
	
	public BurgerFacade () {
		this.cheeseBurger = new Cheese();
		this.classicBurger = new Classic();
		this.eggBurger = new Egg();
		
	}
	public void ClassicOrder() {
		this.classicBurger.order();
		
	}
	
	public void CheeseOrder() {
		this.cheeseBurger.order();
		
	}
	
	public void EggOrder() {
		this.eggBurger.order();
		
	}
}
