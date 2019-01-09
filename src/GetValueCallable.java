import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class GetValueCallable implements Callable{

	Generator generator;
	Afficheur monitor;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	public GetValueCallable(Generator generator, Afficheur monitor) {

		this.generator = generator;
		this.monitor = monitor;
	
	}
	@Override
	public Integer call() throws Exception {
		LOGGER.info("Getting Value " + generator);
		return generator.getValue(monitor);
	}

}
