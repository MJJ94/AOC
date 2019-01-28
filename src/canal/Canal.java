package canal;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public Future<Integer> update(Generator g) {
		UpdateCallable mi = new UpdateCallable(generator, monitor);
		Random random = new Random();
		int duration = random.nextInt(300);
		return s.schedule(mi, duration, TimeUnit.MILLISECONDS);
	}

	public ScheduledFuture<Integer> getValue(Monitor m) {
		LOGGER.info("Generator " + generator);
		GetValueCallable mi = new GetValueCallable(generator);
		Random random = new Random();
		int duration = random.nextInt(350);
		return s.schedule(mi, duration, TimeUnit.MILLISECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
