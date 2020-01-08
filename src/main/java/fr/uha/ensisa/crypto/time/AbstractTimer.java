package fr.uha.ensisa.crypto.time;

import java.security.GeneralSecurityException;
import java.time.Duration;
import java.time.Instant;

public abstract class AbstractTimer implements ITimer {

	protected Instant start;
	protected Instant end;
	protected long iterations;

	protected void start() {
		this.start = Instant.now();
	}

	protected void stop() {
		this.end = Instant.now();
	}

	public Duration getTime() {
		return Duration.between(this.start, this.end);
	}

	public void setIterations(long n) {
		this.iterations = n;
	}

	public void timeIt() throws GeneralSecurityException {
		this.start();
		try {
			for (int i = 0; i < this.iterations; i++) {
				this.run();
			}
		} catch (GeneralSecurityException e) {
			this.stop();
			throw e;
		}
	}

	protected abstract void run() throws GeneralSecurityException;

}
