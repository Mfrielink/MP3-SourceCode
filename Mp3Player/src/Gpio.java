class Gpio {
	/* Native methods declaration */
	public native int ioinit();

	public native int iodeinit();

	public native int iowrite(int a, int v);

	public native int ioread(int a);

	// Use static intializer
	static {
		System.loadLibrary("gpio");
	}

	// Main function calls native method

}