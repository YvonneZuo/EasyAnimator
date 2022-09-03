package cs5004.animator.model;

/**
 * This represents an AbstractMotion class. It implements Motion interface.
 * 
 * @updates: Added tweenHelper method for all motions to calculate.
 * @author Zuo
 *
 */
public abstract class AbstractMotion implements Motion {

  protected String motionType;
  protected String shapeName;
  protected double startTime;
  protected double endTime;

  /**
   * This creates an AbstractMotion. It takes shapeName, fromTime and toTime.
   * 
   * @updates: 1. Added tweenHelper to calculate frames at given ticks. 2. Added
   *           toConflict to avoid concurrent motion. However, I don't have to use
   *           it to debug visual view's concurrent bug.
   * 
   * @param shapeName the name of the shape
   * @param fromTime  the start time of the motion
   * @param toTime    the end time of the motion
   * @throws IllegalArgumentException will be thrown if the time is less than 0.
   */
  public AbstractMotion(String shapeName, double fromTime, double toTime)
      throws IllegalArgumentException {
    if (fromTime < 0 || toTime < 0) {
      throw new IllegalArgumentException("Time should be greater than 0.");
    }
    this.shapeName = shapeName;
    this.startTime = fromTime;
    this.endTime = toTime;

  }

  /**
   * Returns 1 if the motion's start time is later then o's. Returns -1 if the
   * motion starts earlier then o. Returns 0, if they start at the same time.
   */
  @Override
  public int compareTo(Motion o) {
    if (this.startTime > o.getStartTime()) {
      return 1;
    } else if (this.startTime == o.getStartTime()) {
      return 0;
    } else {
      return -1;
    }
  }

  @Override
  public String getMotionType() {
    return this.motionType;
  }

  @Override
  public double getStartTime() {
    return this.startTime;
  }

  @Override
  public double getEndTime() {
    return this.endTime;
  }

  @Override
  public String getShapeName() {
    return this.shapeName;
  }

  @Override
  public String toString() {
    return " from t=" + String.valueOf(startTime) + " to t=" + String.valueOf(endTime);
  }

  /**
   * An helper method to calculate tween at given t.
   * 
   * @param from      the start parameter
   * @param to        the end parameter
   * @param startTime the start time
   * @param endTime   the end time
   * @param t         the current tick
   * @return double
   */
  public double tweenHelper(double from, double to, double startTime, double endTime, double t) {
    double dur = this.endTime - this.startTime;
    double a = ((endTime - t) / dur) * from;
    double b = ((t - startTime) / dur) * to;
    return a + b;

  }

  @Override
  public boolean isConflict(Motion m) {
    boolean timeConflict;
    boolean shapeConflict;
    timeConflict = (this.startTime <= m.getStartTime() && this.endTime >= m.getEndTime()
        || this.startTime >= m.getStartTime() && this.endTime <= m.getEndTime());
    shapeConflict = this.shapeName.equals(m.getShapeName())
        && this.getMotionType().equals(m.getMotionType());
    return shapeConflict && timeConflict;
  }
}
