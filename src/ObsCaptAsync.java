import java.util.concurrent.Future;

public interface ObsCaptAsync {

	public abstract Future<Object> update(Capteur g);

}
