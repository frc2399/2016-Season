package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.RobotMap;
import org.team2399.subsystems.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoIntakeBoulder extends Command
{

	/**
	 * Fields
	 * intake: new instance of the intake subsystem
	 * desiredTime: how long you want the intake to run
	 * desiredSpeed: how fast you want the intake to run
	 * timer: timer for how long you want the intake to run
	 */
	double desiredTime;
	double desiredSpeed;

	private Timer timer = new Timer();

	/**
	 * takes local variables of desiredTime and desiredSpeed and assigns them to
	 * field
	 * @param desiredTime: how long you want the intake to run for
	 * @param desiredSpeed: how fast you want the intake to run
	 */
	public AutoIntakeBoulder(double desiredTime, double desiredSpeed)
	{
		this.desiredTime = desiredTime;
		this.desiredSpeed = desiredSpeed;
		requires(Robot.intake);
		setInterruptible(true);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	/**
	 * Called just before this Command runs the first time
	 * Starts the timer
	 */
	protected void initialize()
	{
		timer.start();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Set intake to desired speed
	 */
	protected void execute()
	{
		Robot.intake.setIntakeSpeed(desiredSpeed);
	}

	/**
	 * If time >= desired time, stop running the command
	 * If time < desired time, keep running the command
	 * If neither, stop running the command
	 */
	protected boolean isFinished()
	{
		// TODO: What should this return?
		// return false;

		if (timer.get() >= desiredTime
				|| (desiredSpeed > 0 && Robot.intake.isWhiskerSwitchTriggered()))
		{
			return true;
		} else
		{
			return false;
		}

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
