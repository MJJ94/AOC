import java.util.logging.Logger;

public class Update extends UpdateCallable {
	private Afficheur a;
	private Generator g;
	public Update(Generator g, Afficheur a) {
		this.g = g;
		this.a = a;
	}
	Logger LOGGER = Logger.getLogger(this.getClass().getName());
	
	@Override
	public Integer call() throws Exception {
		LOGGER.info("calling update from afficheur");
		a.update(g);
		return super.call();
	}
}
