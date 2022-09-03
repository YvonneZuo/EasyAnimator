package cs5004.animator.view;

import cs5004.animator.model.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;



/**
 * This represents an animatorPanel. It extends JPanel class.
 * 
 * @author Zuo
 *
 */
public class AnimatorPanel extends JPanel {
  ArrayList<ArrayList<Shape>> playList;
  ArrayList<Shape> shapeListAtT;

  /**
   * Creates an animatorPanel given a shape list to play.
   * @param shapeListAtT a list of shapes at given t
   */
  public AnimatorPanel(ArrayList<Shape> shapeListAtT) {
    super(true);
    this.shapeListAtT = shapeListAtT;
    this.setBackground(Color.white);
    this.setSize(1000, 1200);
    this.setLocation(0, 0);
    this.shapeListAtT = shapeListAtT;
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    for (Shape s : shapeListAtT) {
      g2.setColor(new Color((int) s.getColor().getRed(), (int) s.getColor().getGreen(),
          (int) s.getColor().getBlue()));
      if (s.getType().equals("rectangle")) {
        g2.fillRect((int) s.getPosition().getX(), (int) s.getPosition().getX(), (int) s.getWidth(),
            (int) s.getHeight());
      } else if (s.getType().equals("ellipse")) {
        g2.fillOval((int) s.getPosition().getX(), (int) s.getPosition().getX(), (int) s.getWidth(),
            (int) s.getHeight());
      }
    }
  }

}
