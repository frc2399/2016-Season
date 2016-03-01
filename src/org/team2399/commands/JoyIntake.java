package org.team2399.commands;

import org.team2399.OI;
import org.team2399.Robot;
import org.team2399.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyIntake extends Command
{
	/**
	 * speed: speed of the intake
	 * intake: new instance of the intake subsystem
	 */
	double speed;
	private Intake intake = Robot.intake;

	/**
	 * JoyIntake constructor
	 * Sets the intake speed
	 * requires the intake subsystem
	 * @param speed: saves the value of local variable into the field
	 */
	public JoyIntake(double speed)
	{
		this.speed = speed;
		requires(intake);
	}
	
	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Sets the intake speed to the throttle value on the intake joystick
	 * prints out the intake speed
	 */
	protected void execute()
	{
		intake.setIntakeSpeed(speed * OI.getIntakeThrottle());
		System.out.println(speed * OI.getIntakeThrottle());
	}

	// Make this return true when this Command no longer needs to run execute()
	// TODO: Ask why this returns true rather than false
	protected boolean isFinished()
	{
		return intake.isWhisperSwitchTriggered(); 
		/*TODO this currently returns true when the switch is triggered
		 * but if we try and outtake the ball, the switch is no longer triggered and stops moving
		 * when we try to outtake the ball, the switch starts triggered, but when it stops being triggered the intake stops moving
		 * we need to make it so that we can outtake the ball without the intake stopping
		*/
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
