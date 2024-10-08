import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#111111"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");  // Draw hero as '@'
    }
    public Position move(){
        return new Position(position.getX()+1, position.getY());
    }
}
