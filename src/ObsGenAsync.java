import java.util.concurrent.Future;

public interface ObsGenAsync {

	public Future<Integer> update(Generator g);

}
