import java.util.logging.Logger;

public class DiffusionAtomique implements Diffusion {

	private Canal canal;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public DiffusionAtomique(Canal canal) {
		this.canal = canal;
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub

	}

// l'ecriture est arretée pendant les lectures
	@Override
	public void execute(Generator g) {
		LOGGER.info("Calling update");
		try {
			canal.update(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

}
