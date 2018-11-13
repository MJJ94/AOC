public class Afficheur implements ObserverGenerator {

	private Generator capteur;

	/**
	 * @see ObserverGenerator#update(Generator)
	 * 
	 *  
	 */
	public void update(Generator g) {
		setCapteur(g);
	}
	
	public Generator getCapteur() {
		return capteur;
	}

	public void setCapteur(Generator capteur) {
		this.capteur = capteur;
	}

}
