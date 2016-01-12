package org.team2399.commands;

import org.team2399.OI;
import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyDrive extends Command {

	private Drivetrain drivetrain = Robot.drivetrain;
	private OI oi = Robot.oi;

	public JoyDrive() {
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivetrain.driveLeft(oi.getLeftY());
		drivetrain.driveRight(oi.getRightY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}