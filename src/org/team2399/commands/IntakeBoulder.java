package org.team2399.commands;

import org.team2399.OI;
import org.team2399.Robot;
import org.team2399.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeBoulder extends Command
{
	double speed;
	private Intake intake = Robot.intake;
	private OI oi = Robot.oi;

	public IntakeBoulder(double speed)
	{
		this.speed = speed;
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		oi.getRightThrottle();
		oi.getLeftThrottle();
		intake.setIntakeSpeed(speed * oi.getRightThrottle());
		System.out.println(speed * oi.getRightThrottle());
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
