package game.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.utils.Position;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#111111"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");  // Draw hero as '@'
    }
    public Position move(){
        Random rand = new Random();
        int nextx=position.getX();
        int nexty=position.getY();
        int escolha=rand.nextInt(5);
        switch(escolha){
            case 0:nextx=nextx+1;break;
            case 1:nextx=nextx-1;break;
            case 2:nexty=nexty+1;break;
            case 3:nexty=nexty-1;break;
            case 4:break;
        }
        return new Position(nextx,nexty);
    }
}
