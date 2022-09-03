package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This represents an AnimatorModelImple. It implements AnimatorModel interface.
 * Updates: 1. Changed addShape signature to make it simpler to use. 2. Added
 * getFrame method to get the fame at the tick, for the graphic view. 3. Added
 * ShapeListAtT to produce shapes at given t for the view to play; 4. Added
 * canvas and setCanvas for Filereader.
 * 
 * @author Zuo
 *
 */
public class AnimatorModelImpl implements AnimatorModel {
  protected ArrayList<Shape> shapeList;
  protected ArrayList<Motion> sortedMotionList; // for text order view
  protected ArrayList<Shape> shapeListAtT;
  protected double[] canvas;

  /**
   * It creates an AnimatorModelImpl. Initialize the shapeList as an empty
   * arayList of shape. Initialize the sortedMotionList as an empty arayList of
   * motion. Initialize the shapeListAtT as an empty arayList of shape. Initialize
   * the canvas as an empty array of 4.
   */
  public AnimatorModelImpl() {
    this.shapeList = new ArrayList<Shape>();
    this.sortedMotionList = new ArrayList<Motion>();
    this.shapeListAtT = new ArrayList<Shape>();
    this.canvas = new double[4];
  }

  @Override
  public void setCanvas(double x, double y, double width, double height) {
    this.canvas[0] = x;
    this.canvas[1] = y;
    this.canvas[2] = width;
    this.canvas[3] = height;
  }

  @Override
  public void addShape(Shape s) throws IllegalArgumentException {
    for (Shape shape : shapeList) {
      if (shape.getName() == s.getName()) {
        throw new IllegalArgumentException("Cannot add a shape twice.");
      }
    }
    shapeList.add(s);
    for (Motion m : s.getMotionHistory()) {
      if (m != null) {
        sortedMotionList.add(m);
      }
    }
  }

  @Override
  public void removeShape(String name) {
    for (Shape s : shapeList) {
      if (s.getName().equals(name)) {
        shapeList.remove(s);
      }
    }

  }

  @Override
  public void addMotion(Motion m) {
    for (Shape s : shapeList) {
      if (s.getName().equals(m.getShapeName())) {
        s.addMotion(m);
        sortedMotionList.add(m);
        Collections.sort(sortedMotionList);
      } 
    }
  }

  @Override
  public ArrayList<Shape> getShapeList() {
    return this.shapeList;
  }

  @Override
  public ArrayList<Motion> getSortedMotionList() {
    Collections.sort(sortedMotionList);
    return sortedMotionList;

  }

  /**
   * Prints out the text description of the current model. Prints empty String if
   * there is no shapes at now. Otherwise, it first describes the shapes that are
   * part of the animation and their details. Next it describes how these shapes
   * will move as the animation proceeds from start to finish.
   */
  @Override
  public String showAnimationText() {
    String result = "";
    if (!shapeList.isEmpty()) {
      for (Shape s : shapeList) {
        result += s.toString();
      }
      for (Motion m : sortedMotionList) {
        if (m.hasChange()) {
          result += m.toString() + "\n";
        }
      }
    }
    return result;
  }

  @Override
  public ArrayList<Shape> getShapeListAtT(double t) {

    for (Shape s : this.shapeList) {
      for (Motion m : s.getMotionHistory()) {
        if (m.getEndTime() <= t) {
          s.transform(m);
          this.shapeListAtT.add(s);
        } else if (m.getEndTime() > t && m.getStartTime() <= t) {
          Motion newMotion = m.tween(t);
          s.transform(newMotion);
          this.shapeListAtT.add(s);

        }

      }
    }
    return this.shapeListAtT;
  }

  @Override
  public ArrayList<ArrayList<Shape>> getPlayList() {
    ArrayList<ArrayList<Shape>> playList = new ArrayList<ArrayList<Shape>>();
    int lastTime = (int) this.sortedMotionList.get(this.sortedMotionList.size() - 1).getEndTime();
    for (int t = 0; t <= lastTime; t++) {
      playList.add(getShapeListAtT(t));
    }
    return playList;
  }
  
  public ArrayList<Shape> shapeListAtT() {
    return this.shapeListAtT;
  }

  @Override
  public double[] getCanvas() {
    return this.canvas;
  }

}
