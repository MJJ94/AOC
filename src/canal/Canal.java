package canal;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import callable.GetValueCallable;
import callable.UpdateCallable;
import generator.Generator;
import monitor.Monitor;

public class Canal implements ObsGenAsync, GeneratorAsync {

	private Generator generator;
	private Monitor monitor;

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	private ScheduledExecutorService s = Executors.newScheduledThreadPool(10);

	public Future<Integer> update(Generator g) {
		UpdateCallable mi = new UpdateCallable(generator, monitor);
		Random random = new Random();
		int duration = random.nextInt(3);
		return s.schedule(mi, duration, TimeUnit.SECONDS);
	}

	public ScheduledFuture<Integer> getValue(Monitor m) {
		GetValueCallable mi = new GetValueCallable(generator);
		Random random = new Random();
		int duration = random.nextInt(3);
		return s.schedule(mi, duration, TimeUnit.SECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
