import java.util.*;

public class MainScene {



    final int width;

    final int height;



    private List<Enemy> enemys = new ArrayList<Enemy>();



    public MainScene(int width, int height) {

        this.width = width;

        this.height = height;

    }



    public int getWidth() {

        return width;

    }



    public int getHeight() {

        return height;

    }



    public void addEnemy(Enemy enemy) {

        if (isTileWalkable(enemy.getX(), enemy.getY())) {

            enemys.add(enemy);

            enemy.setMainScene(this);

        }

    }



    public boolean isTileWalkable(int x, int y) {

        for (Enemy enemy : enemys) {

            if (enemy.getX() == x && enemy.getY() == y) {

                return false;

            }

        }

        return true;

    }



    public List<Enemy> getEnemys() {

        return enemys;

    }

}
