package generator;

import java.util.List;
import java.util.concurrent.ExecutionException;

import canal.Canal;
import diffusion.Diffusion;

public interface Generator {
	void attach(Canal c);

	void detach(Canal c);

	void notifyAllObsGenes() throws InterruptedException, ExecutionException;

	int getValue();

	List<Canal> getCanals();

	void setCanals(List<Canal> canals);

	void setValue(Integer value);

	void setDiffusion(Diffusion diffusion);
	void stopDiffusion();
}
