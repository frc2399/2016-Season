package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Spoon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
// Command that moves the arm
public class MoveSpoon extends Command
{
	private Spoon spoon = Robot.spoon;

	// arm constructor
	public MoveSpoon()
	{
		requires(spoon);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
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
