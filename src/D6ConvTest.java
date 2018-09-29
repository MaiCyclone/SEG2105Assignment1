
public class D6ConvTest {
	public static void main(String[] args) {

		for (int j = 0; j < 10; j++) {
			PointCPD6[] d3ArrayCTP = new PointCPD6[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d3ArrayCTP[i] = new PointCPD6('C', Math.random() * 99999, Math.random() * 360);
				d3ArrayCTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Cartesian to Polar in design6 " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCPD6[] d3ArrayCTC = new PointCPD6[100000000];
			long startTime = System.nanoTime();
			// methodToTime

			for (int i = 0; i < 25000000; i++) {
				d3ArrayCTC[i] = new PointCPD6('C', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d3ArrayCTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Cartesian to Cartesian in design3 " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCPD6[] d2ArrayPTP = new PointCPD6[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d2ArrayPTP[i] = new PointCPD6('P', Math.random() * 99999, Math.random() * 360);
				d2ArrayPTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Polar in design6 " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCPD6[] d2ArrayPTC = new PointCPD6[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d2ArrayPTC[i] = new PointCPD6('P', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d2ArrayPTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Polar to Cartesian in design6 " + duration + "ms");
		}

	}

}
