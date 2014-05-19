import java.io.File;
import java.io.IOException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;


public class InfoSd {

	
	private String title;
	private long time;

	File folder = new File("C:/Users/Martijn/Documents/Files");
	File[] listOfFiles = folder.listFiles();

	public String getSongName(int x) {

		Mp3File mp3file = null;

		try {
			try {
				mp3file = new Mp3File("C:/Users/Martijn/Documents/Files/"
						+ listOfFiles[x].getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedTagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String artist = mp3file.getId3v2Tag().getArtist();
		String name = mp3file.getId3v2Tag().getTitle();
		title = artist + " - " + name;
		System.out.println(title);

		return title;
	}

	public long getSongTime(int x) {

		Mp3File mp3file = null;
		try {
			mp3file = new Mp3File("C:/Users/Martijn/Documents/Files/"
					+ listOfFiles[x].getName());
		} catch (UnsupportedTagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Length of this mp3 is: "
				+ mp3file.getLengthInSeconds() + " seconds");

		time = mp3file.getLengthInSeconds();

		// Add function for changing total seconds to minutes + seconds.

		return time;
	}
	
}
