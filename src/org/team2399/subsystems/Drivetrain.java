package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem
{
	/*
	 * Drivetrain motors
	 */
	private CANTalon leftFrontTalon = new CANTalon(
			RobotMap.DRIVETRAIN_LEFTFRONT_TALON_ADDRESS);
	private CANTalon rightFrontTalon = new CANTalon(
			RobotMap.DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS);
	private CANTalon leftBackTalon = new CANTalon(
			RobotMap.DRIVETRAIN_LEFTBACK_TALON_ADDRESS);
	private CANTalon rightBackTalon = new CANTalon(
			RobotMap.DRIVETRAIN_RIGHTBACK_TALON_ADDRESS);
	private AHRS Navx = new AHRS(SPI.Port.kMXP);

	/*
	 * Timer for P loop
	 */
	private Timer timer = new Timer();

	/*
	 * The distance you want to move
	 */
	private double desiredDistance;

	/*
	 * Drivetrain constructor
	 */
	public Drivetrain()
	{
		timer.start();
	}

	/*
	 * Gets current position TODO: input encoder value
	 */
	public double getLeftPosition()
	{
		return 0;
	}

	public double getRightPosition()
	{
		return 0;
	}

	/*
	 * Sets desired distance to the goal
	 */
	public void setLeftDesiredDistance(double goal)
	{
		desiredDistance = goal;
	}

	public void setRightDesiredDistance(double goal)
	{
		desiredDistance = goal;
	}

	/*
	 * Gets desired distance
	 */
	public double getLeftDesiredDistance()
	{
		return desiredDistance;
	}

	public double getRightDesiredDistance()
	{
		return desiredDistance;
	}

	/*
	 * P loop for going the distance Timer for loop speed control
	 */
	public void moveToLeftDistance()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.DRIVE_LOOP_HERTZ_CONSTANT)
		{
			double error = getLeftDesiredDistance() - getLeftPosition();
			double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
			setLeftSpeed(pOutput);
			timer.reset();
		}
	}

	public void moveToRightDistance()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.DRIVE_LOOP_HERTZ_CONSTANT)
		{
			double error = getRightDesiredDistance() - getRightPosition();
			double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
			setRightSpeed(pOutput);
			timer.reset();
		}
	}

	/*
	 * Sets the speed of the Drivetrain
	 */
	public void setLeftSpeed(double leftSpeed)
	{
		leftFrontTalon.set(leftSpeed
				* RobotMap.DRIVETRAIN_FORWARD_LEFT_CONSTANT);
		leftBackTalon
				.set(leftSpeed * RobotMap.DRIVETRAIN_FORWARD_LEFT_CONSTANT);
	}

	// If wired positively, negate the right speed
	public void setRightSpeed(double rightSpeed)
	{
		rightFrontTalon.set(rightSpeed
				* RobotMap.DRIVETRAIN_FORWARD_RIGHT_CONSTANT);
		rightBackTalon.set(rightSpeed
				* RobotMap.DRIVETRAIN_FORWARD_RIGHT_CONSTANT);
	}

	/*
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
