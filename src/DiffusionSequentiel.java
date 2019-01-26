import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DiffusionSequentiel implements Diffusion {
// l'ecriture n'est pas arrété pendant la lecture
//	la lecture emploie une copie géré de maniere atomique

	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock r = lock.readLock();
	private Integer value;

	@Override
	public void configure(Integer value, Generator generator) {
		this.value = value;
		this.generator = generator;
	}

	@Override
	public void execute() {
		incrementValue();
		generator.setValue(value);
		generator.getCanals().stream().map(c -> c.update(generator)).collect(Collectors.toList());
	}

	@Override
	public Integer getValue() {
		r.lock();
		try {
			return value;
		} finally {
			r.unlock();
		}
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
		value += 1;
	}
}
