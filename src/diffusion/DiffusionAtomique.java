package diffusion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import generator.Generator;

public class DiffusionAtomique implements Diffusion {

	// l'ecriture est arretée pendant les lectures

	private Generator generator;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock r = lock.readLock();
	private Lock w = lock.writeLock();
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
		w.lock();
		try {
			value += 1;
		} finally {
			w.unlock();
		}
	}
}
