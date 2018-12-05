import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class GeneratorImp implements Generator {

	private int value;
	private List<ObserverGenerator> observers;
	private List<ObsGenAsync> observersGenAsync;
	private Diffusion diffusion;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public GeneratorImp(int value, List<ObserverGenerator> observers, List<ObsGenAsync> observersGenAsync,
			Diffusion diffusion) {
		super();
		this.value = value;
		this.observers = observers;
		this.observersGenAsync = observersGenAsync;
		this.diffusion = diffusion;
	}

	public void attach(ObserverGenerator o) {
		observers.add(o);
	}

	public void detach(ObserverGenerator o) {
		observers.remove(o);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) throws InterruptedException, ExecutionException {
		LOGGER.info("excuting diffusion");
		this.value = value;
		this.diffusion.execute(this);
	}

	public void notifyAllObsGenes() throws InterruptedException, ExecutionException {
		for (ObserverGenerator observer : observers) {
			observer.update(this);
		}

		for (ObsGenAsync observer : observersGenAsync) {
			try {
				observer.update(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void attach(ObsGenAsync o) {
		observersGenAsync.add(o);
	}

	public void detach(ObsGenAsync o) {
		observersGenAsync.remove(o);
	}

}
