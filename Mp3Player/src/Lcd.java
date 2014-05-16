public class Lcd {
	static Gpio io = new Gpio();
	
	public static void init() {
		// Init LCD 
		// io.iowrite(Pinnummer, waarde);
		io.iowrite((short)lcd.pin,(short)0x30); // 3 keer 0x030 voor Function set 
		io.iowrite((short)6,(short)0x30); 
		io.iowrite((short)6,(short)0x30); 
		io.iowrite((short)6,(short)0xF); // 8 bit display
		
		 // …….Entry mode, Auto shift left cursor 

		io.iowrite((short)6,(short)0x30);
		io.iowrite((short)6,(short)0x6); //……..Display ON, Cursor ON, Blinking ON 
	} 

	public static void clear() { 
		io.iowrite((short)6,(short)0x1); 
	} 

	public static void homeCursor() { 
		io.iowrite();
	} 

	public static void setCursorPosition( int pos ) { 
		
	}

	public static void writeText( String str ) { 
		for( int idx = 0; idx < str.length(); idx++ ) { 
			io.iowrite(); 
		}
	}

	public static void writeSign( int tekenCode ) { 
		io.iowrite( (short) 0x08, (short) tekenCode ); 
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
		io.iowrite((short)0x06, (short)(0x40 | ((8*tekenCode)&0x3F))); 

		for( int idx = 0; idx < 8; idx++ ) {
			io.iowrite((short)0x08, (short)codes[idx] ); 
		}

		io.iowrite( (short)0x06, (short)0x01 ); 
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