package diffusion;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import generator.Generator;

public class DiffusionSequentiel implements Diffusion {
// l'ecriture n'est pas arrété pendant la lecture
//	la lecture emploie une copie géré de maniere atomique

	private Generator generator;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock r = lock.readLock();
	private Integer value;
	private Timer timer = new Timer();
	private TimerTask timerTask;

	@Override
	public void configure(Integer value, Generator generator) {
		this.value = value;
		this.generator = generator;
	}

	@Override
	public void execute() {
		timer = new Timer();
		if (timerTask == null || timerTask.scheduledExecutionTime() > 0) {
			timerTask = new TimerTask() {
				@Override
				public void run() {
					incrementValue();
					generator.setValue(value);
				}
			};
		}
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}

	@Override
	public Integer getValue() {
		r.lock();
		try {
			return value;
		} finally {
			r.unlock();
		}
	}

	@Override
	public void setGenerator(Generator g) {
		this.generator = g;

	}

	@Override
	public Generator getGenerator() {
		return generator;
	}

	private void incrementValue() {
		value += 1;
	}
	@Override
	public void stop() {
		timer.cancel();
	}
}
