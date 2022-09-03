package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This presents an animatorModel interface.
 * Updates: 1. Changed addShape signature to make it simpler to use. 2. Added
 * getFrame method to get the fame at the tick, for the graphic view.
 * 
 * @author Zuo
 *
 */
public interface AnimatorModel {

  /**
   * Removes the shape from the model given the name of the shape.
   * 
   * @param name of the shape
   */
  void removeShape(String name);

  /**
   * Adds an motion to the model.
   * 
   * @param m the motion to be added
   */
  void addMotion(Motion m);

  /**
   * Gets the list of all shapes in the model.
   * 
   * @return an array list of shapes
   */
  ArrayList<Shape> getShapeList();

  /**
   * Gets all the motions in the model.
   * 
   * @return a sorted list of all motions.
   */
  ArrayList<Motion> getSortedMotionList();

  /**
   * Shows the animation in text description.
   * 
   * @return the string of text description
   */
  String showAnimationText();

  /**
   * Adds a shape to the model.
   * 
   * @param s shape to be added
   * @throws IllegalArgumentException will be thrown if the shape is already
   *                                  added.
   */
  void addShape(Shape s) throws IllegalArgumentException;

  /**
   * Sets the canvas position, width and height.
   * 
   * @param x      x position of the canvas.
   * @param y      y position of the canvas.
   * @param width  of the canvas.
   * @param height of the canvas.
   */
  void setCanvas(double x, double y, double width, double height);

  /**
   * Gets a list of all shapes at given t.
   * 
   * @param t the specific time or tick
   * @return a list of shapes to play
   */
  ArrayList<Shape> getShapeListAtT(double t);

  /**
   * Gets all the shapes in a list to play.
   * 
   * @return a list of list of shapes.
   */
  ArrayList<ArrayList<Shape>> getPlayList();
  
  /**
   * Gets shape play list model has.
   * @return a list of shape
   */
  ArrayList<Shape> shapeListAtT();

  /**
   * Get the canvas.
   * @return the canvas
   */
  double[] getCanvas();
}
