package monitor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import canal.Canal;
import generator.Generator;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Monitor implements ObserverGenerator {

	private Canal canal;
	private Future<Integer> future;
	private Integer value;
	private  IntegerProperty integerProperty;
		
	
	/**
	 * @see ObserverGenerator#update(Generator)
	 * 
	 * 
	 */
	public Monitor(Canal canal) {
		super();
		this.canal = canal;
		this.value = 0;
		integerProperty = new SimpleIntegerProperty(this.value);
	}

	public void update(Generator g) {
		future = canal.getValue(this);
		try {
			value = future.get();
			integerProperty.set(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
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

	public IntegerProperty getIntegerProperty() {
		return integerProperty;
	}

	public void setIntegerProperty(IntegerProperty integerProperty) {
		this.integerProperty = integerProperty;
	}

}
