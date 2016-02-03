package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command
{
	private Drivetrain driveTrain = Robot.drivetrain;
	private double desiredDistance;

	public DriveDistance(double desiredDistance)
	{
		this.desiredDistance = desiredDistance;
		requires(driveTrain);
		setInterruptible(true);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		driveTrain.setLeftDesiredDistance(desiredDistance);
		driveTrain.setRightDesiredDistance(desiredDistance);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		driveTrain.moveToLeftDistance();
		driveTrain.moveToRightDistance();
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
