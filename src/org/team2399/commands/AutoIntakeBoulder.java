package org.team2399.commands;

import org.team2399.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoIntakeBoulder extends Command
{

	private Intake intake = new Intake();
	double desiredPosition;

	public AutoIntakeBoulder(double desiredPosition)
	{
		this.desiredPosition = desiredPosition;
		requires(intake);
		setInterruptible(true);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		intake.setDesiredPosition(desiredPosition);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		intake.moveToPosition();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
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
