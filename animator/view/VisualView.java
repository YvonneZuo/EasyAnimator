package cs5004.animator.view;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * This represents a visualView.
 * It extends JFrame, implements AnimatorView and actionListener.
 * 
 * @author Zuo
 *
 */
public class VisualView extends JFrame implements AnimatorView, ActionListener {

  /**
   * Creates a visual view.
   */
  public VisualView() {
    super("Visual View");
    this.setSize(1000, 1200);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true); 

  }

  @Override
  public void displayVisual(ArrayList<Shape> shapeListAtT) {
    AnimatorPanel panel = new AnimatorPanel(shapeListAtT);
    this.add(panel);
    panel.repaint();

  }

  @Override
  public void displayText(AnimatorModel model, Appendable out)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  @Override
  public void displaySvg(ArrayList<Shape> shapeList, Appendable out, double speed)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  @Override
  public String type() {
    return "visual";
  }

  @Override
  public void displayPlayBack(ArrayList<Shape> shapeListAtT) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  @Override
  public void actionPerformed(ActionEvent e) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
    
  }

}
