import java.util.concurrent.Future;

public interface ObsCaptAsync {

	public abstract Future<Integer> update(Capteur g);

}
