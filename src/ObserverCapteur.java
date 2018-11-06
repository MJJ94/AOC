import java.util.Observer;
import java.util.concurrent.Future;

public interface ObserverCapteur extends Observer{

	/**
	 *  
	 */
	public abstract Future<Object> update(Capteur g);

}
