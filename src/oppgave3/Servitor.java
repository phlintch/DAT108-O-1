package oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitor extends Thread{

	private String navn;
	private BlockingQueue<Hamburger> brett;
	public Servitor(String navn, BlockingQueue<Hamburger> brett) {
		this.navn = navn;
		this.brett = brett;
	}
	
	public void run() {
		while (true) {
			try {
				Random rnd = new Random();
				Thread.sleep((rnd.nextInt(4) + 2)*1000);
				Hamburger hentet = brett.take();
				System.out.println("Servitor " + navn +" henter " +hentet.toString() + " Brett -->  " + brett.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
