package cs5004.animator;

import cs5004.animator.controller.AnimatorControllerImpl;
import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.AnimatorView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.ViewFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 * This is an EasyAnimator. It takes user input as command-line arguments to
 * read files and produce animation. It makes the controller to run the
 * animation.
 * 
 * @author Zuo
 *
 */
public final class EasyAnimator {

  /**
   * This main() method is the entry point for the program.
   * 
   * @param args Each pair of arguments may appear in any order. The options for
   *             the view name are "text", "visual", "playback and "svg".
   *             Providing an input file (the -in pair) and a view (the -view
   *             pair) are mandatory. If the output set is not specified and the
   *             view needs it, the default should be System.out. If the speed is
   *             not specified and the view needs it, the default is 1 tick per
   *             second. If the command-line arguments are invalid, the program
   *             should show an error message
   */
  public static void main(String[] args) {
    String inFileName = "";
    String outFileName = "";
    String viewType = "";
    double speed = 1;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        inFileName = args[i + 1];
      } else if (args[i].equals("-view")) {
        viewType = args[i + 1];
      } else if (args[i].equals("-out")) {
        outFileName = args[i + 1];
      } else if (args[i].equals("-speed")) {
        speed = (double) Integer.valueOf(args[i + 1]);
      }
    }

    // check inFile and view
    if (inFileName.equals("") || viewType.equals("")) {
      JOptionPane.showMessageDialog(null, "inputFile and viewType are mandatory.");
    }

    // Create a readable, read file, build the model
    InputStream inFile = null;
    try {
      inFile = new FileInputStream(inFileName);
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "No such file.");
    }
    InputStreamReader readable = new InputStreamReader(inFile);
    AnimationBuilderImpl builder = new AnimationBuilderImpl();
    new AnimationReader();
    AnimatorModelImpl model = AnimationReader.parseFile(readable, builder);

    AnimatorView view = ViewFactory.produceView(viewType);

    if (viewType.equals("svg")) {
      if (!outFileName.equals("")) {
        try {
          FileWriter outfile = new FileWriter(outFileName);
          new AnimatorControllerImpl(new SVGView(), model, outfile, speed).animate();
          outfile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null, "FileWriter Error.");
        }
      }
    }

    new AnimatorControllerImpl(view, model, System.out, speed).animate();

  }
}
