package cs5004.animator.model;

/**
 * This represents a resize motion. It extends abstractMotion class.
 * 
 * @updates: Added fromWidth, fromHeight, toWidth, toHeight and their getter
 *           methods for the view.
 * @author Zuo
 *
 */
public class Resize extends AbstractMotion {

  protected double fromWidth;
  protected double fromHeight;
  protected double toWidth;
  protected double toHeight;

  /**
   * Creates a resize motion given shape name, fromWidth, fromHeight, toWidth,
   * toHeight, fromTime, and toTime.
   * 
   * @param shapeName  of the motion to be performed
   * @param fromWidth  start width
   * @param toWidth    end width
   * @param fromHeight start height
   * @param toHeight   end height
   * @param fromTime   start time
   * @param toTime     end time
   * @throws IllegalArgumentException will be thrown if the width or height is
   *                                  less than 0.
   */
  public Resize(String shapeName, double fromWidth, double toWidth, double fromHeight,
      double toHeight, double fromTime, double toTime) throws IllegalArgumentException {

    super(shapeName, fromTime, toTime);
    if (fromWidth < 0 || fromHeight < 0 || toWidth < 0 || toHeight < 0) {
      throw new IllegalArgumentException("Width and height must be greater than 0.");
    }
    this.fromWidth = fromWidth;
    this.fromHeight = fromHeight;
    this.toWidth = toWidth;
    this.toHeight = toHeight;

    motionType = "Resize";
  }

  @Override
  public String toString() {
    String output = super.toString();
    output = this.shapeName + " resize from Width: " + String.valueOf(fromWidth) + " Height: "
        + String.valueOf(fromHeight) + " to Width: " + String.valueOf(toWidth) + " Height: "
        + String.valueOf(toHeight) + output;
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

    return this.fromWidth;
  }

  @Override
  public double getStartHeight() {

    return this.fromHeight;
  }

  @Override
  public Color getStartColor() {
    // ignore
    return null;
  }

  @Override
  public Color getEndColor() {
    // ignore
    return null;
  }

  @Override
  public double getEndWidth() {

    return this.toWidth;
  }

  @Override
  public double getEndHeight() {

    return this.toHeight;
  }

  @Override
  public Motion tween(double t) {
    double newWidth = this.tweenHelper(fromWidth, toWidth, startTime, endTime, t);
    double newHeight = this.tweenHelper(fromHeight, toHeight, startTime, endTime, t);
    Motion newResize = new Resize("", 0, newWidth, 0, newHeight, 0, 0);
    return newResize;
  }

  @Override
  public boolean hasChange() {
    return fromWidth != toWidth || fromHeight != toHeight;
  }

  /**
   * This new added isEquals are clumsy, I will make adjustments later.
   */
  @Override
  public boolean isEqual(Motion m) {
    return this.shapeName == m.getShapeName() && fromWidth == m.getStartWidth()
        && toWidth == m.getEndWidth() && fromHeight == m.getStartHeight()
        && toHeight == m.getEndHeight() && startTime == m.getStartTime()
        && endTime == m.getEndTime();

  }
}
