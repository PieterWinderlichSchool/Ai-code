public class Enemy{
  final String name;

      int x;

      int y;

      int range;

      int damage;

      int health;

      boolean alive = true;



      MainScene mainScene;
      MoveTo moveTo = new MoveTo(5,9);
      Routine routine;


      public void start(){

      }


      //constructor
      public Enemy(String name, int x, int y, int health, int damage, int range) {

          this.name = name;

          this.x = x;

          this.y = y;

          this.health = health;

          this.damage = damage;

          this.range = range;

      }



      public void update() {
        if (moveTo.getState() == null) {
          moveTo.start();
        // placeholder for each turn or tick
          moveTo.act(this , mainScene);
      }
    }
    //getters en setters
      public int getX(){
        return x;
      }
      public int getY(){
        return y;
      }
      public void setY(int y){
        y = y;
      }
      public void setX(int x){
        x = x;
      }

      public boolean isAlive(){
        if ((health == 0)||(health <= 0))
        alive = false;
        return alive;
      }
      public void setMainScene(MainScene scene){
        this.mainScene = mainScene;

      }
      public void setRoutine(Routine routine ){
        this.routine = routine;


      }
      @Override
    public String toString() {
        return "Enemy{" +
                "name=" + name +
                ", x=" + x +
                ", y=" + y +
                ", health=" + health +
                ", range=" + range +
                ", damage=" + damage +
                '}';
    }


      /* ... */

      /* getters and setters and toString() */

      /* ... */

  }
