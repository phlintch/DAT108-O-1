package oppgave2;

public class HamburgerBrett {

	private Hamburger[] plasser;
	public int antall;
	public HamburgerBrett(int Kapasitet) {
		plasser = new Hamburger[Kapasitet];
		antall = 0;
	}
	public synchronized void LeggTilBurger(Kokk kokk, Hamburger hamburger) throws InterruptedException {

		plasser[antall] = hamburger;
		antall++;
		System.out.println(kokk.getName() + " legger fra seg " + hamburger.getBurger()   + " Brett: " + this.toString());
	}
	public synchronized Hamburger TaAvBurger(Servitor serv) throws InterruptedException {
		Hamburger re = plasser[0];
		for (int i = 0; i < antall-1; i++) {
			plasser[i] = plasser[i+1];
		}
		plasser[antall-1] = null;
		antall--;

		return re;
		
	}
	public synchronized boolean erFullt() {
		return (antall == plasser.length);
	}
	public synchronized boolean erTom() {
		return antall == 0;
	}
	public String toString() {
		String re = "";
		for (int i = 0; i < antall; i++) {
			if (i != 0) {
				re+= ", ";
			}
			re += "["+plasser[i].getBurger()+"]";
		}
		return re;
	}
}
