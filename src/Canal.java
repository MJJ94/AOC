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
//		LOGGER.info("GenratorUpdate: " + generator);
		UpdateCallable mi = new UpdateCallable(generator, monitor);
		return s.schedule(mi, ((long) Math.random() * 10), TimeUnit.MILLISECONDS);
	}

	public ScheduledFuture<Integer> getValue(Monitor m) {
//		LOGGER.info("Generator " + generator);
		GetValueCallable mi = new GetValueCallable(generator);
//		LOGGER.info("Calling schedule with getValueMI");
		return s.schedule(mi, ((long) Math.random() * 10), TimeUnit.MILLISECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
