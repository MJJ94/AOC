import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.SliderUI;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Afficheur monitor = new Afficheur();
		Canal canal = new Canal(monitor);
		DiffusionAtomique diffusionAtom = new DiffusionAtomique(canal);
		GeneratorImp generator = new GeneratorImp(0, new ArrayList<>(), new ArrayList<>(), diffusionAtom);
		generator.attach(monitor);
		generator.attach(canal);
		generator.setValue(10);
		TimeUnit.SECONDS.sleep(10);
		System.out.println("gen: " + canal.getGenerator());
		monitor.getValue(canal);
	}

}
