# Simple Animator

## -- MODEL --
### Interfaces:
AnimatorModel: an interface for the model<br>
Motion: an interface for motions<br>
Shape: an interface for shapes <br>
### Abstract Classes:
AbstractMotion:<br> an abstract class for all motions, which includes common methods like `getMotionType()`, `getStartTime()`, etc.<br>
AbstarctShape:<br> an abtract class for all shapes, which includes common methods like `getName()`, `getColor()`, etc.<br>
### Concrete Classes:
AnimatorModelImpl:<br> a concrete class that implements the AnimatorModel interface. Implements all methods a model should have.<br>
ChangeColor:<br> extends AbstractMotion, represents the changeColor motion.<br>
Move:<br> extends AbstractMotion, represents the move motion.<br>
Resize:<br> extends AbstractMotion, repsents the resize motion.<br>
Point2D:<br> represents the posrtion of a shape.<br>
Color:<br> represents the color of a shaple.<br>
Rectangle:<br> extends AbstractShape, represents a rectangle.<br>
Ellipse:<br>  extends AbstractShape, represents a ellipse.<br>

## -- VIEW --
### Interfaces:
AnimatorView:  an interface for the view.<br>
### Concrete Classes:
SVGView:<br> Represents the SVG view, implements the AnimatorView interface.<br>
TextView:<br> Represents the text view, implements the AnimatorView interface.<br>
VisualView:<br> Represents the visual view, implements the AnimatorView interface.<br>
PlayBackView:<br> Represents the visual view, implements the AnimatorView interface.<br>
AnimatorPanel:<br> Represents a panel, extends JPanel, and used by visual view and playback view.<br>
ViewFactory:<br> This is the view producer according to the view type.<br>

## -- CONTROLLER --
### Interfaces:
AnimatorController:<br> Represents the controller interface, has only one method `animate()`.<br>
### Concrete Classes:
AnimatorControllerImpl:<br> Represents the real controller, implements the AnimatorController interface. It controls the animator to run and stop.

## -- UTIL --
### Interfaces:
AnimationBuilder:<br> Interface for animationBuilders.<br>
### Concrete Classes:
AnimationBuilderImpl:<br> Represents an AnimationBuilder, impments the AntionmationBuilder interface.<br>
AnimationReader:<br>A helper to read animation data and construct an animation from it.
