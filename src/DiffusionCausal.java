import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DiffusionCausal implements Diffusion {

//on prend la valeur la plus recente (getValue)

	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Generator generator;
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
		value += 1;
	}

}
