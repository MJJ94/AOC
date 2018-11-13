import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class GeneratorImp implements Generator {

	private int value;
	private List<ObserverGenerator> observers;
	private List<ObsGenAsync> observersGenAsync;
	private Diffusion diffusion;

	public GeneratorImp(int value, List<ObserverGenerator> observers, List<ObsGenAsync> observersGenAsync, Diffusion diffusion) {
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
		System.out.println("updating to value: " + value);
		this.value = value;
		this.diffusion.execute(this);
	}

	public void notifyAllObsGenes() throws InterruptedException, ExecutionException {
		for (ObserverGenerator observer : observers) {
			observer.update(this);
		}

		for (ObsGenAsync observer : observersGenAsync) {
			Future<Integer> value = observer.update(this);
			System.out.println(value.get());
		}
	}

	public void attach(ObsGenAsync o) {
		observersGenAsync.add(o);
	}

	public void detach(ObsGenAsync o) {
		observersGenAsync.remove(o);
	}
	
}
