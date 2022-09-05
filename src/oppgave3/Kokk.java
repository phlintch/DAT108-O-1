package oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk extends Thread{
	private String navn;
	private BlockingQueue<Hamburger> brett;
	private AtomicTeller teller;
	public Kokk(String navn, BlockingQueue<Hamburger> brett, AtomicTeller teller) {
		this.navn = navn;
		this.brett = brett;
		this.teller = teller;
	}
	
	@Override
	public void run() {
		while (true) {
			try {

				Random rnd = new Random();
				Thread.sleep((rnd.nextInt(4) + 2)*1000);
				Hamburger laget = new Hamburger(teller.tellOpp());
				brett.put(laget);
				System.out.println("Kokken "+ navn+ " lager "+laget.toString() + " Brett -->  " + brett.toString());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
