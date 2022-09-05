package oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String[] args) {
		AtomicTeller teller = new AtomicTeller();

		BlockingQueue<Hamburger> brett = new LinkedBlockingQueue<>(4);

		String[] kokker = {"Ramsey", "Helstrøm", "Oliver"};
		String[] servitorer = {"Per", "Mia"};
		for (String k : kokker) {
			Kokk x = new Kokk(k, brett, teller);
			x.start();
		}
		for (String s : servitorer) {
			Servitor x = new Servitor(s, brett);
			x.start();
		}
	}
}
