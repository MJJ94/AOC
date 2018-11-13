import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Canal implements ObsCaptAsync {
	
	private Capteur capteur;

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> update(Capteur g) {
		return executor.submit(() ->  {
			Thread.sleep(1000);
			return g.getValue();
		});
	}

	public int getValue() {
		return capteur.getValue();
	}

	public Capteur getCapteur() {
		return capteur;
	}

	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}

}
