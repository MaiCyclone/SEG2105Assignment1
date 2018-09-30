
public class ODConvTest {
	public static void main(String[] args) {

		for (int j = 0; j < 10; j++) {
			PointCP[] d2ArrayPTP = new PointCP[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d2ArrayPTP[i] = new PointCP('P', Math.random() * 99999, Math.random() * 360);
				d2ArrayPTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Polar in original design " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCP[] d2ArrayPTC = new PointCP[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d2ArrayPTC[i] = new PointCP('P', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d2ArrayPTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Cartesian in original design " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCP[] d3ArrayCTP = new PointCP[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d3ArrayCTP[i] = new PointCP('C', Math.random() * 99999, Math.random() * 360);
				d3ArrayCTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Cartesian to Polar in original design " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCP[] d3ArrayCTC = new PointCP[100000000];
			long startTime = System.nanoTime();
			// methodToTime

			for (int i = 0; i < 25000000; i++) {
				d3ArrayCTC[i] = new PointCP('C', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d3ArrayCTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Cartesian to Cartesian in original design " + duration + "ms");
		}

	}
}
