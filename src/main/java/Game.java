import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Game {
    private Arena arena;
    private Screen screen;
    private int x = 10;
    private int y = 10;
    private int width = 100;
    private int height = 100;
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(115, 115);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            Hero hero=new Hero(x,y);
            arena = new Arena(width,height,hero);
            this.screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void draw (){
            try{
            screen.clear();
            arena.draw(screen);
            screen.refresh();}
            catch (IOException e){
                e.printStackTrace();
            }
        }
    public void run(){
        try{
            while(true){
                draw();
                KeyStroke key = screen.readInput();
                processKey(key);}}
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp:
                arena.moveHero(arena.getHero().moveUp());
                break;
            case ArrowDown:
                arena.moveHero(arena.getHero().moveDown());
                break;
            case ArrowLeft:
                arena.moveHero(arena.getHero().moveLeft());
                break;
            case ArrowRight:
                arena.moveHero(arena.getHero().moveRight());
                break;
            case Character:
                if (key.getCharacter() == 'q') {
                    closeScreen();
                    return;
                }
                break;
            case EOF:
                closeScreen();
                return;
            default:
                break;
        }
    }
    public void closeScreen() {
        try {
            screen.stopScreen(); // Stop the screen
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0); // Exit the application
    }

}
