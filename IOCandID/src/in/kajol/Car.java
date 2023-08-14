package in.kajol;

public class Car {
      public Iengine eng;
       
//       Car(Iengine eng)
//       {
//    	   this.eng=eng;
//       }
//        void setengine(Iengine eng)
//        {
//        	this.eng=eng;
//        }
       
       void drive()
       {
    	   eng.start();
       }
       
}
