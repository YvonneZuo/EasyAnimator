package cs5004.animator.model;

/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x, y).
 * 
 * @author Zuo
 *
 */
public class Point2D {
  private double x;
  private double y;

  /**
   * Construct a 2d point with the given coordinates.
   * 
   * @update: 1. Deleted IllegalArgumentException for the constructor, because x
   *          and y might be negative in some cases.
   *
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return y;
  }

  /**
   * Rest the position to another position.
   * 
   * @param point the other position to be set.
   */
  public void reset(Point2D point) {
    this.x = point.x;
    this.y = point.y;
  }

  @Override
  public String toString() {
    return "Position: (" + String.valueOf(x) + " " + String.valueOf(y) + ")";
  }

}
