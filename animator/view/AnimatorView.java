package cs5004.animator.view;

import java.io.IOException;
import java.util.ArrayList;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.Shape;

/**
 * This represents an AnimatorView interface.
 * 
 * @author Zuo
 *
 */
public interface AnimatorView {

  /**
   * Displays the text view given a shape list and an Appendable.
   * @param model the model of the animator
   * @param out an appenable
   * @throws IOException will be thrown if append fails.
   */
  void displayText(AnimatorModel model, Appendable out) throws IOException;

  /**
   * Displays the SVG view given a shape list, an Appendable, and a speed.
   * Updates: 1. Changed fileWriter to Appendable to be better tested. 2. Added
   *           speed as parameter to adjust svg speed.
   * @param shapeList a list of shapes.
   * @param out       an appendable
   * @throws IOException if appendable goes wrong
   */
  void displaySvg(ArrayList<Shape> shapeList, Appendable out, double speed) throws IOException;

  /**
   * Displays visual view given a shapeList.
   * 
   * @Updates: Deleted model and speed parameters,and made shapeListAtT as the
   *           only parameter. So that now the speed control is given to the
   *           controller instead of the view.
   * @param shapeListAtT a list of shapes at given t.
   */
  void displayVisual(ArrayList<Shape> shapeListAtT);

  /**
   * Displays playBack view given a shapeList.
   * 
   * @param shapeListAtT a list of shapes at given t.
   */
  void displayPlayBack(ArrayList<Shape> shapeListAtT);

  /**
   * Gets the type of the view.
   * 
   * @return the type of the view in string.
   */
  String type();

}
