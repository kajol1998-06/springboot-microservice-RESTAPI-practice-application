package in.kajol;

public class App {

	public static void main(String[] args) {
//		Car c=new Car(new Diesel());
		Car c=new Car();
//		c.setengine(new Diesel());
		c.eng=new Diesel();
		c.drive();

	}

}
