
public interface Diffusion {
	void configure();
	void execute(Generator g);
	Integer getValue(Afficheur monitor);
}
