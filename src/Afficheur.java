import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Afficheur implements ObserverGenerator {

	private Generator generator;
	private Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Canal canal;
	/**
	 * @see ObserverGenerator#update(Generator)
	 * 
	 *  
	 */
	public void update(Generator g) {
		LOGGER .info("Setting the new Genrator");
		setGenerator(g);
	}
	
	public Integer getValue(Canal canal) {
//		call canal.getvalue(afficheur)
		ScheduledFuture<Integer> sf= canal.getValue(this);
			try {
				return sf.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
