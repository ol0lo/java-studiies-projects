package zadanie6;

public class Monk extends Thread{

	Fork f1;
	Fork f2;
	int no;
	
	public Monk(int no, Fork f1, Fork f2){
		this.no = no;
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public void run(){
		while(true){
			f1.get();
			f2.get();
			eat();
			f1.put();
			f2.put();
		}
	}
	
	private void eat(){
		System.out.println("Monk "+no+": omm nom nom");
	}
	
}
