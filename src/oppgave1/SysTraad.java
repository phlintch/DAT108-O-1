package oppgave1;

public class SysTraad	extends Thread {
	private boolean running = true;
	private String msg;
	public SysTraad(String navn, String msg) {
		super(navn);
		this.msg = msg;
	}
	public void murder() {
		running = false;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public void run() {
		while(running) {
			System.out.println(msg);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
