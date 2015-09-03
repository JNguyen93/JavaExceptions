
public class VirtualCafe {
	private static int italian = 3;
	private static int french = 3;
	private static int vietnamese = 2;
	private static int american = 2;

	public static void serveCustomer(VirtualPerson p, VirtualCoffeeCup c){
		try{
			p.drinkCoffee(c);
		}
		
		catch(TooColdException e){
			System.out.println(e.getMessage());
			if(Math.abs(e.getTempDiff()) <= 5){
				System.out.println("Sorry! I can warm that right up for you.");
				for(int i = 0; i < Math.abs(e.getTempDiff()); i++){
					System.out.println("Heating up coffee...");
				}
				System.out.println("Here you go!");
			}
			else
				System.out.println("Sorry, here's a warmer cup of coffee.");
		}
		
		catch(TooHotException e){
			System.out.println(e.getMessage());
			if(Math.abs(e.getTempDiff()) >= 5){
				System.out.println("Sorry! I can cool that right down for you.");
				for(int i = 0; i < Math.abs(e.getTempDiff()); i++){
					System.out.println("Cooling down coffee...");
				}
				System.out.println("Here you go!");
			}
			else
				System.out.println("Sorry, here's a cooler cup of coffee.");
		}
		
		catch(TemperatureException e){
			System.out.println("Sorry, here's another cup of coffee.");
		}
		
		finally{
			//VirtualPerson asks for another cup
			//Determine if there are still more of that roast
			//Throw OutOfStockException if out of that roast.
			try {
				System.out.println("Let me get another cup of " 
						+ c.getRoast() + " coffee please.");
				VirtualCafe.decrementStock(c.getRoast());
				System.out.println("Another " + c.getRoast() + " coming right up!");
				System.out.println("Here you go!\n");
			} catch (OutOfStockException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void decrementStock(String s) throws OutOfStockException{
		switch (s){
			case "Italian": if(italian <= 0)
								throw new OutOfStockException
								("Sorry we're out of Italian roast!");
							else
								italian--;
							break;
			case "French": 	if(french <= 0)
								throw new OutOfStockException
								("Sorry we're out of French roast!");
						   	else
								french--;
							break;
			case "Vietnamese": if(vietnamese <= 0)
									throw new OutOfStockException
									("Sorry we're out of Vietnamese roast!");
							   	else
									vietnamese--;
								break;
			case "American": 	if(american <= 0)
									throw new OutOfStockException
									("Sorry we're out of American roast!");
							   	else
									american--;
								break;
		}
	}
	
	public static void main(String[] args){
		try{
		    VirtualCoffeeCup cup1 = new 
		        VirtualCoffeeCup.Builder("Italian").temperature(180).build();
		    VirtualCafe.decrementStock(cup1.getRoast());
		    
		    VirtualCoffeeCup cup2 = new
		        VirtualCoffeeCup.Builder("French").temperature(150).build(); 
		    VirtualCafe.decrementStock(cup2.getRoast());
		    
		    VirtualCoffeeCup cup3 = new
			        VirtualCoffeeCup.Builder("Vietnamese").temperature(170).build();
		    VirtualCafe.decrementStock(cup3.getRoast());
	
		    VirtualCoffeeCup cup4 = new
			        VirtualCoffeeCup.Builder("American").temperature(190).build();
		    VirtualCafe.decrementStock(cup4.getRoast());
		    
		    VirtualCoffeeCup cup5 = new
			        VirtualCoffeeCup.Builder("Italian").temperature(190).build();
		    VirtualCafe.decrementStock(cup5.getRoast());
		    
		    VirtualCoffeeCup cup6 = new
			        VirtualCoffeeCup.Builder("French").temperature(190).build();
		    VirtualCafe.decrementStock(cup5.getRoast());
	
		    VirtualPerson customer = new VirtualPerson(175, 185); 
		    VirtualCafe.serveCustomer(customer, cup1); 
		    VirtualCafe.serveCustomer(customer, cup2); 
		    VirtualCafe.serveCustomer(customer, cup3);
		    VirtualCafe.serveCustomer(customer, cup4);
		    VirtualCafe.serveCustomer(customer, cup5);
		    VirtualCafe.serveCustomer(customer, cup6);

		}
		catch(OutOfStockException e){
			System.out.println(e.getMessage());
		}
	}
}
