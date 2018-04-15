import java.util.*;
public class Repeat extends Routine{
private final Routine routine;
private int times;
private int originalTimes;

public Repeat(Routine routine){
  super();
  this.routine = routine;
  this.times = -1; //oneindig
  this.originalTimes = times;
}
public Repeat(Routine routine, int times){
  super();
  if (times < 1){
    throw new RuntimeException("Can't repeat negative times.");
  }
  this.routine = routine;
  this.times = times;
  this.originalTimes = times;
}

@Override
public void start(){
  super.start();
  this.routine.start();
}
public void reset(){
  //reset de counter
  this.times = originalTimes;
}
@Override
public void act(Enemy enemy , MainScene mainScene){
  if (routine.isFailure()){
    fail();
  }else if (routine.isSucces()){
    if (times == 0){
      succeed();
      return;
    }
    if (times > 0 || times <= -1){
      times--;
      routine.reset();
      routine.start();
    }

  }
  if (routine.isRunning()){
    routine.act(enemy , mainScene);
  }
}
}
