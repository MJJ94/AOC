import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Canal implements ObsGenAsync, GeneratorAsync {

	private Generator generator;
	private Afficheur monitor;

	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private ScheduledExecutorService s = Executors.newScheduledThreadPool(10);
	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	public Canal(Afficheur monitor) {
		this.monitor = monitor;
	}
	public void update(Generator g) throws Exception {
		LOGGER.info("Creating Method Invocation");
		LOGGER.info("GenratorUpdate: " + generator);
		setGenerator(g);
		UpdateCallable mi = new UpdateCallable(generator, monitor);
		LOGGER.info("Calling schedule with updateMI " + mi);
		s.schedule(mi, 5, TimeUnit.SECONDS);
	}

	public ScheduledFuture<Integer> getValue(Afficheur m) {
		LOGGER.info("Generator " + generator);
		GetValueCallable mi = new GetValueCallable(generator, monitor);
		LOGGER.info("Calling schedule with getValueMI");
		return s.schedule(mi, 5, TimeUnit.SECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
