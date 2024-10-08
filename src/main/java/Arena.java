import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    public Arena(int width, int height,Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
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
    public void draw(Screen screen) {
        hero.draw(screen);
    }
    public boolean canHeroMove(Position position) {
        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) {
            return false;
        }
        else return true;
    }
    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        } else {
            System.out.println("Can't move hero");
        }
    }

}

