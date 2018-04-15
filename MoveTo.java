public class MoveTo extends Routine{
  final protected int destX;
  final protected int destY;

//de constructor
  public MoveTo(int destX , int destY){
    super();
    this.destX = destX;
    this.destY = destY;
  }
  public void reset(){
    start();
  }

  @Override
  public void act(Enemy enemy, MainScene mainScene){
//als Routine aan het runnen is
    if(isRunning()){
      //als de enemy dood is
      if(!enemy.isAlive()){
        fail();
        return;
      }
      if (!isEnemyAtDestination(enemy)){
        moveEnemy(enemy);
      }
    }
  }
  //De beweging
  private void moveEnemy(Enemy enemy){
    if(destY != enemy.getY()){
      if(destY > enemy.getY()){
        enemy.setY(enemy.getY() + 1);
      } else{
        enemy.setY(enemy.getY() - 1);
      }

    }
    if(destX != enemy.getX()){
      if(destX > enemy.getX()){
        enemy.setX(enemy.getX() + 1);
      }else{
        enemy.setY(enemy.getY() - 1);
      }
    }
    if (isEnemyAtDestination(enemy)){
      succeed();
    }
  }
  //een getter om te kijken of de enemy is waar hij hoort te zijn.
  private boolean isEnemyAtDestination(Enemy enemy){
    return destX == enemy.getX() && destY == enemy.getY();
  }
}
