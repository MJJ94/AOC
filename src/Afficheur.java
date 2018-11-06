import java.util.Observable;
import java.util.concurrent.Future;

public class Afficheur implements ObserverCapteur {


	/**
	 * @see ObserverCapteur#update(Capteur)
	 * 
	 *  
	 */
	public Future<Object> update(Capteur g) {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
