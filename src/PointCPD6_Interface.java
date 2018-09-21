
public interface PointCPD6_Interface {
	public double getX();
	public double getY();
	public double getRho();
	public double getTheta();
	public void convertStorageToPolar();
	public void convertStorageToCartesian();
	public double getDistance(PointCP pointB);
	public PointCP rotatePoint(double rotation);
	public String toString();
}
