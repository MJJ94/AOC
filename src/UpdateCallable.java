import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class UpdateCallable implements Callable<Integer>{

	private Monitor monitor;
	private Generator generator;
	public UpdateCallable(Generator generator, Monitor monitor) {
		this.generator = generator;
		this.monitor = monitor;
	}
	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	
	@Override
	public Integer call() throws Exception {
//		LOGGER.info("calling update from afficheur");
		monitor.update(generator);
		return null;
	}
}
