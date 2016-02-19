package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.CameraFeeds;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchToCameraOne extends Command
{

	private CameraFeeds camerafeeds = Robot.camerafeeds;
	/**
	 * Boolean to assign false to cameraSwitchButtStatus
	 */
	private boolean cameraSwitchButtStatus = false;

	public SwitchToCameraOne()
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
	protected void execute()
	{
		camerafeeds.switchToCameraOne();
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
