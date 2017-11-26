import objectdraw.*;
public class ShapeSizer extends WindowController {
private static final double INITIAL_SIZE = 100;
private Resizable shape;
private RandomIntGenerator shapeGen;
public void begin() {
shapeGen = new RandomIntGenerator (1, 2);
}
public void onMousePress (Location point) {
int shapeType = shapeGen.nextValue ();
if (shapeType == 1) {
shape = new Square (point, INITIAL_SIZE, canvas);
} else {
shape = new Circle (point, INITIAL_SIZE, canvas);
}
}
public void onMouseRelease (Location point) {
shape.resize (INITIAL_SIZE/2);
}
}