
public class PointCPD6Cartesian implements PointCPD6_Interface {
	// Instance variables ************************************************

	/**
	 * Contains C(artesian) type of coordinates that
	 */
	private char typeCoord = 'C';

	/**
	 * Contains the current value of X or RHO depending on the type of
	 * coordinates.
	 */
	private double x;

	/**
	 * Contains the current value of Y or THETA value depending on the type of
	 * coordinates.
	 */
	private double y;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */
	public PointCPD6Cartesian(char type, double x, double y) {
		if (type != 'C')
			throw new IllegalArgumentException();
		this.x = x;
		this.y = y;
		typeCoord = type;
	}

	// Instance methods **************************************************

	public double getX() {

		return x;

	}

	public double getY() {

		return y;

	}

	public double getRho() {

		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
	}

	public double getTheta() {

		return Math.toDegrees(Math.atan2(y, x));
	}

	/**
	 * Converts Cartesian coordinates to Polar coordinates.
	 */
	public void convertStorageToPolar() {

		// Calculate RHO and THETA
		double temp = getRho();
		y = getTheta();
		x = temp;

		typeCoord = 'P'; // Change coord type identifier

	}

	/**
	 * Converts Polar coordinates to Cartesian coordinates.
	 */
	public void convertStorageToCartesian() {

		// Calculate X and Y
		double temp = getX();
		y = getY();
		x = temp;

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
				: "Polar [" + getX() + "," + getY() + "]") + "\n";
	}
}
