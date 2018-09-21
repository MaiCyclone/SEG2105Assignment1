
public class PointCPD6Polar implements PointCPD6_Interface {
	// Instance variables ************************************************

	/**
	 * Contains P(olar) to identify the type of
	 */
	private char typeCoord = 'P';
	/**
	 * Contains the current value of RHO.
	 */
	private double rho;

	/**
	 * Contains the current value of THETA.
	 */
	private double theta;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */
	public PointCPD6Polar(char type, double rho, double theta) {
		if (type != 'P')
			throw new IllegalArgumentException();
		this.rho = rho;
		this.theta = theta;
		typeCoord = type;
	}

	// Instance methods **************************************************

	public double getX() {

		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	public double getY() {

		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	public double getRho() {

		return rho;

	}

	public double getTheta() {

		return theta;

	}

	/**
	 * Converts Cartesian coordinates to Polar coordinates.
	 */
	public void convertStorageToPolar() {

		// Calculate RHO and THETA
		double temp = getRho();
		theta = getTheta();
		rho = temp;

		typeCoord = 'P'; // Change coord type identifier

	}

	/**
	 * Converts Polar coordinates to Cartesian coordinates.
	 */
	public void convertStorageToCartesian() {

		// Calculate X and Y
		double temp = getX();
		theta = getY();
		rho = temp;

		typeCoord = 'C'; // Change coord type identifier

	}

	/**
	 * Calculates the distance in between two points using the Pythagorean
	 * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA
	 *            The first point.
	 * @param pointB
	 *            The second point.
	 * @return The distance between the two points.
	 */
	public double getDistance(PointCP pointB) {
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	/**
	 * Rotates the specified point by the specified number of degrees. Not
	 * required until E2.30
	 *
	 * @param point
	 *            The point to rotate
	 * @param rotation
	 *            The number of degrees to rotate the point.
	 * @return The rotated image of the original point.
	 */
	public PointCP rotatePoint(double rotation) {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCP('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
				(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString() {
		return "Stored as " + (typeCoord == 'C' ? "Cartesian  (" + getX() + "," + getY() + ")"
				: "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
	}
}