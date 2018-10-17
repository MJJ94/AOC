public interface Generateur{

	/**
	 *  
	 */
	public abstract void attach(ObsGene o);

	/**
	 *  
	 */
	public abstract void detach(ObsGene o);

	public abstract int getValue();

}
