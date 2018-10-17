import java.util.Observer;
import java.util.concurrent.Future;

public interface ObsGene extends Observer{

	/**
	 *  
	 */
	public abstract Future<Object> update(Generateur g);

}
