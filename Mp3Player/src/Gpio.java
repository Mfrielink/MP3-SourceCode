public class Gpio {
	// Native methods declaration
	public native int ioinit();
	public native int iodeinit();
	public native int iowrite(int a, int v);

	public native int ioread(int a);

	// Use static intializer
	static {
		System.loadLibrary("gpio");
	}

	// Main function calls native method
	public static void main(String[] args) {
		Gpio io = new Gpio();

		io.ioinit(); // Initialize GPIO lines
		for (int i = 0; i < 200000; i++) {
			io.iowrite(80, 1); // Make output PB16 high
			System.out.println("PB30: " + io.ioread(94)); // Read status of
															// input PB30
			io.iowrite(80, 0); // Make output PB16 low
			System.out.println("PB30: " + io.ioread(94)); // Read status of
															// input PB30
		}

		io.iodeinit(); // Deinitialize GPIO lines
	}// main

}
