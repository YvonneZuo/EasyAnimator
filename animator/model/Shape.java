package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This interface contains all operations that all types of shapes should
 * support.
 * Updates: 1. Deleted getSize method, since it's useless. 2. Added transform
 * method to abstractShapes, to make shape change upon different motions. 3.
 * Added getStringMotions to see all motions a shape has, for debug purpose.
 */
public interface Shape extends Comparable<Shape> {

  /**
   * Gets the name of the shape.
   * 
   * @return the string of name
   */
  String getName();

  /**
   * Gets the type of the shape.
   * 
   * @return string type.
   */
  String getType();

  /**
   * Gets the position of the shape.
   * 
   * @return the position of the shape
   */
  Point2D getPosition();

  /**
   * Gets the width of the rectangle, or x radius of the ellipse.
   * 
   * @return
   */
  double getWidth();

  /**
   * Gets the height of the rectangle, or y radius of the ellipse.
   * 
   * @return
   */
  double getHeight();

  /**
   * Gets the color of the shape.
   * 
   * @return
   */
  Color getColor();


  /**
   * Gets the motion history of the shape.
   * 
   * @return a list of motions
   */
  ArrayList<Motion> getMotionHistory();

  /**
   * Adds motion to a shape.
   * 
   * @param m the motion to be added
   */
  void addMotion(Motion m);

  /**
   * Makes the shape transform according to the motion.
   * 
   * @param m the motion to be performed
   */
  void transform(Motion m);

  /**
   * Gets the all motions a shape has in a single string.
   * 
   * @return a string of all motions
   */
  String getStringMotions();
}
