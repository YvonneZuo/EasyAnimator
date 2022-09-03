package cs5004.animator.model;

/**
 * This class represents a motion, which is comparable based on the start time.
 * Updates: 1. Added getStartPosition , getEndPosition, getStartWidth,
 * getEndWidth, getStartColor, getEndColor to the interface, since views need
 * these information. for SVG view use.
 * 2. Added tween method for the model and view to get tweened motions at
 * specific t.
 * 3. Added hasChange method to check if the motion is really going to change
 * the shape. So the text view can only print out the motions that
 * matters(brings changes).
 * 4. Added isEqual method to all motions, so no duplicate motion could be added
 * to shapes and the model.
 * 5. Added isConflict method to avoid motion at the same time.
 * 
 * @author Zuo
 *
 */
public interface Motion extends Comparable<Motion> {

  /**
   * Gets the motion type of the motion.
   * 
   * @return a string of motion type
   */
  String getMotionType();

  /**
   * Gets the start time of the motion.
   * 
   * @return start time in double
   */
  double getStartTime();

  /**
   * Gets the end time of the motion.
   * 
   * @return the end time in double
   */
  double getEndTime();

  /**
   * Gets the startPosition of the motion.
   * 
   * @return the position
   */
  Point2D getStartPosition();

  /**
   * Gets the end position of the motion.
   * 
   * @return the end position
   */
  Point2D getEndPosition();

  /**
   * Gets the start width of the motion.
   * 
   * @return the width in double
   */
  double getStartWidth();

  /**
   * Gets the start height of the motion.
   * 
   * @return the start height in double
   */
  double getStartHeight();

  /**
   * Gets the end width of the motion.
   * 
   * @return end width in double
   */
  double getEndWidth();

  /**
   * Gets the end height of the motion.
   * 
   * @return end height in double
   * 
   */
  double getEndHeight();

  /**
   * Gets the start color of the motion.
   * 
   * @return the start color.
   */
  Color getStartColor();

  /**
   * Gets the end color of the motion.
   * 
   * @return the end color
   */
  Color getEndColor();

  /**
   * Gets the shape name of the motion performed.
   * 
   * @return the shape name
   */
  String getShapeName();

  /**
   * Gets the tweened motion at given t.
   * 
   * @param t given time or tick
   * @return a new motion
   */
  Motion tween(double t);

  /**
   * Check if the motion really makes any change.
   * 
   * @return true if it changes something, otherwise false
   */
  boolean hasChange();

  /**
   * Checks if the motion is equal to another motion.
   * 
   * @param m the other motion to be compared
   * @return true if they are the same, otherwise false
   */
  boolean isEqual(Motion m);

  /**
   * Checks if the motions have conflicts.
   * 
   * @param m another motion
   * @return true if they happen during the same time on the same shape, otherwise
   *         false
   */
  boolean isConflict(Motion m);

}
