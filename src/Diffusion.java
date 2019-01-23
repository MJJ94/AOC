public interface Diffusion {
	void configure();

	void execute();

	Integer getValue();

	void setGenerateur(Generator g);

	Generator getGenerator();
}
