import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
	private Integer data = 0;
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition getCnd;
	private static Condition putCnd;
	
	public Warehouse() {
		getCnd = lock.newCondition();
		putCnd = lock.newCondition();
	}
	
	public Integer get() {
		lock.lock();
		try{
			while(data<=0){
				try {
					getCnd.await();
				} catch (InterruptedException e) {}
			}
			data--;
			putCnd.signalAll();
			return data;
		} finally {
			lock.unlock();
		}
	}

	public Integer put() {
		lock.lock();
		try{
			while(data>=5){
				try {
					putCnd.await();
				} catch (InterruptedException e) {}
			}
			data++;
			getCnd.signalAll();
			return data;
		} finally {
			lock.unlock();
		}
	}
}
