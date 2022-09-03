package cs5004.animator.model;

/**
 * This class represents the move motion. It extends AbtractMotion, which has
 * motionType, shapeName, startTime and endTime.
 * Updates: Added startPosition, endPositiion and their getter methods for the
 *           view.
 * 
 * @author Zuo
 *
 */
public class Move extends AbstractMotion {

  protected Point2D startPosition;
  protected Point2D endPosition;

  /**
   * Creates an move motion given shape name, fromX, fromY, toX, toY, fromTime,
   * and toTime.
   * 
   * @param shapeName name of the shape
   * @param fromX     start x position
   * @param toX       end y position
   * @param fromY     start Y position
   * @param toY       end Y position
   * @param fromTime  start time
   * @param toTime    end time
   */
  public Move(String shapeName, double fromX, double toX, double fromY, double toY, double fromTime,
      double toTime) {
    super(shapeName, fromTime, toTime);
    this.startPosition = new Point2D(fromX, fromY);
    this.endPosition = new Point2D(toX, toY);

    motionType = "Move";
  }

  @Override
  public String toString() {
    String output = super.toString();
    output = this.shapeName + " moves from " + startPosition.toString() + " to "
        + endPosition.toString() + output;
    return output;
  }

  @Override
  public Point2D getStartPosition() {

    return this.startPosition;
  }

  @Override
  public Point2D getEndPosition() {

    return this.endPosition;
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
    // ignore
    return 0;
  }

  @Override
  public double getEndHeight() {
    // ignore
    return 0;
  }

  @Override
  public Motion tween(double t) {
    double newX = this.tweenHelper(startPosition.getX(), endPosition.getX(), startTime, endTime, t);
    double newY = this.tweenHelper(startPosition.getY(), endPosition.getY(), startTime, endTime, t);
    Motion newMove = new Move("", 0, newX, 0, newY, 0, 0);
    return newMove;
  }

  @Override
  public boolean hasChange() {
    return startPosition.getX() != endPosition.getX() || startPosition.getY() != endPosition.getY();
  }

  /**
   * This new added isEquals are clumsy, I will to make adjustments if I have
   * extra time.
   */
  @Override
  public boolean isEqual(Motion m) {
    return this.shapeName == m.getShapeName() && startPosition.getX() == m.getStartPosition().getX()
        || startPosition.getY() == m.getStartPosition().getY()
            && endPosition.getX() == m.getEndPosition().getX()
        || endPosition.getY() == m.getEndPosition().getY() && startTime == m.getStartTime()
            && endTime == m.getEndTime();

  }

}
