import java.util.List;

public class GeneratorImp implements Generator{

	private int value;
	private List<ObserverGenerator> observers;

	public GeneratorImp(int value, List<ObserverGenerator> observers) {
		super();
		this.value = value;
		this.observers = observers;
	}

	/**
	 *  
	 */
	public void attach(ObserverGenerator o) {
		observers.add(o);
	}

	/**
	 *  
	 */
	public void detach(ObserverGenerator o) {
		observers.remove(o);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		notifyAllObsGenes();
	}
	
	   public void notifyAllObsGenes(){
		      for (ObserverGenerator observer : observers) {
		         observer.update(this);
		      }
		   } 	

}
