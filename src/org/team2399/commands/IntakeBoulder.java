package org.team2399.commands;

import org.team2399.RobotMap;
import org.team2399.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeBoulder extends Command
{

	/**
	 * Fields
	 * intake: new instance of the intake subsystem
	 * desiredTime: how long you want the intake to run
	 * desiredSpeed: how fast you want the intake to run
	 * timer: timer for how long you want the intake to run
	 */
	private Intake intake = new Intake(RobotMap.INTAKE_ENCODER_COUNT);
	// double desiredTime;
	double desiredSpeed;

	// private Timer timer = new Timer();

	/**
	 * takes local variables of desiredTime and desiredSpeed and assigns them to
	 * field
	 * @param desiredTime: how long you want the intake to run for
	 * @param desiredSpeed: how fast you want the intake to run
	 */
	public IntakeBoulder(/* double desiredTime, */double desiredSpeed)
	{
		// this.desiredTime = desiredTime;
		this.desiredSpeed = desiredSpeed;
		requires(intake);
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
		// timer.start();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Set intake to desired speed
	 */
	protected void execute()
	{
		intake.setIntakeSpeed(desiredSpeed);
	}

	/**
	 * If time >= desired time, stop running the command
	 * If time < desired time, keep running the command
	 * If neither, stop running the command
	 */
	protected boolean isFinished()
	{
		if (desiredSpeed > 0)
		{
			return intake.isWhiskerSwitchTriggered();
		}
		return false;
		/*
		 * if(timer.get() >= desiredTime)
		 * {
		 * return true;
		 * }
		 * else if(timer.get() < desiredTime)
		 * {
		 * return false;
		 * }
		 * else
		 * {
		 * return true;
		 * }
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
