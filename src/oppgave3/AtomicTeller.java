package oppgave3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTeller {
	private AtomicInteger verdi = new AtomicInteger();

	public int tellOpp() {
		verdi.incrementAndGet();
		return verdi.get();
	}

	public int getVerdi() {
		return verdi.get();
	}
}
