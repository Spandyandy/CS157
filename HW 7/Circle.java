import objectdraw.*;
public class Circle implements Resizeable {

private FilledOval round;

public Circle (Location point, double size, DrawingCanvas canvas) {

round = new FilledOval (point, size, size, canvas);

}

public void resize (double size) {

round.setWidth (size);

round.setHeight (size);

}

public boolean contains (Location point) {

return round.contains (point);

}

}
