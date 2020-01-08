package fr.uha.ensisa.crypto.graphics;

public class Result {

	protected Object object;
	protected long time;

	public Result(Object object, long time) {
		this.object = object;
		this.time = time;
	}

	public Object getObject() {
		return this.object;
	}

	public long getTime() {
		return this.time;
	}
}
