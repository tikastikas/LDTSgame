import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.elements.Element;
import game.elements.Hero;
import game.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    private Hero hero;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        hero = new Hero(5,5);
        graphics = Mockito.mock(TextGraphics.class);
    }
    @Test
    public void testDrawHero() {
        hero.draw(graphics);
        Mockito.verify(graphics).setForegroundColor(Mockito.any());
        Mockito.verify(graphics).enableModifiers(Mockito.any());
        Mockito.verify(graphics).putString(new TerminalPosition(5, 5), "X");
    }
    @Test
    public void testHeromove() {
        Position newPosition = hero.moveUp();
        assertEquals(5, newPosition.getX());
        assertEquals(4, newPosition.getY());
        newPosition = hero.moveDown();
        assertEquals(5, newPosition.getX());
        assertEquals(6, newPosition.getY());
        newPosition = hero.moveLeft();
        assertEquals(4, newPosition.getX());
        assertEquals(5, newPosition.getY());
        newPosition = hero.moveRight();
        assertEquals(6, newPosition.getX());
        assertEquals(5, newPosition.getY());
    }
}
