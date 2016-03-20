package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveAtAngleDistance extends Command
{
	/**
	 * creates new instance of drivetrain subsystem
	 * variables desiredAngle and desiredDistance
	 */
	private Drivetrain driveTrain = Robot.drivetrain;
	private double desiredAngle;
	private double desiredDistance;
	private double desiredTime;
	private Timer timer;

	/**
	 * DriveAtAngleDistance constructor
	 * can be interrupted by other commands
	 * @param desiredAngle: stored in field
	 * @param desiredDistance: stored in field
	 */
	public DriveAtAngleDistance(double desiredAngle, double desiredDistance, double time)
	{
		this.desiredAngle = desiredAngle;
		this.desiredDistance = desiredDistance;
		this.desiredTime = time;
		setInterruptible(true);
		timer = new Timer();
	}

	/**
	 * setting desired angles and distances
	 */
	protected void initialize()
	{
		driveTrain.setDesiredAngle(desiredAngle);
		driveTrain.setRightDesiredDistance(desiredDistance);
		driveTrain.setLeftDesiredDistance(desiredDistance);
		timer.start();
	}

	/**
	 * implements P loop
	 */
	protected void execute()
	{
		driveTrain.driveAtAngleToDistance();

	}

	/**
	 * If robot is within acceptable margin of error
	 * for both angle and distance, command is finished
	 */
	protected boolean isFinished()
	{
		if ((driveTrain.isDriveAngleFinished() == true
				&& driveTrain.isDriveDistanceFinished() == true) || timer.get() > desiredTime)
		{
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	protected void end()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted()
	{
		// TODO Auto-generated method stub

	}

}
