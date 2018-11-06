public interface Capteur{

	/**
	 *  
	 */
	public abstract void attach(ObserverCapteur o);

	/**
	 *  
	 */
	public abstract void detach(ObserverCapteur o);

	public abstract int getValue();

}
