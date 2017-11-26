public class Square implements Resizeable {

private FilledRect box;

public Square (Location point, double size, DrawingCanvas canvas) {

box = new FilledRect (point, size, size, canvas);

}

public void resize (double size) {

box.setWidth (size);

box.setHeight (size);

}

public boolean contains (Location point) {

return box.contains (point);

}

}

