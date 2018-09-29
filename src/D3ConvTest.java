
public class D3ConvTest {
	public static void main(String[] args) {

		for (int j = 0; j < 10; j++) {
			PointCPD3[] d3ArrayCTP = new PointCPD3[100000000];
			long startTime = System.nanoTime();
			// methodToTime
			for (int i = 0; i < 25000000; i++) {
				d3ArrayCTP[i] = new PointCPD3('C', Math.random() * 99999, Math.random() * 360);
				d3ArrayCTP[i].convertStorageToPolar();
				// d2Array[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Cartesian to Polar in design3 " + duration + "ms");
		}

		for (int j = 0; j < 10; j++) {
			PointCPD3[] d3ArrayCTC = new PointCPD3[100000000];
			long startTime = System.nanoTime();
			// methodToTime

			for (int i = 0; i < 25000000; i++) {
				d3ArrayCTC[i] = new PointCPD3('C', Math.random() * 99999, Math.random() * 360);
				// d2ArrayPTC[i].convertStorageToPolar();
				d3ArrayCTC[i].convertStorageToCartesian();
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			System.out.println("Cartesian to Cartesian in design3 " + duration + "ms");
		}

	}

}
