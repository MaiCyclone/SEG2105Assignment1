
public class D2ConvTest {
	public static void main(String[] args) {

		for (int j = 0; j < 10; j++) {
			PointCPD2[] d2ArrayPTP = new PointCPD2[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d2ArrayPTP[i] = new PointCPD2('P', Math.random() * 99999, Math.random() * 360);
				d2ArrayPTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Polar in design2 " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCPD2[] d2ArrayPTC = new PointCPD2[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d2ArrayPTC[i] = new PointCPD2('P', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d2ArrayPTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Cartesian in design2 " + duration + "ms");
		}

	}

}
