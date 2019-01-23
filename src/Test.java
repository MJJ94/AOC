import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws Exception {
		Canal canal = new Canal();
		Canal canal1 = new Canal();
		Canal canal2 = new Canal();
		Canal canal3 = new Canal();

		Monitor monitor = new Monitor(canal);
		Monitor monitor1 = new Monitor(canal1);
		Monitor monitor2 = new Monitor(canal2);
		Monitor monitor3 = new Monitor(canal3);

		canal.setMonitor(monitor);
		canal1.setMonitor(monitor1);
		canal2.setMonitor(monitor2);
		canal3.setMonitor(monitor3);
		
		DiffusionAtomique diffusionAtom = new DiffusionAtomique(canal);
		GeneratorImp generator = new GeneratorImp(0,diffusionAtom, new ArrayList<>());
		canal.setGenerator(generator);
		canal1.setGenerator(generator);
		canal2.setGenerator(generator);
		canal3.setGenerator(generator);
		
		generator.attach(canal);
		generator.attach(canal1);
		generator.attach(canal2);
		generator.attach(canal3);
		Thread t = new Thread(generator);
		t.start();
	}

}
