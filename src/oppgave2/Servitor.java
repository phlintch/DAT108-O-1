package oppgave2;

import java.util.Random;

public class Servitor extends Thread {
	private HamburgerBrett brett;
	private boolean running = true;

	public Servitor(String navn, HamburgerBrett brett) {
		super(navn);
		this.brett = brett;
	}

	@Override
	public void run() {
		while(running) {
			Random r = new Random();
			try {
				Thread.sleep((r.nextInt(4)+2) *1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(brett) {
				try {
				while(brett.erTom()) {
					System.out.println(Thread.currentThread().getName() +" venter...");
					brett.wait();
				}
				System.out.println(Thread.currentThread().getName() + " (Serviør) tar av " + brett.TaAvBurger(this).getBurger());
				brett.notify();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
