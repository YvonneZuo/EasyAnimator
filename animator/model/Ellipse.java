package cs5004.animator.model;

/**
 * This class represents ellipse. Both oval and circle are ellipses. Note that x
 * radius and y radius are treated as width and height.
 * 
 * @author Zuo
 *
 */
public class Ellipse extends AbstractShape {

  /**
   * Creates a ellipse given name, type, x, y, x-width, y-height, and color.
   * 
   * @param name   the name of the ellipse
   * @param type   the type of the ellipse, which should be ellipse.
   * @param x      x center position of the ellipse
   * @param y      y center position of the ellipse
   * @param width  x-width of the ellipse
   * @param height y-height of the ellipse
   * @param color  of the ellipse
   * @throws IllegalArgumentException if the color cannot be instantiated
   */
  public Ellipse(String name, String type, double x, double y, double width, double height,
      Color color) throws IllegalArgumentException {
    super(name, type, x, y, width, height, color);
  }

  @Override
  public String toString() {
    String output = super.toString();
    output += "x radius: " + String.valueOf(width) + " y radius: " + String.valueOf(height) + "\n";
    return output;
  }

}
