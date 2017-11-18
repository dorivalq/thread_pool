package test.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureService {

	ExecutorService executor = Executors.newSingleThreadExecutor();
	public Future<Integer> executeFuture(Integer value){
		
		return executor.submit( ()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("Executando: " +System.currentTimeMillis()+" I:"+i);
				Thread.sleep(1000/10);
			}
				return value*value;});
	}
}

