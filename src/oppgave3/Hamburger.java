package oppgave3;



public class Hamburger {
	
	private int burger;
	public Hamburger(int burger) {
		this.burger = burger;
	}
	

	public int getBurger() {
		return burger;
	}
	@Override
	public String toString() {
		return "(🍔" + getBurger() + ")";
	}
}
