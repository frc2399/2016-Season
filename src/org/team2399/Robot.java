package org.team2399;


import org.team2399.commands.*;
import org.team2399.subsystems.Drivetrain;
import org.team2399.subsystems.Intake;
import org.team2399.subsystems.Pitch;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	/**
	 * Creates instances of subsystems for use in commands
	 */
	public static Intake intake = new Intake(RobotMap.INTAKE_ENCODER_COUNT);
	public static Drivetrain drivetrain = new Drivetrain(
			RobotMap.DRIVETRAIN_ENCODER_COUNT);
	public static Pitch pitch = new Pitch();
	
	/**
	 * Creates instance of OI for use in commands
	 */
	public static OI oi = new OI();

	/**
	 * Sets the autonomous command
	 */
	Command autonForward;
	Command defenseCross;
	Command positionAndGoal;

	Command autoCommand;
	CommandGroup finalAuton;

	SendableChooser driveForward;
	SendableChooser defenseChooser;
	SendableChooser positionChooser;

	/**
	 * Creates the camera
	 */

//	public static CameraServer camServer0;

//	public static CameraServer camServer1;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
/*		driveForward = new SendableChooser();
		defenseChooser = new SendableChooser();
		positionChooser = new SendableChooser();
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Drive Forward", driveForward);
		SmartDashboard.putData("Defense Cross", defenseChooser);
		SmartDashboard.putData("Position and Goal", positionChooser);

		driveForward.addObject("Drive to defense", new AutoDriveForward());

		defenseChooser.addObject("Cross Lowbar Only", new AutoCrossLowBar());
		defenseChooser.addObject("Cross Moat", new AutoDefenseCrossMoat());
		defenseChooser.addObject("Cross Portcullis Only",
				new AutoDefenseCrossPortcullis());
		defenseChooser.addObject("Cross RockWall",
				new AutoDefenseCrossRockWall());
		defenseChooser.addObject("Cross Lowbar and Shoot", new AutoLowBarClosestGoal());
		defenseChooser.addObject("Cross Ramparts Only", new AutoCrossRamparts());
		defenseChooser.addObject("Cross Cheval de Fris Only", new AutoCrossChevalDeFrise());
		defenseChooser.addObject("Cross Rough Terrain Only", new AutoCrossRoughTerrain());
		defenseChooser.addObject("No Defense", new AutoStopRobot());
		

		positionChooser.addObject("Position 5 Near Goal",
				new AutoShootFromPositionFiveNearGoal());
		positionChooser.addObject("Position 4 Far Goal",
				new AutoShootFromPositionFourFarGoal());
		positionChooser.addObject("Position 4 Near Goal",
				new AutoShootFromPositionFourNearGoal());
		positionChooser.addObject("Position 3 Left Goal",
				new AutoShootFromPositionThreeLeftGoal());
		positionChooser.addObject("Position 3 Right Goal",
				new AutoShootFromPositionThreeRightGoal());
		positionChooser.addObject("Position 2 Far Goal",
				new AutoShootFromPositionTwoFarGoal());
		positionChooser.addObject("Position 2 Near Goal",
				new AutoShootFromPositionTwoNearGoal());
		positionChooser.addObject("Stop", new AutoStopRobot());

		/**
		 * Cameras are named for when roborio is connected
		 * openCamera: command to open the camera
		 * startCapture: command to start streaming the data
		 * setQuality: command to set the quality of the data
		 * If the computer runs into a problem, it'll return the error
		 */

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit()
	{

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit()
	{
	//	autonForward = (Command) driveForward.getSelected();
		//defenseCross = (Command) defenseChooser.getSelected();
		//positionAndGoal = (Command) positionChooser.getSelected();

		autoCommand = new DriveForwardAuton();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)

	//	finalAuton.addSequential(autonForward, 2);
		//finalAuton.addSequential(defenseCross, 7);
	///	finalAuton.addSequential(positionAndGoal, 6);

		/*if (autonForward != null)
		{
			finalAuton.start();
		}
*/
		autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonForward != null)
		{
			finalAuton.cancel();
		}
		
	//	camServer0.startAutomaticCapture();

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
