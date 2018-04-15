public class IsEnemyInRange extends Routine{



    public IsEnemyInRange() {}

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Enemy enemy, MainScene mainScene) {
        // find player in range
        for (Enemy enemy : mainScene.getEnemys()) {
            if (!Enemy.getName().equals(enemy)) {
                if (isInRange(enemy, enemy)) {
                    succeed();
                    break;
                }
            }
        }
        fail();
    }

    private boolean isInRange(Enemy enemy, Enemy enemy) {
        return (Math.abs(Enemy.getX() - enemy.getX()) <= enemy.getRange()
                && Math.abs(enemy.getY() - enemy.getY()) <= enemy.getRange());
    }
}
