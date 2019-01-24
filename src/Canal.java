import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

//	public Canal(Monitor monitor) {
//		this.monitor = monitor;
//	}
	public Future<Integer> update(Generator g) {
//		LOGGER.info("Creating Method Invocation");
		UpdateCallable mi = new UpdateCallable(generator, monitor);
		Random random = new Random();
		int duration = random.nextInt(3);
//		LOGGER.info("update duration = " + duration);
		return s.schedule(mi, duration, TimeUnit.SECONDS);
	}

	public ScheduledFuture<Integer> getValue(Monitor m) {
//		LOGGER.info("Generator " + generator);
		GetValueCallable mi = new GetValueCallable(generator);
		Random random = new Random();
		int duration = random.nextInt(3);
//		LOGGER.info("getValue duration = " + duration);
		return s.schedule(mi, duration, TimeUnit.SECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
