package callable;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import generator.Generator;

public class GetValueCallable implements Callable<Integer>{

	Generator generator;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	public GetValueCallable(Generator generator) {
		this.generator = generator;
	}
	@Override
	public Integer call() throws Exception {
//		LOGGER.info("Calling atomique.getValue " + generator.getValue());
		return generator.getValue();
	}

}
