package cs5004.animator.view;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.Shape;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This represents a playBackView. It extends JFrame, implements AnimatorView
 * and actionListener.
 * 
 * @author Zuo
 *
 */
public class PlayBackView extends JFrame implements AnimatorView, ActionListener {

  /**
   * Creates a play back view.
   */
  public PlayBackView() {
    super("PlayBack View");
    this.setSize(1000, 1200);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonPane = new JPanel(true); // true to visible
    buttonPane.setBackground(Color.WHITE);
    buttonPane.setSize(1000, 50);
    buttonPane.setLocation(0, 0);
    buttonPane.setLayout(new FlowLayout()); // add bars in an line order.

    JButton startButtom = new JButton("start");
    startButtom.setName("start");
    buttonPane.add(startButtom);

    JButton pauseButton = new JButton("pause");
    pauseButton.setName("pause");
    buttonPane.add(pauseButton);

    JButton resumeButton = new JButton("resume");
    resumeButton.setName("resmue");
    buttonPane.add(resumeButton);

    JButton restartButton = new JButton("restart");
    restartButton.setName("restart");
    buttonPane.add(restartButton);

    JButton enableLoopingButton = new JButton("enableLooping");
    enableLoopingButton.setName("enableLooping");
    buttonPane.add(enableLoopingButton);

    JButton disableLoopingButton = new JButton("disableLooping");
    disableLoopingButton.setName("disableLooping");
    buttonPane.add(disableLoopingButton);

    JButton increaseSpeedButton = new JButton("increaseSpeed");
    increaseSpeedButton.setName("increaseSpeed");
    buttonPane.add(increaseSpeedButton);

    JButton decreaseSpeedButton = new JButton("decreaseSpeed");
    decreaseSpeedButton.setName("decreaseSpeed");
    buttonPane.add(decreaseSpeedButton);

    startButtom.addActionListener(this);
    pauseButton.addActionListener(this);
    restartButton.addActionListener(this);
    resumeButton.addActionListener(this);
    enableLoopingButton.addActionListener(this);
    disableLoopingButton.addActionListener(this);
    increaseSpeedButton.addActionListener(this);
    decreaseSpeedButton.addActionListener(this);

    this.add(buttonPane);

    this.setVisible(true); // make to be seen.

  }

  @Override
  public void displayPlayBack(ArrayList<Shape> shapeListAtT) {
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
  public void displayVisual(ArrayList<Shape> shapeListAtT) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  @Override
  public String type() {
    return "playback";
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("pause")) {
      JOptionPane.showMessageDialog(this, "Sorry again.");
    } else if (c.getName().equals("start")) {
      JOptionPane.showMessageDialog(this, "Sorry, I don't know how to do that.");
    } else if (c.getName().equals("restart")) {
      JOptionPane.showMessageDialog(this, "Sorry again again.");
    } else if (c.getName().equals("resume")) {
      JOptionPane.showMessageDialog(this, "Sorry again again again.");
    } else {
      JOptionPane.showMessageDialog(this, "Sorry.");
    }

  }

}
