/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }
    
    // Draws a Sierpinski triangle of depth n on the standard canvass.
    public static void sierpinski (int n) {
        // pass x1, x2, x3, y1, y2, y3
        sierpinski(n, 0.0, 1.0, 0.5, 0.0, 0.0, Math.sqrt(3) / 2);
    }
    
    // Does the actual drawing, recursively.
    private static void sierpinski(int n, double x1, double x2, double x3,
                                         double y1, double y2, double y3) {
        if (n == 0) {
            // Draw the triangle
            drawTriangle(x1, x2, x3, y1, y2, y3);
        } else {
            // Calculate midpoints
            double mx1 = (x1 + x2) / 2;
            double mx2 = (x2 + x3) / 2;
            double mx3 = (x1 + x3) / 2;
            double my1 = (y1 + y2) / 2;
            double my2 = (y2 + y3) / 2;
            double my3 = (y1 + y3) / 2;

            // Recursively draw the three smaller triangles
            sierpinski(n - 1, x1, mx1, mx3, y1, my1, my3);
            sierpinski(n - 1, mx1, x2, mx2, my1, y2, my2);
            sierpinski(n - 1, mx3, mx2, x3, my3, my2, y3);
        }
    }

    // Minimal placeholder: print triangle vertices.
    private static void drawTriangle(double x1, double x2, double x3,
                                     double y1, double y2, double y3) {
        System.out.printf("Triangle: (%.3f,%.3f) (%.3f,%.3f) (%.3f,%.3f)%n",
                          x1, y1, x2, y2, x3, y3);
    }
}
