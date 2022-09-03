package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This represents an abstractShape. It implements shape interface.
 * Updates: 1. Deleted getSize method, since it's useless. 2. Added transform
 * method to abstractShapes, to make shape change upon different motions.
 * 
 * @author Zuo
 *
 */
public abstract class AbstractShape implements Shape {
  protected String name;
  protected String type;
  protected Point2D position;
  protected double width;
  protected double height;
  protected Color color;
  protected ArrayList<Motion> motionHistory;

  /**
   * Creates an abstractShape give name, type, x, y, width, height, and color.
   * 
   * @param name   of the shape
   * @param type   type of the shape, now only rectangle and ellipse
   * @param x      position-x of the shape
   * @param y      position-y of the shape
   * @param width  of the shape
   * @param height of the shape
   * @param color  of the shape
   * @throws IllegalArgumentException will be thrown if width and height less than
   *                                  0.
   */
  public AbstractShape(String name, String type, double x, double y, double width, double height,
      Color color) throws IllegalArgumentException {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and height should not be negative.");
    }
    this.name = name;
    this.type = type;
    position = new Point2D(x, y);
    this.width = width;
    this.height = height;
    this.color = color;
    this.motionHistory = new ArrayList<>();
  }

  /**
   * Shapes can be compared by their appearing time(a.k.a. the start time of the
   * first motion). if the shape's appearing time is later than shape o's, returns
   * 1, if earlier returns -1, equals returns 0.
   */
  @Override
  public int compareTo(Shape o) {
    return this.motionHistory.get(0).compareTo(o.getMotionHistory().get(0));

  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public ArrayList<Motion> getMotionHistory() {
    return this.motionHistory;
  }

  @Override
  public void addMotion(Motion m) {
    this.motionHistory.add(m);
    Collections.sort(this.motionHistory);

  }

  @Override
  public String toString() {
    String output = "";
    output += "Name: " + this.name + "\n" + "Type: " + this.type + "\n";
    if (!motionHistory.isEmpty()) {
      output += "Appears at: t=" 
          + String.valueOf(motionHistory.get(0).getStartTime()) + "\n";
      output += "Disappears at: t="
          + String.valueOf(motionHistory.get(motionHistory.size() - 1).getEndTime()) + "\n";
    }
    output += color.toString() + "\n";
    output += position.toString() + "\n";
    return output;
  }

  @Override
  public void transform(Motion m) {
    // I only considered the end statistics, not should it will work fine
    if (m.getMotionType().equals("Move")) {
      Point2D newPosition = m.getEndPosition();
      this.position = newPosition;
    } else if (m.getMotionType().equals("Resize")) {
      this.width = m.getEndWidth();
      this.height = m.getEndHeight();
    } else if (m.getMotionType().equals("ChangeColor")) {
      this.color = m.getEndColor();
    }
    return;

  }

  @Override
  public String getStringMotions() {
    String s = "";
    for (Motion m : this.motionHistory) {
      s += m.toString();
    }
    return s;

  }

}
