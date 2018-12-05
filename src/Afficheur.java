import java.util.logging.Logger;

public class Afficheur implements ObserverGenerator {

	private Generator generator;
	private Logger LOGGER = Logger.getLogger(this.getClass().getName());

	/**
	 * @see ObserverGenerator#update(Generator)
	 * 
	 *  
	 */
	public void update(Generator g) {
		LOGGER .info("Setting the new Genrator");
		setGenerator(g);
	}
	
	public Integer getValue() {
		//call canal.getvalue(afficheur)
		return null;
	}
	
	public Generator getCapteur() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		System.out.println("afficheur updates generator to " + generator);
		this.generator = generator;
	}

}
