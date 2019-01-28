package diffusion;
import java.util.Timer;
import java.util.TimerTask;
import generator.Generator;

public class DiffusionCausal implements Diffusion {

//on prend la valeur la plus recente (getValue)

	private Generator generator;
	private Integer value;
	private Timer timer = new Timer();
	private TimerTask timerTask;
	
	@Override
	public void configure(Integer value, Generator generator) {
		this.value = value;
		this.generator = generator;
	}

	@Override
	public void execute() {
		timer = new Timer();
		if (timerTask == null || timerTask.scheduledExecutionTime() > 0) {
			timerTask = new TimerTask() {
				@Override
				public void run() {
					incrementValue();
					generator.setValue(value);
				}
			};
		}
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
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
	@Override
	public void stop() {
		timer.cancel();
	}
}
