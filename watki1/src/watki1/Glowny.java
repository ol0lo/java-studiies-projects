package watki1;

public class Glowny {

	public static void main(String[] args) {
		Thread t1 = new ThreadExt();
		t1.start();
//		try {
//			t1.sleep(3000);
//		} catch (InterruptedException e1) {}
		
		Thread t2 = new Thread(new ThreadRunn());
		t2.start();
//		t1.interrupt();
		
		try {
			t1.join();
			System.out.println("W�tek t1 zako�czy� dzia�anie");
		} catch (InterruptedException e) {}
		try{
			t2.join();
			System.out.println("W�tek t2 zako�czy� dzia�anie");
		} catch (InterruptedException e){}
	}

}
