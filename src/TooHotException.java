
public class TooHotException extends TemperatureException{
	public TooHotException(){
		
	}
	
	public TooHotException(String message){
		super(message);
	}
	
	public TooHotException(String message, int diff){
		super(message, diff);
	}
}
