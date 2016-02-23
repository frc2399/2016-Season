package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;
import org.team2399.subsystems.Pitch;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PitchAnglePConstantAdjustment extends Command {

	private Pitch pitch = Robot.pitch;
	private boolean isIncrementing;
	
    public PitchAnglePConstantAdjustment(boolean isIncrementing) {
    	requires(pitch);
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
    		pitch.incrementAnglePConstant();
    	}
    	else
    	{
    		pitch.decrementAnglePConstant();
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
