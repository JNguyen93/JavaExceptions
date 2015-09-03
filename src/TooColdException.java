
public class TooColdException extends TemperatureException{
	
	public TooColdException(){
		
	}
	
	public TooColdException(String message){
		super(message);
	}
	
	public TooColdException(String message, int diff){
		super(message, diff);
	}
}
