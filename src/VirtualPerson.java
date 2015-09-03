
public class VirtualPerson {
	private int tooHot;
	private int tooCold;
	
	public VirtualPerson(){
		
	}
	
	public VirtualPerson(int tooCold, int tooHot){
		this.tooCold = tooCold;
		this.tooHot = tooHot;
	}


	public void drinkCoffee(VirtualCoffeeCup cup) throws TemperatureException{
		if(cup.getTemperature() <= tooCold){
			int tempdiff = cup.getTemperature() - tooCold;
			throw new TooColdException("My coffee is too cold! About " 
					+ tempdiff + " degrees too cold." , tempdiff);
		}
		
	    if(cup.getTemperature() >= tooHot){
	    	int tempdiff = cup.getTemperature() - tooHot;
			throw new TooHotException("My coffee is too hot! About " 
					+ tempdiff + " degrees too hot.", tempdiff);
		}
		
		else
			System.out.println("Ahh....");
	}

}
