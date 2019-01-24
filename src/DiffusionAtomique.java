import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DiffusionAtomique implements Diffusion {

	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock r = lock.readLock();
	private Lock w = lock.writeLock();
	private List<Future<Integer>> futures;
	private Integer value;

	public DiffusionAtomique(Integer value) {
		this.value = value;
	}
	@Override
	public void configure() {

		// TODO Auto-generated method stub

		incrementValue();
		System.out.println("new value: " + value);
		generator.setValue(value);
		futures = generator.getCanals().stream().map(c -> c.update(generator)).collect(Collectors.toList());
		try {
			System.out.println("futures.get(0).get() " + futures.get(0).get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// l'ecriture est arretée pendant les lectures

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		configure();
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setGenerator(Generator g) {
		this.generator = g;

	}

	@Override
	public Generator getGenerator() {
		return generator;
	}

	private void incrementValue() {
		w.lock();
		try {
			value += 1;
		} finally {
			w.unlock();
		}
	}
}
