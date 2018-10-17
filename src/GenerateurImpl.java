import java.util.List;

public class GenerateurImpl implements Generateur {

	private int value;
	private List<ObsGene> observers;

	public GenerateurImpl(int value, List<ObsGene> observers) {
		super();
		this.value = value;
		this.observers = observers;
	}

	/**
	 *  
	 */
	public void attach(ObsGene o) {
		observers.add(o);
	}

	/**
	 *  
	 */
	public void detach(ObsGene o) {
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
		      for (ObsGene observer : observers) {
		         observer.update(null, observer);
		      }
		   } 	

}
