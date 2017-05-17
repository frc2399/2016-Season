package org.team2399.commands;

import org.team2399.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rumble extends Command {

	private Timer timer;
    public Rumble() {
		timer = new Timer();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int i = (int) timer.get();
    	if(i == 0)
    	{
    	OI.rumble(0.5, 0.0);
    	}
    	else if(i == 1)
    	{
    		OI.rumble(0, 0.5);
    	}
    	else if(i == 2)
    	{
        	OI.rumble(0.5, 0.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	OI.rumble(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
