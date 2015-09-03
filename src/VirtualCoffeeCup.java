
public class VirtualCoffeeCup {
	private final String roast;
	private final int temp;
	
	public static class Builder{
		private int temperature;
		private String roast;
		
		public Builder(String roast){
			this.roast = roast;
		}
		
		public Builder temperature(int temp){
			this.temperature = temp;
			return this;
		}
		
		public Builder roast(String roast){
			this.roast = roast;
			return this;
		}
		
		public VirtualCoffeeCup build(){
			return new VirtualCoffeeCup(this);
		}
	}
	
	private VirtualCoffeeCup(Builder builder){
		this.temp = builder.temperature;
		this.roast = builder.roast;
	}
	
	public String getRoast(){
		return roast;
	}
	
	public int getTemperature(){
		return temp;
	}
}
