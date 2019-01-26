package canal;

import java.util.concurrent.Future;

import generator.Generator;

public interface ObsGenAsync {

	public Future<Integer> update(Generator g) throws Exception;

}
