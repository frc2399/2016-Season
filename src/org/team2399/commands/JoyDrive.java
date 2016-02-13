package org.team2399.commands;

import org.team2399.OI;
import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyDrive extends Command
{

	/**
	 * drivetrain: new instance of the drivetrain subsystem
	 */
	private Drivetrain drivetrain = Robot.drivetrain;

	/**
	 * needs the drivetrian subsystem
	 */
	public JoyDrive()
	{
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
	}

	/**
	 * Called repeatedly when this Command is scheduled to run(non-Javadoc) Sets
	 * speed for left and right based on joystick values
	 */
	protected void execute()
	{
		drivetrain.setLeftSpeed(OI.getLeftY());
		drivetrain.setRightSpeed(OI.getRightY());
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
