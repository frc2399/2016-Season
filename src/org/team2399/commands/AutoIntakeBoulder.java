package org.team2399.commands;

import org.team2399.RobotMap;
import org.team2399.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoIntakeBoulder extends Command
{

	/**
	 * Take in encoder count
	 */
	private Intake intake = new Intake(RobotMap.INTAKE_ENCODER_COUNT);
	double desiredPosition;

	/**
	 * takes local variable of desired position and saves value in the field
	 * 
	 * @param desiredPosition
	 *            :takes the value of the local variable and saves in the field
	 */
	public AutoIntakeBoulder(double desiredPosition)
	{
		this.desiredPosition = desiredPosition;
		requires(intake);
		setInterruptible(true);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	/**
	 * Called just before this Command runs the first time Sets desired position
	 */
	protected void initialize()
	{
		intake.setTopDesiredPosition(desiredPosition);
		intake.setBottomDesiredPosition(desiredPosition);
	}

	/**
	 * Called repeatedly when this Command is scheduled to run Moves to desired
	 * position
	 */
	protected void execute()
	{
		intake.moveToTopPosition();
		intake.moveToBottomPosition();
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
