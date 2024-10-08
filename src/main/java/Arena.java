import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Wall> walls;
    private List<Coin> Coins;
    private List<Monster> Monsters;
    private int width;
    private int height;
    private Hero hero;
    public Arena(int width, int height,Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.walls = new ArrayList<>();
        this.Coins = new ArrayList<>();
        this.Monsters = new ArrayList<>();
        createCoins();
        createWalls();
        createMonsters();
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Hero getHero() {
        return hero;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        }
        return Coins;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        }
        return Monsters;
    }
    private List<Wall> createWalls() {
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        hero.draw(graphics);
        for (Coin coin : Coins) {
            coin.draw(graphics);
        }
        for(Monster monster : Monsters) {
            monster.draw(graphics);
        }
    }
    public boolean canHeroMove(Position position) {
        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) {
            return false;
        }
        for (Wall wall : walls) { //equals nao funcionava perguntar ao stor
            if(wall.getPosition().getX() == position.getX() && wall.getPosition().getY() == position.getY()) {
                return false;
            }
        }
        return true;
    }
    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
            retriveCoins();
            moveMonsters();
            verifyMonsterCollision();
        } else {
            System.out.println("Can't move hero");
        }
    }
    public void retriveCoins(){//perguntar se ist ta bem
        Coins.removeIf(coin -> hero.getPosition().getX() == coin.getPosition().getX() && hero.getPosition().getY() == coin.getPosition().getY());
    }
    public void moveMonsters() {
        for (Monster monster : Monsters) {
            Position position = monster.move();
            monster.setPosition(position);
        }

    }
    public void verifyMonsterCollision() {
        for (Monster monster : Monsters) {
            if(hero.getPosition().getX() == monster.getPosition().getX() && hero.getPosition().getY() == monster.getPosition().getY()){
                System.out.println("you died dingus.");
                System.exit(0);
            }
        }
    }
}




