package test.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureClient {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		new FutureClient().execute();
	}
	
	public void execute() throws InterruptedException, ExecutionException{
		System.out.println("Inicio: " +System.currentTimeMillis());
		Future<Integer> future = new FutureService().executeFuture(8);
		Thread.sleep(500);
		System.out.println("Chamando o get()");
		System.out.println(future.get());
	}
}
