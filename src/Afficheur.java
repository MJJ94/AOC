public class Afficheur implements ObserverGenerator {

	private Generator generator;

	/**
	 * @see ObserverGenerator#update(Generator)
	 * 
	 *  
	 */
	public void update(Generator g) {
		setGenerator(g);
	}
	
	public Generator getCapteur() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		System.out.println("afficheur updates generator to " + generator);
		this.generator = generator;
	}

}
