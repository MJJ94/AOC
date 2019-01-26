import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class GeneratorImp implements Generator{

	private int value;
	private List<Canal> canals;
	private Diffusion diffusion;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public GeneratorImp(int value, Diffusion diffusion, List<Canal> Canals) {
		super();
		this.value = value;
		this.canals = Canals;
		this.diffusion = diffusion;
	}

	public int getValue() {
//		LOGGER.info("Returning value = " + value);
		return diffusion.getValue();
	}

	public void setValue(Integer value) {
		this.value = value;
		LOGGER.info("generator value is " + this.value);
	}

	public void notifyAllObsGenes() throws InterruptedException, ExecutionException {
		for (ObsGenAsync observer : canals) {
//			LOGGER.info("updaet canal: " + observer);
			try {
				observer.update(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void attach(Canal c) {
		canals.add(c);
	}

	public void detach(Canal c) {
		canals.remove(c);
	}

	public List<Canal> getCanals() {
		return canals;
	}

	public void setCanals(List<Canal> canals) {
		this.canals = canals;
	}

}
