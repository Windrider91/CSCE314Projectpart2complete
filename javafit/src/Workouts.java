import java.util.ArrayList; // We choose ArrayList over Vector because...?


public class Workouts {

  private final ArrayList<Workout> workoutList = new ArrayList<Workout>();
  
  //This is where the workout class was
  
  public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
  {
    Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
    workoutList.add(newWorkout);
  }
  
  public final void addWorkout(Workout workout)
  {
    workoutList.add(workout);
  }
  
  public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasPrimaryMuscle(m)) {
        retval.addWorkout(w);
      }
      else if (includeSecondary && w.hasSecondaryMuscle(m)) { // Why did I put the includeSecondary first?
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary)
  {
	  Workouts retval = new Workouts();
	  for(Workout w : workoutList) {
		  if(w.hasPrimaryMuscle(m))
		  {
			  retval.addWorkout(w);
		  }
		  else if(includeSecondary && w.hasSecondaryMuscle(m))
		  {
			  retval.addWorkout(w);
		  }
	  }
	  return retval;
  }
  
  public final Workouts getWorkoutsByEquipment(Config.Equipment e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final ArrayList<String> getNames()
  {
    ArrayList<String> retval = new ArrayList<String>();
    for(Workout w : workoutList) {
      retval.add(w.getName());
    }
    return retval;
  }
  
  public final ArrayList<String> getEquipment()
  {
	  ArrayList<String> retval = new ArrayList<String>();
	  for(Workout w : workoutList) {
		  retval.add(w.getEquipment());
	  }
	  return retval;
  }
  
  public final int size()
  {
	  return workoutList.size();
  }
  
  public final Workout getWorkout(int index)
  {
	  return workoutList.get(index);
  }
  
  public final int findWorkoutByName(String name)
  {
	  for(int i = 0; i < workoutList.size(); i++)
	  {
		  if(workoutList.get(i).getName().matches(name))
			  return i;
	  }
	  
	  //If the workout is never found, return -1
	  return -1;
  }
  
  public final String getWorkoutEquipment(int index)
  {
	  return workoutList.get(index).getEquipment();
  }
 
  public final ArrayList<String[]> getFullInformation()
  {
    ArrayList<String[]> retval = new ArrayList<String[]>();
    for(Workout w : workoutList) {
      String[] info = new String[6];
      info[0] = w.getName();
      info[1] = w.getEquipment();
      info[2] = w.getPrimaryMuscle();
      info[3] = w.getSecondaryMuscle();
      info[4] = w.getDesc();
      info[5] = w.getReminders();
      retval.add(info);
    }
    return retval; 
  }
}