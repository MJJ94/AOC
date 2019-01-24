public interface Diffusion {
	void configure();

	void execute();

	Integer getValue();

	void setGenerator(Generator g);

	Generator getGenerator();
}
