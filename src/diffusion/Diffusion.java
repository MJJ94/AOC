package diffusion;

import generator.Generator;

public interface Diffusion {
	void configure(Integer value, Generator generator);

	void execute();

	Integer getValue();

	void setGenerator(Generator g);

	Generator getGenerator();

	void stop();
}
