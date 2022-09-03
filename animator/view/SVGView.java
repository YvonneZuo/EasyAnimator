package cs5004.animator.view;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.Motion;
import cs5004.animator.model.Shape;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This represents a svg view. It implements animatorView interface.
 * 
 * @author Zuo
 *
 */
public class SVGView implements AnimatorView {
  protected String type = "SVG";

  /**
   * Empty constructor to create a svg view.
   */
  public SVGView() {
    // ignore
  }

  @Override
  public void displayText(AnimatorModel model, Appendable out)
      throws UnsupportedOperationException {
    throw new UnsupportedOperationException();

  }

  /**
   * updates: change fileWriter to Appendable to be better tested.
   *
   */
  @Override
  public void displaySvg(ArrayList<Shape> shapeList, Appendable out, double speed)
      throws IOException {
    try {
      out.append(
          "<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
          + "xmlns=\"http://www.w3.org/2000/svg\">\n\n"
          + "<rect>\n  <animate id=\"base\" begin=\"0;base.end\" "
          + "dur=\"10000.0ms\" attributeName=\"visibility\" "
          + "from=\"hide\" to=\"hide\"/>\n</rect>\n");
    } catch (IOException e1) {
      throw new IOException("Could not append first text.");
    }

    for (Shape s : shapeList) {
      if (s.getType().equals("rectangle")) {
        try {
          out.append(String.format(
              "<rect id=\"%s\" x=\"%.1f\" y=\"%.1f\" width=\"%.1f\" height=\"%.1f\" "
              + "fill=\"rgb(%.1f,%.1f,%.1f)\" visibility=\"visible\" >\n",
              s.getName(), s.getPosition().getX(), s.getPosition().getY(), s.getWidth(),
              s.getHeight(), s.getColor().getRed(), s.getColor().getGreen(), s.getColor().getBlue())
              + this.svgMotionHelper(s.getMotionHistory(), "rectangle", speed) + "\n</rect>\n");

        } catch (IOException e1) {
          throw new IOException("Could append shape information.");
        }
      } else if (s.getType().equals("ellipse")) {
        try {
          out.append(String.format(
              "<ellipse id=\"%s\" cx=\"%.1f\" cy=\"%.1f\" rx=\"%.1f\" ry=\"%.1f\" "
              + "fill=\"rgb(%.1f,%.1f,%.1f)\" visibility=\"visible\" >\n",
              s.getName(), s.getPosition().getX(), s.getPosition().getY(), s.getWidth(),
              s.getHeight(), s.getColor().getRed(), s.getColor().getGreen(), s.getColor().getBlue())
              + this.svgMotionHelper(s.getMotionHistory(), "ellipse", speed) + "\n</ellipse>\n");

        } catch (IOException e1) {
          throw new IOException("Could append shape information.");
        }
      }
    }

    try {
      out.append("\n</svg>");
    } catch (IOException e1) {
      throw new IOException("Could append close tag.");
    }

  }

  private String svgMotionHelper(ArrayList<Motion> motionHistory, String shapeType, double speed) {
    String result = "";
    String art1 = "";
    String art2 = "";
    if (shapeType.equals("ellipse")) {
      art1 = "cx";
      art2 = "cy";
    } else {
      art1 = "width";
      art2 = "height";
    }
    for (Motion m : motionHistory) {
      double begin = m.getStartTime() * (100 / speed);
      double dur = m.getEndTime() * (100 / speed) - begin;

      if (m.getMotionType().equals("Move")) {
        if (shapeType.equals("ellipse")) {
          art1 = "cx";
          art2 = "cy";
        } else {
          art1 = "x";
          art2 = "y";
        }
        result += String.format(
            "  <animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                + "attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
            begin, dur, art1, m.getStartPosition().getX(), m.getEndPosition().getX());
        result += String.format(
            "  <animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                + "attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
            begin, dur, art2, m.getStartPosition().getY(), m.getEndPosition().getY());
      } else if (m.getMotionType().equals("Resize")) {
        if (shapeType.equals("ellipse")) {
          art1 = "rx";
          art2 = "ry";
        } else {
          art1 = "width";
          art2 = "height";
        }
        result += String.format(
            "  <animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                + "attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
            begin, dur, art1, m.getStartWidth(), m.getEndWidth());
        result += String.format(
            "  <animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                + "attributeName=\"%s\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n",
            begin, dur, art2, m.getStartHeight(), m.getEndHeight());
      } else if (m.getMotionType().equals("ChangeColor")) {
        result += String.format(
            "  <animate attributeType=\"xml\" begin=\"base.begin+%.1fms\" dur=\"%.1fms\" "
                + "attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
                + "to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />\n",
            begin, dur, m.getStartColor().getRed(), m.getStartColor().getGreen(),
            m.getStartColor().getBlue(), m.getEndColor().getRed(), m.getEndColor().getGreen(),
            m.getEndColor().getBlue());
      }
    }
    return result;

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
