package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainAnglePConstantAdjustment extends Command {

	private Drivetrain drivetrain = Robot.drivetrain;
	private boolean isIncrementing;
	
    public DrivetrainAnglePConstantAdjustment(boolean isIncrementing) {
    	requires(drivetrain);
    	setInterruptible(true);
    	this.isIncrementing = isIncrementing;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isIncrementing == true)
    	{
    		drivetrain.incrementAnglePConstant();
    	}
    	else
    	{
    		drivetrain.decrementAnglePConstant();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
