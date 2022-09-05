package oppgave1;

public class Start {
	public static void main(String[] args) throws InterruptedException {
		SysTraad sysTrd = new SysTraad("System Tr�d.","Hei");
		String mld = "";
		JPTraad jpTraad = new JPTraad("JOptionPane Tr�d", mld, sysTrd);
		sysTrd.setDaemon(true);
		sysTrd.start();
		jpTraad.start();
		
		
		jpTraad.join();
		sysTrd.murder();
		sysTrd.join();
	}
}
