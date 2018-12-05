import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Canal implements ObsGenAsync, GeneratorAsync {

	private Generator generator;

	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private ScheduledExecutorService s = Executors.newScheduledThreadPool(10);
	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	public void update(Generator g) throws Exception{
		LOGGER.info("Creating Method Invocation");
			UpdateCallable mi = new Update(g, new Afficheur());
			LOGGER.info("Calling schedule");
			s.schedule(mi, 10, TimeUnit.SECONDS);
			setGenerator(g);
	}

	public Future<Integer> getValue() {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return generator.getValue();
		});
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

}
