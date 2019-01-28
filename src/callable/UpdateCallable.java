package callable;

import java.util.concurrent.Callable;

import generator.Generator;
import javafx.application.Platform;
import monitor.Monitor;

public class UpdateCallable implements Callable<Integer> {

	private Monitor monitor;
	private Generator generator;

	public UpdateCallable(Generator generator, Monitor monitor) {
		this.generator = generator;
		this.monitor = monitor;
	}

	@Override
	public Integer call() throws Exception {
		Platform.runLater(() -> {
			monitor.update(generator);
		});
		return null;
	}
}
