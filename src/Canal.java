import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Canal implements ObsCaptAsync {
	
	private Generator capteur;

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> update(Generator g) {
		return executor.submit(() ->  {
			Thread.sleep(1000);
			return g.getValue();
		});
	}

	public int getValue() {
		return capteur.getValue();
	}

	public Generator getCapteur() {
		return capteur;
	}

	public void setCapteur(Generator capteur) {
		this.capteur = capteur;
	}

}
