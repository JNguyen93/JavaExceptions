
public class TemperatureException extends Exception{
	private int tempdiff;
	
	public TemperatureException(){
		
	}
	
	public TemperatureException(String message){
		super(message);
	}
	
	public TemperatureException(String message, int diff){
		super(message);
		this.tempdiff = diff;
	}
	
	public int getTempDiff(){
		return tempdiff;
	}
}
