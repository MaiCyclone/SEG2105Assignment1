
public class TestForAll {
	public static void main(String[] args) {

		PointCPD2[] d2ArrayPTP = new PointCPD2[100000000];
		for (int j = 0; j < 8; j++) {
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 15000000; i++) {
				d2ArrayPTP[i] = new PointCPD2('P', Math.random() * 99999, Math.random() * 360);
				d2ArrayPTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Polar in design2 " + duration + "ms");
		}

		PointCPD2[] d2ArrayPTC = new PointCPD2[100000000];
		for (int j = 0; j < 8; j++) {
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 15000000; i++) {
				d2ArrayPTC[i] = new PointCPD2('P', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d2ArrayPTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Cartesian in design2 " + duration + "ms");
		}

		// long startTime = System.nanoTime();
		// // methodToTime
		// for (int i = 0; i < 20000000; i++) {
		// d2Array[i] = new PointCPD2('P', Math.random() * 99999, Math.random()
		// * 360);
		// d2Array[i].convertStorageToPolar();
		// // d2Array[i].convertStorageToCartesian();
		// }
		// long endTime = System.nanoTime();
		// long duration = (endTime - startTime) / 1000000;
		//
		// System.out.println("Polar to Polar in design2 " + duration + "ms");
	}

}
