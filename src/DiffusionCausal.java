import java.util.logging.Logger;

public class DiffusionCausal implements Diffusion {

	private Canal canal;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public DiffusionCausal(Canal canal) {
		this.canal = canal;
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub

	}

//on prend la valeur la plus recente (getValue)
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

	@Override
	public Integer getValue(Afficheur monitor) {
		// TODO Auto-generated method stub
		return null;
	}
}
