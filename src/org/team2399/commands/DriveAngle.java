package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAngle extends Command
{

	/**
	 * drivetrain: new instance of drivetrain subsystem desiredAngle: angle you
	 * want to be at
	 */
	private Drivetrain driveTrain = Robot.drivetrain;
	private double desiredAngle;

	/**
	 * DriveAngle constructor sets desiredAngle to inputted value requires the
	 * drivetrain subsystem, and this particular command can be interrupted by
	 * other commands
	 * 
	 * @param desiredAngle
	 *            :saves the value of desired angle in the field
	 */
	public DriveAngle(double desiredAngle)
	{
		this.desiredAngle = desiredAngle;
		requires(driveTrain);
		setInterruptible(true);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	/**
	 * Called just before this Command runs the first time Sets desired angle
	 */
	protected void initialize()
	{
		driveTrain.setDesiredAngle(desiredAngle);
	}

	/**
	 * Called repeatedly when this Command is scheduled to run Move to desired
	 * angle
	 */
	protected void execute()
	{
		driveTrain.moveToAngle();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
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
