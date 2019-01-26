import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws Exception {
		Canal canal = new Canal();
		Canal canal1 = new Canal();
		Canal canal2 = new Canal();
		Canal canal3 = new Canal();

		Monitor monitor = new Monitor(canal,0);
		Monitor monitor1 = new Monitor(canal1,1);
		Monitor monitor2 = new Monitor(canal2,2);
		Monitor monitor3 = new Monitor(canal3,3);

		canal.setMonitor(monitor);
		canal1.setMonitor(monitor1);
		canal2.setMonitor(monitor2);
		canal3.setMonitor(monitor3);
		
		Diffusion diffusion = new DiffusionCausal();
		GeneratorImp generator = new GeneratorImp(0,diffusion, new ArrayList<>());
		canal.setGenerator(generator);
		canal1.setGenerator(generator);
		canal2.setGenerator(generator);
		canal3.setGenerator(generator);
		
		generator.attach(canal);
		generator.attach(canal1);
		generator.attach(canal2);
		generator.attach(canal3);
		
		diffusion.configure(0, generator);
		while(true) {
		diffusion.execute();
		Thread thread = new Thread();
		thread.sleep(1000);
		}
	}

}
