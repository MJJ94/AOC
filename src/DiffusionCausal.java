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

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGenerateur(Generator g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Generator getGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

//on prend la valeur la plus recente (getValue)

}
