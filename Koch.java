/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		// Base case: if n == 0, just draw the line
		if (n == 0) return;

		// Calculate the points for the Koch curve
		double dx = x2 - x1;
		double dy = y2 - y1;
		double x3 = x1 + dx / 3;
		double y3 = y1 + dy / 3;
		double x4 = x1 + 2 * dx / 3;
		double y4 = y1 + 2 * dy / 3;
		double x5 = (x1 + x2) / 2 - Math.sqrt(3) * (y2 - y1) / 6;
		double y5 = (y1 + y2) / 2 + Math.sqrt(3) * (x2 - x1) / 6;

		// Recursively draw the 4 segments
		curve(n - 1, x1, y1, x3, y3);
		curve(n - 1, x3, y3, x5, y5);
		curve(n - 1, x5, y5, x4, y4);
		curve(n - 1, x4, y4, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		// Draw the three sides of the snowflake
		curve(n, 0.5, 0.5 + Math.sqrt(3) / 6, 0.5 - Math.sqrt(3) / 3, 0.5 - Math.sqrt(3) / 6);
		curve(n, 0.5 - Math.sqrt(3) / 3, 0.5 - Math.sqrt(3) / 6, 0.5, 0.5);
		curve(n, 0.5, 0.5, 0.5 + Math.sqrt(3) / 6, 0.5 + Math.sqrt(3) / 3);
	}
}
