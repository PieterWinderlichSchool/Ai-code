public abstract class Routine{  //de class. abstract classes kunnen niet worden geInstansieerd maar kunnen wel subclasses zijn.
//enum is een datatype voor Preset constants.
public enum RoutineState{
  //De routine is een succes en heeft gedaan wat het moest doen(leer ervan Octo). Bijv. als de routine nog steeds in de "Move to position", zal het een succes zijn als de actie voltooid is
  Succes,
  //Als de beweging van de enemy is onderbroken(Loopt tegen muur of is gedood) en het heeft de bestemde locatie niet bereikt
  Failure,
  //de Routine is nu bezig en zal volgende tick(update) een actie uitvoeren.Ofwel ,de Routine is verantwoordelijk om de enemy naar een bepaalde locatie te brengen en de enemy is in bewegin ononderbroken
  Running
}
protected RoutineState state;
//Hier komt Abstract goed van pas.
protected Routine(){}
public void start(){
  System.out.println("Routine start");
  this.state = RoutineState.Running;
  }

  public abstract void reset();
  //Vertel voor wie het bedoeld is en de Scene waar hij rekening mee moet houden.
  public abstract void act(Enemy enemy, MainScene mainScene);

  protected void succeed(){
    this.state = RoutineState.Succes;
  }

  protected void fail(){
    this.state = RoutineState.Failure;
  }
  //this.state = RoutineState.Running is de default en is al eerder gedeclareerd als de "Start" Method.

  public boolean isSucces(){
    return state.equals(RoutineState.Succes);
  }
  public boolean isFailure(){
    return state.equals(RoutineState.Failure);
  }
  public boolean isRunning(){
    return state.equals(RoutineState.Running);
  }
  public RoutineState getState(){
    return state;
  }








}
