public interface Generateur {

	/**
	 *  
	 */
	public abstract void attach(Observer o);

	/**
	 *  
	 */
	public abstract void detach(Observer o);

	public abstract int getValue();

}
