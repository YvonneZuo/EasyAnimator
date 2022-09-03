import static org.junit.Assert.assertEquals;

import cs5004.animator.controller.AnimatorControllerImpl;
import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Motion;
import cs5004.animator.model.Move;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Resize;
import cs5004.animator.model.Shape;
import cs5004.animator.view.TextView;
import org.junit.Test;

/**
 * Tests for TextView with all shapes and all motions.
 * 
 * @author Zuo
 *
 */
public class TextViewTest {

  private AnimatorModelImpl newModel = new AnimatorModelImpl();
  private double speed = 1;

  /**
   * Test for text view with all shapes and all motions..
   */
  @Test
  public void testTextView() {

    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(255, 0, 0));
    newModel.addShape(s1);
    StringBuilder log = new StringBuilder();

    new AnimatorControllerImpl(new TextView(), newModel, log, speed).animate();
    String expected = "Name: R\n" + "Type: rectangle\n" + "Color: (255.0, 0.0, 0.0)\n"
        + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n";
    assertEquals(expected, log.toString());

    Shape s2 = new Ellipse("C", "ellipse", 440, 70, 120, 60, new Color(0, 0, 255));
    newModel.addShape(s2);
    StringBuilder log2 = new StringBuilder();
    new AnimatorControllerImpl(new TextView(), newModel, log2, speed).animate();
    expected = "Name: R\n" + "Type: rectangle\n" + "Color: (255.0, 0.0, 0.0)\n"
        + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n" + "Name: C\n"
        + "Type: ellipse\n" + "Color: (0.0, 0.0, 255.0)\n" + "Position: (440.0 70.0)\n"
        + "x radius: 120.0 y radius: 60.0\n";
    assertEquals(expected, log2.toString());

    Motion m1 = new Move("R", 200, 300, 200, 300, 1, 5);
    newModel.addMotion(m1);
    StringBuilder log3 = new StringBuilder();
    new AnimatorControllerImpl(new TextView(), newModel, log3, speed).animate();
    expected = "Name: R\n" + "Type: rectangle\n" + "Appears at: t=1.0\n" + "Disappears at: t=5.0\n"
        + "Color: (255.0, 0.0, 0.0)\n" + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n"
        + "Name: C\n" + "Type: ellipse\n" + "Color: (0.0, 0.0, 255.0)\n"
        + "Position: (440.0 70.0)\n" + "x radius: 120.0 y radius: 60.0\n"
        + "R moves from Position: (200.0 200.0) to Position: (300.0 300.0) from t=1.0 to t=5.0\n";
    assertEquals(expected, log3.toString());

    Motion m2 = new Resize("R", 50, 25, 100, 100, 5.1, 7);
    newModel.addMotion(m2);
    StringBuilder log4 = new StringBuilder();
    new AnimatorControllerImpl(new TextView(), newModel, log4, speed).animate();
    expected = "Name: R\n" + "Type: rectangle\n" + "Appears at: t=1.0\n" + "Disappears at: t=7.0\n"
        + "Color: (255.0, 0.0, 0.0)\n" + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n"
        + "Name: C\n" + "Type: ellipse\n" + "Color: (0.0, 0.0, 255.0)\n"
        + "Position: (440.0 70.0)\n" + "x radius: 120.0 y radius: 60.0\n"
        + "R moves from Position: (200.0 200.0) to Position: (300.0 300.0) from t=1.0 to t=5.0\n"
        + "R resize from Width: 50.0 Height: 100.0 to Width: 25.0 Height: 100.0 "
        + "from t=5.1 to t=7.0\n";
    assertEquals(expected, log4.toString());

    Motion m3 = new ChangeColor("C", 0, 0, 255, 0, 170, 85, 5, 7);
    newModel.addMotion(m3);
    StringBuilder log5 = new StringBuilder();
    new AnimatorControllerImpl(new TextView(), newModel, log5, speed).animate();
    expected = "Name: R\n" + "Type: rectangle\n" + "Appears at: t=1.0\n" + "Disappears at: t=7.0\n"
        + "Color: (255.0, 0.0, 0.0)\n" + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n"
        + "Name: C\n" + "Type: ellipse\n" + "Appears at: t=5.0\n" + "Disappears at: t=7.0\n"
        + "Color: (0.0, 0.0, 255.0)\n" + "Position: (440.0 70.0)\n"
        + "x radius: 120.0 y radius: 60.0\n"
        + "R moves from Position: (200.0 200.0) to Position: (300.0 300.0) from t=1.0 to t=5.0\n"
        + "C changes color from Color: (0.0, 0.0, 255.0) to Color: (0.0, 170.0, 85.0) "
        + "from t=5.0 to t=7.0\n"
        + "R resize from Width: 50.0 Height: 100.0 to Width: 25.0 Height: 100.0 "
        + "from t=5.1 to t=7.0\n";
    assertEquals(expected, log5.toString());

  }
}
