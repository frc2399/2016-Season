package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAngle extends Command
{

	private Drivetrain driveTrain = Robot.drivetrain;
	private double desiredAngle;

	public DriveAngle(double desiredAngle)
	{
		this.desiredAngle = desiredAngle;
		requires(driveTrain);
		setInterruptible(true);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		driveTrain.setLeftDesiredAngle(desiredAngle);
		driveTrain.setRightDesiredAngle(desiredAngle);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		driveTrain.moveToLeftAngle();
		driveTrain.moveToRightAngle();
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
