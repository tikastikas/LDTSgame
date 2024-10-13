package game.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.utils.Position;

public class Hero extends Element {
    public Hero(int startX, int startY){
        super(startX, startY);
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));  // Yellow color
        graphics.enableModifiers(SGR.BOLD);  // Bold styling
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");  // Draw hero as '@'
    }
    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }
    public Position knockback(){
        return new Position(position.getX()-1, position.getY());
    }
}
