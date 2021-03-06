package fr.uha.ensisa.crypto.time;

import java.security.GeneralSecurityException;
import java.time.Duration;

public interface ITimer {
	
	public Duration getTime();
	
	public void setIterations(long n);
	
	public void timeIt() throws GeneralSecurityException;
}
