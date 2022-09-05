package oppgave1;

import javax.swing.JOptionPane;

public class JPTraad extends Thread {
	private boolean running = true;
	private String mld;
	private SysTraad thread;
	public JPTraad(String navn, String mld, SysTraad thread) {
		super(navn);
		this.mld = mld;
		this.thread = thread;
	}
	@Override
	public void run() {
		while(running) {
			String msg = JOptionPane.showInputDialog("Din melding: ");
			if (msg.toUpperCase().equals("QUIT")) {
				running = false;
				System.out.println("Avslutter...");
			} else {
				thread.setMsg(msg);
			}
		}
	}
}
