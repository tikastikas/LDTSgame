import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.Direction;


public class Wall extends Element {
    public Wall(int x, int y) {
        super(x, y);
    }
    public void draw(TextGraphics g) {
        g.setForegroundColor(TextColor.Factory.fromString("#FF3333"));
        g.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
