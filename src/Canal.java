import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Canal implements ObsGenAsync, GeneratorAsync {

	private Generator generator;

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> update(Generator g) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			setGenerator(g);
			return g.getValue();
		});
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
		System.out.println("Canal updates generator to: " + generator);
		this.generator = generator;
	}

}
