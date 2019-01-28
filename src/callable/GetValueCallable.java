package callable;

import java.util.concurrent.Callable;
import generator.Generator;

public class GetValueCallable implements Callable<Integer> {

	Generator generator;

	public GetValueCallable(Generator generator) {
		this.generator = generator;
	}

	@Override
	public Integer call() throws Exception {
		return generator.getValue();
	}

}
