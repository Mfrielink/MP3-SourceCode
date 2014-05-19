package src;

public class Hui {

	Gpio io = new Gpio();
	int buttonCombi1;
	int buttonCombi2;
	int rotaryDial1;
	int rotartDial2;
	boolean nextSong = false;
	boolean previousSong = false;
	boolean fastForwardSong = false;
	boolean fastRewindSong = false;
	boolean playPauseButton = false;
	long timePressed;

	public void checkInput() {
		io.ioinit();
		buttonCombi1 = io.ioread(94);
		buttonCombi2 = io.ioread(84);
		io.iodeinit();
	}

	public void readNextButton() {
		if (buttonCombi1 == 1 && buttonCombi2 == 0) {

		}
		while (buttonCombi1 == 1 && buttonCombi2 == 0) {
			checkInput();
			if ((System.currentTimeMillis() - timePressed) > 1000) {
				fastForwardSong = true;
			}
		}
		if ((System.currentTimeMillis() - timePressed) < 1000) {
			nextSong = true;
		} else {
			fastForwardSong = false;
		}
	}

	public void readBackButton() {
		if (buttonCombi1 == 0 && buttonCombi2 == 1) {
			timePressed = System.currentTimeMillis();
		}
		while (buttonCombi1 == 0 && buttonCombi2 == 1) {
			checkInput();
			if ((System.currentTimeMillis() - timePressed) > 1000) {
				fastRewindSong = true;
			}
		}
		if ((System.currentTimeMillis() - timePressed) < 1000) {
			previousSong = true;
		} else {
			fastRewindSong = false;
		}

	}

	public void readPlayPauseButton() {
		if (buttonCombi1 == 1 && buttonCombi2 == 1) {
			playPauseButton = true;
		}

	}


	public boolean isNextSong() {
		return nextSong;
	}


	public void setNextSongFalse() {
		nextSong = false;
	}


	public boolean isPreviousSong() {
		return previousSong;
	}


	public void setPreviousSongFalse() {
		previousSong = false;
	}


	public boolean isPlayPauseButton() {
		return playPauseButton;
	}


	public void setPlayPauseButtonFalse() {
		 playPauseButton = false;
	}


	public boolean isFastForwardSong() {
		return fastForwardSong;
	}


	public boolean isFastRewindSong() {
		return fastRewindSong;
	}

	
}
