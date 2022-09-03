import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Motion;
import cs5004.animator.model.Move;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Resize;
import cs5004.animator.model.Shape;

import org.junit.Test;

/**
 * Tests for the animatorModelImpl.
 * 
 * @author Zuo
 *
 */
public class AnimatorModelImplTest {

  private AnimatorModelImpl model = new AnimatorModelImpl();

  /**
   * Tests for addShape method. Tested with rectangle and ellipse shapes.
   */
  @Test
  public void testAddShape() {
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 
              100.0, new Color(1, 0, 0.0));
    model.addShape(s1);
    String expected = "Name: R\n" + "Type: rectangle\n" + "Color: (1.0, 0.0, 0.0)\n"
        + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n";
    String actual = model.showAnimationText();
    assertEquals(expected, actual);

    Shape s2 = new Ellipse("C", "ellipse", 440, 70, 120, 60, new Color(0, 0, 255));
    model.addShape(s2);
    assertEquals(2, model.getShapeList().size());
  }

  /**
   * Tests for adding the same shape twice. An illegalException error should be
   * thrown.
   */
  @Test
  public void testAddShapeInvalid() {
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(1, 0, 0.0));
    model.addShape(s1);
    try {
      model.addShape(s1);
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }

  }

  /**
   * Tests for addMotion method. Three motions are tested.
   */
  @Test
  public void testAddMotion() {
    Motion m1 = new Move("R", 200, 300, 200, 300, 10, 50);
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(1, 0, 0.0));
    model.addShape(s1);
    model.addMotion(m1);
    String actual = model.showAnimationText();
    String expected = "Name: R\n" + "Type: rectangle\n" + "Appears at: t=10.0\n"
        + "Disappears at: t=50.0\n" + "Color: (1.0, 0.0, 0.0)\n" + "Position: (200.0 200.0)\n"
        + "Width: 50.0 height: 100.0\n"
        + "R moves from Position: (200.0 200.0) to Position: (300.0 300.0) from t=10.0 to t=50.0\n";

    assertEquals(expected, actual);

    // add a move starts earlier
    m1 = new Move("R", 500, 500, 100, 400, 0, 70);
    model.addMotion(m1);
    actual = model.showAnimationText();
    expected = "Name: R\n" + "Type: rectangle\n" + "Appears at: t=0.0\n" + "Disappears at: t=50.0\n"
        + "Color: (1.0, 0.0, 0.0)\n" + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n"
        + "R moves from Position: (500.0 100.0) to Position: (500.0 400.0) from t=0.0 to t=70.0\n"
        + "R moves from Position: (200.0 200.0) to Position: (300.0 300.0) from t=10.0 to t=50.0\n";
    assertEquals(expected, actual);

    Shape s2 = new Ellipse("C", "ellipse", 440, 70, 120, 60, new Color(0, 0, 255));
    model.addShape(s2);

    // add motion Resize
    Motion m3 = new Resize("R", 50, 25, 100, 100, 5.1, 7);
    model.addMotion(m3);
    assertEquals(model.getSortedMotionList().size(), 3);

    // add motion change color
    Motion m4 = new ChangeColor("C", 0, 0, 255, 0, 170, 85, 5, 7);
    model.addMotion(m4);
    assertEquals(model.getSortedMotionList().size(), 4);

  }

  /**
   * Tests for showText method.
   */
  @Test
  public void testShowText() {
    // test print "" if no shape
    assertEquals("", model.showAnimationText());
    // test only shapes not move
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(1, 0, 0.0));
    model.addShape(s1);
    String expected = "Name: R\n" + "Type: rectangle\n" + "Color: (1.0, 0.0, 0.0)\n"
        + "Position: (200.0 200.0)\n" + "Width: 50.0 height: 100.0\n";
    String actual = model.showAnimationText();
    assertEquals(expected, actual);

    // with shapes and motions
    Motion m1 = new Move("R", 200, 300, 200, 300, 10, 50);
    model.addMotion(m1);
    actual = model.showAnimationText();
    expected = "Name: R\n" + "Type: rectangle\n" + "Appears at: t=10.0\n"
        + "Disappears at: t=50.0\n" + "Color: (1.0, 0.0, 0.0)\n" + "Position: (200.0 200.0)\n"
        + "Width: 50.0 height: 100.0\n"
        + "R moves from Position: (200.0 200.0) to Position: "
        + "(300.0 300.0) from t=10.0 to t=50.0\n";

    assertEquals(expected, actual);
  }

  /**
   * Tests for getSortedMotionList method.
   */
  @Test
  public void testGetSortedMotionList() {
    Motion m1 = new Move("R", 200, 300, 200, 300, 10, 50);
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(1, 0, 0.0));
    model.addShape(s1);
    model.addMotion(m1);

    // add a move starts earlier
    m1 = new Move("R", 500, 500, 100, 400, 0, 70);
    model.addMotion(m1);

    assertEquals(model.getSortedMotionList().get(0).getStartTime(), 0.0, 0.001);

  }

  /**
   * Tests for getShapeList method.
   */
  @Test
  public void testGetShapeList() {
    assertEquals(model.getShapeList().size(), 0);
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(1, 0, 0.0));
    model.addShape(s1);

    assertEquals(model.getShapeList().size(), 1);
  }

  /**
   * Tests for setCanvas method.
   */
  @Test
  public void testSetCanvas() {
    model.setCanvas(0, 0, 0, 0);
    assertEquals(model.getCanvas()[0], 0, 0.001);

    model.setCanvas(3.9, 222, 9.0, 0.7);
    assertEquals(model.getCanvas()[1], 222, 0.001);
  }

  /**
   * Tests for invalid color constructor.
   */
  @Test
  public void testColorInvalid() {
    Color c;
    try {
      c = new Color(-1, 0, 0);
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }

    try {
      c = new Color(0, -1, 0);
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }

    try {
      c = new Color(0, 0, -1);
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  /**
   * Tests for getShapeListAtT and tweenhelper methoed.
   */
  @Test
  public void testGetFrameAndTween() {

    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(1, 0, 0.0));
    Motion m1 = new Move("R", 200, 200, 200, 300, 10, 50);
    model.addShape(s1);
    model.addMotion(m1);
    // get frame before the beginning of the motion
    assertEquals(0, model.getShapeListAtT(0).size());

    // get frame at the end of the motion
    Shape s = model.getShapeListAtT(50).get(0);
    assertEquals(1, model.getShapeList().size());

    assertEquals(200, s.getPosition().getX(), 0.001); // make sure tween method works fine
    assertEquals(300, s.getPosition().getY(), 0.001); // make sure tween method works fine
    assertEquals(50, s.getWidth(), 0.001); // width stays unchanged
    assertEquals(100, s.getHeight(), 0.001); // height stays unchanged

    // get frame at the beginning of the motion
    model.getShapeListAtT(10);
    assertEquals(2, model.getShapeList().size());

    // get frame at the middle of the motion
    Shape s2 = model.getShapeListAtT(20).get(2);
    assertEquals(3, model.getShapeList().size());
    assertEquals(200, s2.getPosition().getX(), 0.001); // make sure tween method works fine
    assertEquals(225, s2.getPosition().getY(), 0.001);

  }

}
