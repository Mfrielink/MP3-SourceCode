
public class Hui {
	Gpio io = new Gpio();
	public void checkInput(){
		io.ioinit();
		readNextButton();
		readBackButton();
		readPlayPauseButton();
		io.iodeinit();
	}
	
	public void readNextButton(){
		
	}
	
	public void readBackButton(){
		
	}
	
	public void readPlayPauseButton(){
		
	}
	
}
