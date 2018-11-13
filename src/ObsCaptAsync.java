import java.util.concurrent.Future;

public interface ObsCaptAsync {

	public abstract Future<Integer> update(Generator g);

}
