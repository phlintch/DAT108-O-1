package oppgave2;

public class Main {
	public static void main(String[] args) {
		Teller teller = new Teller();
		HamburgerBrett brett = new HamburgerBrett(4);
		String[] Kokker = {"Ramsey", "Oliver", "Helstrøm"};
		String[] serv = {"Per", "Mia"};
		for (String k: Kokker) {
			new Kokk(k,teller, brett).start();
		}
		for (String s: serv) {
			new Servitor(s, brett).start();
		}
		
	}
}
