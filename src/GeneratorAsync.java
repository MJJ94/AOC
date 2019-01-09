import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public interface GeneratorAsync {
	ScheduledFuture<Integer> getValue(Afficheur m);
}
