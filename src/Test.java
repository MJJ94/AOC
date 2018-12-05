import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Afficheur afficheur = new Afficheur();
		Canal canal = new Canal();
		DiffusionAtomique diffusionAtom = new DiffusionAtomique(canal);
		GeneratorImp generator = new GeneratorImp(0, new ArrayList<>(), new ArrayList<>(), diffusionAtom);
		generator.attach(afficheur);
		generator.attach(canal);
		generator.setValue(10);
	}

}
