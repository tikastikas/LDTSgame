import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;

public abstract class Element {
    protected Position position;
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public abstract void draw(TextGraphics g);
}
