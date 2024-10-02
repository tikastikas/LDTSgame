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
    private Screen screen;
    private int x = 10;
    private int y = 10;
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

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
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();}
            catch (IOException e){
                e.printStackTrace();
            }
        }
    public void run(){
        try{
            while(true){draw();
                KeyStroke key = screen.readInput();
                processKey(key);}}
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp:
                y--; // Move up
                break;
            case ArrowDown:
                y++; // Move down
                break;
            case ArrowLeft:
                x--; // Move left
                break;
            case ArrowRight:
                x++; // Move right
                break;
            case Character:
                if (key.getCharacter() == 'q') {
                    closeScreen(); // Close if 'q' is pressed
                    return;
                }
                break;
            case EOF:
                closeScreen(); // Close on EOF
                return;
            default:
                break;
        }
    }
    private void closeScreen() {
        try {
            screen.stopScreen(); // Stop the screen
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0); // Exit the application
    }

}
