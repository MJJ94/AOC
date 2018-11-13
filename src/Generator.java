public interface Generator{

	/**
	 *  
	 */
	public abstract void attach(ObserverGenerator o);

	/**
	 *  
	 */
	public abstract void detach(ObserverGenerator o);

	public abstract int getValue();

}
