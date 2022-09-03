package cs5004.animator.model;

/**
 * This represents the color of a shape. Each color consists of red, blue and
 * green.
 * 
 * @author Zuo
 *
 */
public class Color {
  private double red;
  private double blue;
  private double green;

  /**
   * Creates a color given red, green and blue value.
   * 
   * @param r1 red value
   * @param g1 green value
   * @param b1 blue value
   * @throws IllegalArgumentException is below 0 or beyond 255
   */
  public Color(double r1, double g1, double b1) throws IllegalArgumentException {
    if (r1 > 255 || r1 < 0 || g1 > 255 || g1 < 0 || b1 > 255 || b1 < 0) {
      throw new IllegalArgumentException("All color values must between 0 to 255.");
    }
    this.red = r1;
    this.blue = b1;
    this.green = g1;
  }

  /**
   * Gets the red value of the color.
   * 
   * @return the red value
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Gets the green value of the color.
   * 
   * @return the green value
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Gets the blue value of the color.
   * 
   * @return the blue value
   */
  public double getBlue() {
    return this.blue;
  }

  @Override
  public String toString() {
    return "Color: (" + String.valueOf(red) + ", " + String.valueOf(green) + ", "
        + String.valueOf(blue) + ")";
  }

}
