package org.team2399.commands;

import org.team2399.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PositiveIntakeValues extends Command {

	double desiredSpeed;
    public PositiveIntakeValues(double desiredSpeed) {
    	
    	requires(Robot.intake);
    	
    	this.desiredSpeed = desiredSpeed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setPositiveIntakeValues(Math.abs(desiredSpeed));
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
