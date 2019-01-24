import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class Monitor implements ObserverGenerator {

	private Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Canal canal;
	private Future<Integer> future;
	private Integer value;
	private Integer id;

	/**
	 * @see ObserverGenerator#update(Generator)
	 * 
	 * 
	 */
	public Monitor(Canal canal, Integer id) {
		super();
		this.canal = canal;
		this.id = id;
	}

	public void update(Generator g) {
		future = canal.getValue(this);
		try {
			value = future.get();
			LOGGER.info(id + " the value is " + value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Future<Integer> getFuture() {
		return future;
	}

	public void setFuture(Future<Integer> future) {
		this.future = future;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
