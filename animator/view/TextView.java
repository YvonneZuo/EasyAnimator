package cs5004.animator.view;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.Shape;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This represents a textView. It implements animatorView interface.
 * 
 * @author Zuo
 *
 */
public class TextView implements AnimatorView {
  protected String type = "Text";

  /**
   * Creates a textView.
   */
  public TextView() {
    // ignore
  }

  @Override
  public void displayText(AnimatorModel model, Appendable out) throws IOException {
    try {
      out.append(model.showAnimationText());
    } catch (IOException e1) {
      throw new IOException("Could append the animation text.");
    }

  }

  @Override
  public void displaySvg(ArrayList<Shape> shapeList, Appendable out, double speed)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  @Override
  public String type() {

    return type;
  }

  @Override
  public void displayVisual(ArrayList<Shape> shapeListAtT) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  @Override
  public void displayPlayBack(ArrayList<Shape> shapeListAtT) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

}
