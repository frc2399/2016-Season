package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	private CANTalon leftFrontTalon = new CANTalon(
			RobotMap.DRIVETRAIN_LEFTFRONT_TALON_ADDRESS);

	private CANTalon rightFrontTalon = new CANTalon(
			RobotMap.DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS);
	private CANTalon leftBackTalon = new CANTalon(
			RobotMap.DRIVETRAIN_LEFTBACK_TALON_ADDRESS);
	private CANTalon rightBackTalon = new CANTalon(
			RobotMap.DRIVETRAIN_RIGHTBACK_TALON_ADDRESS);

	private double desiredDistance;

	public double getLeftPosition()
	{
		return 0;
	}

	public double getRightPosition()
	{
		return 0;
	}

	public void setLeftDesiredDistance(double goal)
	{
		desiredDistance = goal;
	}

	public void setRightDesiredDistance(double goal)
	{
		desiredDistance = goal;
	}

	public double getLeftDesiredDistance()
	{
		return desiredDistance;
	}

	public double getRightDesiredDistance()
	{
		return desiredDistance;
	}

	public void moveToLeftDistance()
	{
		double error = getLeftDesiredDistance() - getLeftPosition();
		double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
		setLeftSpeed(pOutput);
	}

	public void moveToRightDistance()
	{
		double error = getRightDesiredDistance() - getRightPosition();
		double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
		setRightSpeed(pOutput);
	}

	public void setLeftSpeed(double leftSpeed)
	{
		leftFrontTalon.set(leftSpeed * RobotMap.DRIVETRAIN_FORWARD_LEFT);
		leftBackTalon.set(leftSpeed * RobotMap.DRIVETRAIN_FORWARD_LEFT);
	}

	// If wired positively, negate the right speed
	public void setRightSpeed(double rightSpeed)
	{
		rightFrontTalon.set(rightSpeed * RobotMap.DRIVETRAIN_FORWARD_RIGHT);
		rightBackTalon.set(rightSpeed * RobotMap.DRIVETRAIN_FORWARD_RIGHT);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
