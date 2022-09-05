package oppgave2;

import java.util.Random;

public class Kokk extends Thread {
	private boolean running = true;
	private Teller teller;
	private HamburgerBrett brett;

	public Kokk(String navn, Teller teller, HamburgerBrett brett) {
		super(navn);
		this.teller = teller;
		this.brett = brett;
	}

	@Override
	public void run() {
		
		while (running) {
			Random r = new Random();
			try {
				Thread.sleep((r.nextInt(4)+2) *1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(brett) {
				try {
				Hamburger ny = new Hamburger(teller.getVerdi());
				teller.tellOpp();
				while(brett.erFullt()) {
					System.out.println(Thread.currentThread().getName() + " venter...");
					brett.wait();
				}
				brett.LeggTilBurger(this, ny);
				brett.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
