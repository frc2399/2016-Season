package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command
{
	/**
	 * drivetrain: Creates a new instance of the drivetrain subsystem
	 * desiredDistance: where you want to go
	 */
	private Drivetrain driveTrain = Robot.drivetrain;
	private double desiredDistance;
	private double time;
	private Timer timer = new Timer();;

	/**
	 * DriveDistance constructor
	 * sets the desired distance
	 * needs the drivetrain subsystem
	 * allows command to be interrupted by other commands
	 * @param desiredDistance: saves the value into the field
	 */
	public DriveDistance(double desiredDistance, double time)
	{
		this.desiredDistance = desiredDistance;
		requires(driveTrain);
		this.time = time;
		setInterruptible(true);
		
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	/**
	 * Called just before this Command runs the first time
	 * Sets the desired distance (right and left)
	 */
	protected void initialize()
	{
		driveTrain.setLeftDesiredDistance(desiredDistance);
		driveTrain.setRightDesiredDistance(desiredDistance);
		timer.start();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Moves drivetrain to desired distance
	 */
	protected void execute()
	{
		
		//System.out.println("This is how long it should be running for: " + time);
		//System.out.println("This is the current time it has been running for: " + timer.get());
		
	//	if (time <= timer.get()){
		driveTrain.moveToLeftDistance();
		driveTrain.moveToRightDistance();
		//} else {
		//	driveTrain.setLeftSpeed(0);
			//driveTrain.setRightSpeed(0);
		//}
	}

	/**
	 * @return: checks if robot is within acceptable margin of
	 * error for distance and if so, stops it
	 */
	protected boolean isFinished()
	{
		
		/*if ((time <= timer.get())){
			//return false;
		} else {
			return false;
		}
		*/
		return driveTrain.isDriveDistanceFinished();
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
