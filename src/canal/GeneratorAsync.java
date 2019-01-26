package canal;
import java.util.concurrent.ScheduledFuture;

import monitor.Monitor;

public interface GeneratorAsync {
	ScheduledFuture<Integer> getValue(Monitor m);
}
