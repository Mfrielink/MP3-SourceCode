public class Hui {
	
	
	Gpio io = new Gpio();

	int buttonCombi1;
	int buttonCombi2;
	boolean nextSong = false;
	boolean previousSong = false;
	boolean fastForwardSong = false;
	boolean fastRewindSong = false;
	boolean playPauseButton = false;

	public void checkInput() {
		io.ioinit();
		readNextButton();
		readBackButton();
		readPlayPauseButton();
		io.iodeinit();
	}

	public void readCombination() {
		buttonCombi1 = io.ioread(94);
		buttonCombi2 = io.ioread(84);

		if (buttonCombi1 == 1 && buttonCombi2 == 1) {

		}

		if (buttonCombi1 == 1 && buttonCombi2 == 0) {

		}

		if (buttonCombi1 == 0 && buttonCombi2 == 1) {

		}

		if (buttonCombi1 == 0 && buttonCombi2 == 0) {

		}

	}

	public void readNextButton() {

	}

	public void readBackButton() {

	}

	public void readPlayPauseButton() {

	}

}
