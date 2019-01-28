package generator;
import java.util.List;
import java.util.logging.Logger;

import canal.Canal;
import diffusion.Diffusion;

public class GeneratorImp implements Generator{

	private int value;
	private List<Canal> canals;
	private Diffusion diffusion;
	Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public GeneratorImp(int value, Diffusion diffusion, List<Canal> Canals) {
		super();
		this.value = value;
		this.canals = Canals;
		this.diffusion = diffusion;
	}

	public int getValue() {
		return diffusion.getValue();
	}

	public void setValue(Integer value) {
		this.value = value;
		notifyAllObsGenes();
		LOGGER.info("generator value is " + this.value);
	}

	public void notifyAllObsGenes(){
		for (Canal canal : canals) {
			try {
				canal.update(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void attach(Canal c) {
		canals.add(c);
	}

	public void detach(Canal c) {
		canals.remove(c);
	}

	public List<Canal> getCanals() {
		return canals;
	}

	public void setCanals(List<Canal> canals) {
		this.canals = canals;
	}

	@Override
	public void setDiffusion(Diffusion diffusion) {
		this.diffusion = diffusion;
	}
	
	public void stopDiffusion() {
		this.diffusion.stop();

	}

}
