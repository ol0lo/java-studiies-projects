package zadanie4;

public class Neighbor implements Runnable {

	private Neighbor neighbor;
	private String name;
	static Object globalLock = new Object();
	
	Neighbor(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			hiReq();
		}
	}

	public void setNeighbor(Neighbor neighbor) {
		this.neighbor = neighbor;
	}

	public void hiReq() {
		synchronized(globalLock){
			System.out.println(name + ": Mowie dzien dobry");
			neighbor.hiResp();
		}
		
	}

	public void hiResp() {
		synchronized(globalLock){
			System.out.println(name + ": Odpowiadam dzien dobry");
		}
	}


}
