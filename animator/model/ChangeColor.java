package cs5004.animator.model;

/**
 * This class represents changeColor motion. It extends abstractMotion and
 * implements Motion interface.
 * Updates: Add fromColor, toColor and their getter methods for the view.
 * 
 * @author Zuo
 *
 */
public class ChangeColor extends AbstractMotion implements Motion {
  final String MotionType = "ChangeColor";
  protected Color fromColor;
  protected Color toColor;

  /**
   * Creates a changeColor motion given shapeName, start color, end color, start
   * time and end time.
   * 
   * @param shapeName the name of the shape
   * @param r1        red of rgb color
   * @param g1        green of rgb color
   * @param b1        blue of rgb color
   * @param r2        red of rgb color
   * @param g2        green of rgb color
   * @param b2        blue of rgb color
   * @param fromTime start time
   * @param toTime end time
   * @throws IllegalArgumentException will be thrown if the time is less than 0.
   */
  public ChangeColor(String shapeName, double r1, double g1, double b1, double r2, double g2,
      double b2, double fromTime, double toTime) throws IllegalArgumentException {

    super(shapeName, fromTime, toTime);
    fromColor = new Color(r1, g1, b1);
    toColor = new Color(r2, g2, b2);
    motionType = "ChangeColor";
  }

  @Override
  public String toString() {
    String output = super.toString();
    output = this.shapeName + " changes color from " + fromColor.toString() + " to "
        + toColor.toString() + output;
    return output;
  }

  @Override
  public Point2D getStartPosition() {
    // ignore
    return null;
  }

  @Override
  public Point2D getEndPosition() {
    // ignore
    return null;
  }

  @Override
  public double getStartWidth() {
    // ignore
    return 0;
  }

  @Override
  public double getStartHeight() {
    // ignore
    return 0;
  }

  @Override
  public double getEndWidth() {
    // ignore
    return 0;
  }

  @Override
  public double getEndHeight() {
    // ignore
    return 0;
  }

  @Override
  public Color getStartColor() {

    return this.fromColor;
  }

  @Override
  public Color getEndColor() {

    return this.toColor;
  }

  @Override
  public Motion tween(double t) {
    double newRed = Math
        .round(this.tweenHelper(fromColor.getRed(), toColor.getRed(), startTime, endTime, t));
    double newGreen = Math
        .round(this.tweenHelper(fromColor.getGreen(), toColor.getGreen(), startTime, endTime, t));
    double newBlue = Math
        .round(this.tweenHelper(fromColor.getBlue(), toColor.getBlue(), startTime, endTime, t));
    Motion newMotion = new ChangeColor("", 0, 0, 0, newRed, newGreen, newBlue, 0, 0);
    return newMotion;
  }

  @Override
  public boolean hasChange() {
    return fromColor.getRed() != toColor.getRed() || fromColor.getGreen() != toColor.getGreen()
        || fromColor.getBlue() != toColor.getBlue();
  }

  /**
   * This new added isEquals are clumsy, but I have no time to make adjustments.
   */
  @Override
  public boolean isEqual(Motion m) {
    return this.shapeName == m.getShapeName() && fromColor.getRed() == m.getStartColor().getRed()
        && fromColor.getGreen() == m.getStartColor().getGreen()
        && fromColor.getBlue() == m.getStartColor().getBlue()
        && toColor.getRed() == m.getEndColor().getRed()
        && toColor.getGreen() == m.getEndColor().getGreen()
        && toColor.getBlue() == m.getEndColor().getBlue() && startTime == m.getStartTime()
        && endTime == m.getEndTime();
  }
}
