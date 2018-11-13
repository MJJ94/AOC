public class Afficheur implements ObserverCapteur {

	private Capteur capteur;

	/**
	 * @see ObserverCapteur#update(Capteur)
	 * 
	 *  
	 */
	public void update(Capteur g) {
		setCapteur(g);
	}
	
	public Capteur getCapteur() {
		return capteur;
	}

	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}

}
