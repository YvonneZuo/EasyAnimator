package cs5004.animator.util;

import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Motion;
import cs5004.animator.model.Move;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Resize;
import cs5004.animator.model.Shape;

/**
 * This represents a animationBuilderImpl. It implements animationBuilder
 * interface.
 * 
 * @author Zuo
 *
 */
public class AnimationBuilderImpl implements AnimationBuilder<AnimatorModelImpl> {
  protected AnimatorModelImpl model = new AnimatorModelImpl();

  @Override
  public AnimatorModelImpl build() {
    return model;
  }

  @Override
  public AnimationBuilder<AnimatorModelImpl> setBounds(int x, int y, int width, int height) {
    if (model == null) {
      System.out.println("null model");
    }
    model.setCanvas(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<AnimatorModelImpl> declareShape(String name, String type) {
    Shape s = null;
    if (type.equals("rectangle")) {
      s = new Rectangle(name, type, 0, 0, 0, 0, new Color(0, 0, 0));
    } else if (type.equals("ellipse")) {
      s = new Ellipse(name, type, 0, 0, 0, 0, new Color(0, 0, 0));
    }

    model.addShape(s);

    return this;

  }

  @Override
  public AnimationBuilder<AnimatorModelImpl> addMotion(String name, int t1, int x1, int y1, int w1,
      int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
      int b2) {
    Motion resize = new Resize(name, w1, w2, h1, h2, t1, t2);
    Motion move = new Move(name, x1, x2, y1, y2, t1, t2);
    Motion changeCol = new ChangeColor(name, r1, g1, b1, r2, g2, b2, t1, t2);

    for (Shape s : model.getShapeList()) {
      if (s.getName().equals(name)) {
        if (s.getMotionHistory().size() == 0) {
          s.transform(move);
          s.transform(resize);
          s.transform(changeCol);
        }
      }
    }
    model.addMotion(resize);
    model.addMotion(move);
    model.addMotion(changeCol);

    return this;
  }
}
