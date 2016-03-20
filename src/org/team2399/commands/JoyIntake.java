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
		
	/*	if (intake.isWhiskerSwitchTriggered() == true) //was inverted, fix before match 81
		{
			intake.setIntakeSpeed(speed * OI.getIntakeThrottle());
			System.out.println(speed * OI.getIntakeThrottle());
		}
			else if ((OI.isOutputButtPressed() == true) && (intake.isWhiskerSwitchTriggered() == false)){
				intake.setIntakeSpeed(-1);
			}
			else {
				intake.setIntakeSpeed(0);
			}
			*/
		if (speed > 0 && intake.isWhiskerSwitchTriggered() == false){ //goingn in
			intake.setIntakeSpeed(speed);
		}
			else if (speed < 0){ //outtake
			intake.setIntakeSpeed(speed);
		} 
			else {
			intake.setIntakeSpeed(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	// TODO: Ask why this returns true rather than false
	protected boolean isFinished()
	{
		/*
		 * If the speed is positive (see preset speeds in RobotMap), finish the
		 * command. Otherwise, return false.
		 */
	/*	if (Math.abs(speed) > 0 || speed < 0)
		{
			return intake.isWhiskerSwitchTriggered();
		}
		*/
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
