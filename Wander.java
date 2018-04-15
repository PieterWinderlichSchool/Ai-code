import java.util.*;
public class Wander extends Routine{
private static Random random = new Random();
private final MainScene mainScene;
private MoveTo moveTo;

@Override
public void start(){
  super.start();
  this.moveTo.start();
}
public void reset(){
  this.moveTo = new MoveTo(random.nextInt(mainScene.getWidth()) , random.nextInt(mainScene.getHeight()));
}
public Wander(MainScene mainScene){
  super();
  this.mainScene = mainScene;
  this.moveTo = new MoveTo(random.nextInt(mainScene.getWidth()) , random.nextInt(mainScene.getHeight()));
}
@Override
public void act(Enemy enemy, MainScene mainScene){
  if (!moveTo.isRunning()){
    return;
  }
  this.moveTo.act(enemy , mainScene);
  if(this.moveTo.isSucces()){
    succeed();
  }else if(this.moveTo.isFailure()){
    fail();
  }
}

}
