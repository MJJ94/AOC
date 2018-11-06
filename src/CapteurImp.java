import java.util.List;

public class CapteurImp implements Capteur {

	private int value;
	private List<ObserverCapteur> observers;

	public CapteurImp(int value, List<ObserverCapteur> observers) {
		super();
		this.value = value;
		this.observers = observers;
	}

	/**
	 *  
	 */
	public void attach(ObserverCapteur o) {
		observers.add(o);
	}

	/**
	 *  
	 */
	public void detach(ObserverCapteur o) {
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
		      for (ObserverCapteur observer : observers) {
		         observer.update(null, observer);
		      }
		   } 	

}
