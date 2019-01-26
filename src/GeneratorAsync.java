import java.util.concurrent.ScheduledFuture;

public interface GeneratorAsync {
	ScheduledFuture<Integer> getValue(Monitor m);
}
