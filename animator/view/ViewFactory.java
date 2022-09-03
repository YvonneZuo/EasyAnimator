package cs5004.animator.view;

/**
 * This is a view factory that produce views.
 * 
 * @author Zuo
 *
 */
public class ViewFactory {
  /**
   * Produces view given the viewType.
   * 
   * @param viewType the type of the view
   * @return a view
   */
  public static AnimatorView produceView(String viewType) {
    AnimatorView view;

    if (viewType.equals("text")) {
      view = new TextView();
    } else if (viewType.equals("svg")) {
      view = new SVGView();
    } else if (viewType.equals("visual")) {
      view = new VisualView();
    } else {
      view = new PlayBackView();
    }
    return view;
  }
}
