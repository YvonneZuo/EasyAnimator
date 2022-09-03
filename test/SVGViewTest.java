import static org.junit.Assert.assertEquals;

import cs5004.animator.controller.AnimatorControllerImpl;
import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.Color;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Motion;
import cs5004.animator.model.Move;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;
import cs5004.animator.view.SVGView;
import org.junit.Test;


/**
 * Tests for SVG view.
 * 
 * @author Zuo
 *
 */
public class SVGViewTest {

  private AnimatorModelImpl newModel = new AnimatorModelImpl();

  /**
   * Tests for svg view.
   */
  @Test
  public void testSVGView() {
    double speed = 1;
    Shape s1 = new Rectangle("R", "rectangle", 200.0, 200.0, 50.0, 100.0, new Color(255, 0, 0));
    newModel.addShape(s1);
    StringBuilder log = new StringBuilder();
    new AnimatorControllerImpl(new SVGView(), newModel, log, speed).animate();

    String expected = "<svg width=\"1000\" height=\"1000\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "\n" + "<rect>\n"
        + "  <animate id=\"base\" begin=\"0;base.end\" dur=\"10000.0ms\" "
        + "attributeName=\"visibility\" from=\"hide\" to=\"hide\"/>\n"
        + "</rect>\n"
        + "<rect id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\" "
        + "fill=\"rgb(255.0,0.0,0.0)\" visibility=\"visible\" >\n"
        + "\n" + "</rect>\n" + "\n" + "</svg>";
    assertEquals(expected, log.toString());

    Shape s2 = new Ellipse("E", "ellipse", 500.0, 100.0, 60.0, 30.0, new Color(0, 225, 0));
    newModel.addShape(s2);
    Motion m2 = new Move("E", 500, 600, 100, 400, 2, 7);
    newModel.addMotion(m2);
    StringBuilder log2 = new StringBuilder();
    new AnimatorControllerImpl(new SVGView(), newModel, log2, speed).animate();
    String expected2 = "<svg width=\"1000\" height=\"1000\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "\n" + "<rect>\n"
        + "  <animate id=\"base\" begin=\"0;base.end\" dur=\"10000.0ms\" "
        + "attributeName=\"visibility\" from=\"hide\" to=\"hide\"/>\n"
        + "</rect>\n"
        + "<rect id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\" "
        + "fill=\"rgb(255.0,0.0,0.0)\" visibility=\"visible\" >\n"
        + "\n" + "</rect>\n"
        + "<ellipse id=\"E\" cx=\"500.0\" cy=\"100.0\" rx=\"60.0\" ry=\"30.0\" "
        + "fill=\"rgb(0.0,225.0,0.0)\" visibility=\"visible\" >\n"
        + "  <animate attributeType=\"xml\" begin=\"base.begin+200.0ms\" dur=\"500.0ms\" "
        + "attributeName=\"cx\" from=\"500.0\" to=\"600.0\" fill=\"freeze\" />\n"
        + "  <animate attributeType=\"xml\" begin=\"base.begin+200.0ms\" dur=\"500.0ms\" "
        + "attributeName=\"cy\" from=\"100.0\" to=\"400.0\" fill=\"freeze\" />\n"
        + "\n" + "</ellipse>\n" + "\n" + "</svg>";
    assertEquals(expected2, log2.toString());
  }

}
