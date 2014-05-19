

public class Lcd {
	static Gpio io = new Gpio();
	// io.iowrite(Pinnummer, waarde);
	
	public static void init() {
		io.iowrite(6,(short)0x30); // 3 keer 0x030 voor Function set 
		io.iowrite(6,(short)0x30); 
		io.iowrite(6,(short)0x30); 
	}
	
	public static void DisplayOnOff(boolean displayOn) { //lcd display aan of uitzetten, meegeven als parameter
		if(displayOn = true){
			io.iowrite(6,(short)0xF); //Display ON, Cursor ON, Blinking ON
//			io.iowrite(,(short)0xE); //Display ON, Cursor ON, Blinking OFF
		}
		if(displayOn = false) {
			io.iowrite(6,(short)0x8); //Display OFF, Cursor OFF, Blinking ON
		}
	}
	
	public static void clear() { 
		io.iowrite(6,(short)0x1); 
	} 

	public static void homeCursor() { // return cursor to its original position
		io.iowrite(6,(short)0x2);
	}
	
	public static void entryMode(int a) { // assign cursor moving direction and enable the shift of entire display
		if (a == 1) { 
			io.iowrite(6,(short)0x6); //cursor moves to right and DDRAM address is increased by 1
		}
		if (a == 2) {
			io.iowrite(6,(short)0x4); //cursor moves to left and DDRAM address is decreased by 1
		}
		if (a == 3) {
			io.iowrite(6,(short)0x5); //shift entire display Right
		}
		if (a == 4) {
			io.iowrite(6,(short)0x7); //shift entire display left
		}
	}
	
	public static void setCursorPosition( int pos ) { //pos in hexadecimaal
		io.iowrite(6, pos);
		
		if(pos == 0x10) {
			io.iowrite(6, pos-1);
		}
		if(pos == 0x14) {
			io.iowrite(6, pos+1);
		}
		if(pos == 0x18) {
			io.iowrite(6, pos<<1);
		}
		if(pos == 0x1C) {
			io.iowrite(6, pos>>1);
		}
	}
	
//writeText("Hoi");
	public static void writeText( String str ) { 
		for( int idx = 0; idx < str.length(); idx++ ) {
			io.iowrite(6, str.charAt(idx)); 
		}
	}

	public static void writeSign( int tekenCode ) { 
		io.iowrite(0x08, (short) tekenCode ); 
	}

	/** 
	 Write custom char codes. LCD kan 8 custom char's = tekenCode 
	 bevatten. Deze routine schrijft voor 1 tekencode de 8 benodigde 
	 rijen. Procedure: 
					1) Set CGRAM-Address = 8 * tekenCode 
					2) Veronderstel I/D bit in Entry mode op 1, autoincrement adres 
					3) Schrijf de 8 databytes, de rijen van de bitmap 
					4) Set DDRAM-Address (clear home) 
	 */ 
	public static void writeCustomCharCodes( int tekenCode, short[] codes) {
		// Set CGRAM-address = 8 * tekencode 
		io.iowrite(0x06, (short)(0x40 | ((8*tekenCode)&0x3F))); 

		for( int idx = 0; idx < 8; idx++ ) {
			io.iowrite(0x08, (short)codes[idx] ); 
		}

		io.iowrite(0x06, (short)0x01 ); 
	}
	
// ***TEST VERSIE***
	public void maakEigenIcon() { 
	 // Dit zijn de voorbeeld codes 
	 short[] codes = { 0, 10, 10, 0, 17, 14, 6, 0 }; 
	 // Schrijf de codes 
	 
	 Lcd.writeCustomCharCodes( 0, codes ); 
	 } 
	 
	public void testEigenIcon() { 
	 Lcd.writeSign( 0 ); 
	} 
}