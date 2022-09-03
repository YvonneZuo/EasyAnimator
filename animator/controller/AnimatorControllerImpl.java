package cs5004.animator.controller;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.view.AnimatorView;
import java.io.IOException;

/**
 * This represents an AnimatorControllerImpl. It implements animatorController
 * interface. Update: 1. added speed variable to store the speed.
 * 
 * @author Zuo
 *
 */
public class AnimatorControllerImpl implements AnimatorController {

  AnimatorView view;
  AnimatorModel model;
  Appendable out;
  double speed;

  /**
   * Creates an AnimatorControllerImpl given a view, a model, an appendable and a
   * speed. Update: Added speed as parameter to adjust speed of different views.
   * 
   * @param view  the view of the animator
   * @param model the model of the animator
   * @param out   an appendable
   * @param speed speed to play the views
   */
  public AnimatorControllerImpl(AnimatorView view, AnimatorModel model, Appendable out,
      double speed) {
    this.view = view;
    this.model = model;
    this.out = out;
    this.speed = speed;

  }

  @Override
  public void animate() {

    if (view.type().equals("SVG")) {
      try {

        this.view.displaySvg(model.getShapeList(), out, speed);
      } catch (IOException e1) {
        new IOException("Could append the SVG text to the SVG view.");
      }
    } else if (view.type().equals("Text")) {
      try {
        this.view.displayText(model, out);

      } catch (IOException e1) {
        new IOException("Could append the SVG text to the SVG view.");
      }
    } else if (view.type().equals("visual")) {

      try {
        int t = 1;
        while (t <= 100) {
          view.displayVisual(model.getShapeListAtT(t));
          t += 1;
        }

      } catch (UnsupportedOperationException e3) {
        throw new UnsupportedOperationException();
      }
    } else if (view.type().equals("playback")) {
      try {
        int t1 = 4;
        this.view.displayPlayBack(model.getShapeListAtT(t1));
      } catch (UnsupportedOperationException e3) {
        throw new UnsupportedOperationException();
      }
    }

  }

}
