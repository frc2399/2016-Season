package org.team2399.commands;

import org.team2399.OI;
import org.team2399.Robot;
import org.team2399.subsystems.Pitch;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyPitch extends Command
{

	/**
	 * Creates new instance of pitch subsystem
	 */
	private Pitch pitch = Robot.pitch;

	/**
	 * JoyPitch constructor
	 * needs pitch subsystem
	 * allows command to be interrupted
	 */
	public JoyPitch()
	{
		requires(pitch);
		setInterruptible(true);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Sets pitch speed to value from joystick
	 */
	protected void execute()
	{
		pitch.setPitchSpeed(-OI.getIntakeY());
		System.out.println(-OI.getIntakeY());
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
