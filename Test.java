public class Test{
public static void main(String[] args) {
  MainScene mainScene = new MainScene(10, 10);

  Enemy enemy = new Enemy("MyEnemy" , 5 , 5 , 10 , 1 , 2);
  mainScene.addEnemy(enemy);

  
  Routine moveTo = new MoveTo(7,9);

  Routine routine = new Repeat((new Wander(mainScene)));
        enemy.setRoutine(routine);


  for (int i = 0 ; i < 5 ; i++){
    enemy.update();
    System.out.println(enemy);
  }
}

}
