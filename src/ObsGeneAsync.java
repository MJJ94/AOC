import java.util.concurrent.Future;

public interface ObsGeneAsync {

	public abstract Future<Object> update(Generateur g);

}
