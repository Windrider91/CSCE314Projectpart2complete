import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.*;

// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;
  private JButton upperButton = new JButton("Upper Body Workout");
  private JButton lowerButton = new JButton("Lower Body Workout");
  private JButton wholeButton = new JButton("Whole Body Workout");
  
  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
    // Code goes here.
	  this.workouts = workouts;
	  this.muscleGroups = muscleGroups;
	  mainFrame.setSize(new Dimension(600, 400));
	  mainFrame.setLayout(new GridLayout(3, 1));
	  
	  launchHomeScreen();
	  
	  mainFrame.setVisible(true);
  }
  
  private void launchHomeScreen() {

	upperButton.addActionListener(new ButtonListener());
	lowerButton.addActionListener(new ButtonListener());
	wholeButton.addActionListener(new ButtonListener());
	
	mainFrame.add(upperButton);
	mainFrame.add(lowerButton);
	mainFrame.add(wholeButton); 
  }
  
  private class ButtonListener implements ActionListener
  {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String actionCommand = arg0.getActionCommand();
		
		if(actionCommand.equals("Upper Body Workout"))
		{
			if(!muscleGroups.containsKey(Config.MuscleGroup.UPPERBODY))
			{
				JOptionPane.showMessageDialog(null, "No upper body workouts found");
			}
			else
			{
				mainFrame.remove(upperButton);
				mainFrame.remove(lowerButton);
				mainFrame.remove(wholeButton);
				showWorkouts(muscleGroups.get(Config.MuscleGroup.UPPERBODY));
			}
		}
		if(actionCommand.equals("Lower Body Workout"))
		{
			if(!muscleGroups.containsKey(Config.MuscleGroup.LOWERBODY))
			{
				JOptionPane.showMessageDialog(null, "No upper lower workouts found");
			}
			else
			{
				mainFrame.remove(upperButton);
				mainFrame.remove(lowerButton);
				mainFrame.remove(wholeButton);
				showWorkouts(muscleGroups.get(Config.MuscleGroup.LOWERBODY));
			}
		}
		if(actionCommand.equals("Whole Body Workout"))
		{
			if(!muscleGroups.containsKey(Config.MuscleGroup.WHOLEBODY))
			{
				JOptionPane.showMessageDialog(null, "No whole body workouts found");
			}
			else
			{
				mainFrame.remove(upperButton);
				mainFrame.remove(lowerButton);
				mainFrame.remove(wholeButton);
				showWorkouts(muscleGroups.get(Config.MuscleGroup.WHOLEBODY));
			}
		}		
	}	  
  }
  
  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
    
  // Code goes here.
	  //muscleGroups.get(Config.MuscleGroup.UPPERBODY)
	  WorkoutsPanel testPanel = new WorkoutsPanel(muscles, this.workouts);
	  mainFrame.setLayout(new GridLayout(1, 1));
	  mainFrame.add(testPanel);
	  mainFrame.validate();
  }
}
