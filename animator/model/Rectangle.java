package cs5004.animator.model;

/**
 * This represents a rectangle shape. It extends abstractShape class.
 * 
 * @author Zuo
 *
 */
public class Rectangle extends AbstractShape {

  /**
   * Creates a rectangle given name, type, x, y, width, height, and color.
   * 
   * @param name   of the rectangle
   * @param type   is rectangle
   * @param x      position x of the rectangle
   * @param y      position y of the rectangle
   * @param width  of the rectangle
   * @param height of the rectangle
   * @param color  of the rectangle
   */
  public Rectangle(String name, String type, double x, double y, double width, double height,
      Color color) {
    super(name, type, x, y, width, height, color);
  }

  @Override
  public String toString() {
    String output = super.toString();
    output += "Width: " + String.valueOf(width) + " height: " + String.valueOf(height) + "\n";
    return output;

  }

}
