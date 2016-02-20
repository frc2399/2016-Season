package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.CameraFeeds;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchToCameraZero extends Command
{

	private CameraFeeds camerafeeds = Robot.camerafeeds;
	/**
	 * Boolean to assign false to cameraSwitchButtStatus
	 */
	private boolean cameraSwitchButtStatus = false;

	public SwitchToCameraZero()
	{
		requires(camerafeeds);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run

	/**
	 * If cameraSwitchButtStatus is equivalent to false, then start to capture
	 * from cameraOne, and stop capturing from cameraZero
	 * cameraSwitchButtStatus is assigned true after running the false, so
	 * when the button is pressed again it will run the true loop
	 * If cameraSwitchButtStatus is equivalent to true, the start to capture
	 * from cameraZero, and stop capture from cameraOne
	 * cameraSwtichButtSatus is assigned false after running true, so when the
	 * button is pressed again it will run the false loop
	 */
	protected void execute()
	{

		camerafeeds.switchToCameraZero();

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
