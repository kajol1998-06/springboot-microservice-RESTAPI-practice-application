package in.kajol;

public class Diesel implements Iengine {

	public void start()
	{
		System.out.println("start diesel");
		
		sound();
	}
	public void sound()
	{
		System.out.print("zzzzzzzzzzzzzzzzzzzz");
	}
}
