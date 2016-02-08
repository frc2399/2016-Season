package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	private CANTalon leftFrontTalon;
	private CANTalon rightFrontTalon;
	private CANTalon leftBackTalon;
	private CANTalon rightBackTalon;

	private RobotDrive drive;

	private double desiredDistance;
	private double desiredAngleRight;
	private double desiredAngleLeft;

	public Drivetrain(int encodercounts, Gyro g)
	{
		leftFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_LEFTFRONT_TALON_ADDRESS);
		rightFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFTBACK_TALON_ADDRESS);
		rightBackTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTBACK_TALON_ADDRESS);
		drive = new RobotDrive(leftFrontTalon, rightFrontTalon, leftBackTalon,
				rightBackTalon);

	}

	// TODO: Put in actual encoder values
	public double getLeftPosition()
	{
		return 0;
	}

	public double getRightPosition()
	{
		return 0;
	}

	public double getLeftCurrentAngle()
	{
		return 0; // left encoder value
	}

	public double getRightCurrentAngle()
	{
		return 0; // right encoder value
	}

	// TODO: Figure out math to put in degrees and get out encoder value
	public void setRightDesiredAngle(double goalAngle)
	{
		desiredAngleRight = goalAngle;
	}

	public void setLeftDesiredAngle(double goalAngle)
	{
		desiredAngleLeft = goalAngle;
	}

	public void setLeftDesiredDistance(double goalDistance)
	{
		desiredDistance = goalDistance;
	}

	public void setRightDesiredDistance(double goalDistance)
	{
		desiredDistance = goalDistance;
	}

	public double getLeftDesiredDistance()
	{
		return desiredDistance;
	}

	public double getRightDesiredDistance()
	{
		return desiredDistance;
	}

	public double getLeftDesiredAngle()
	{
		return desiredAngleLeft;
	}

	public double getRightDesiredAngle()
	{
		return desiredAngleRight;
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

	public void moveToRightAngle()
	{
		double error = getRightDesiredAngle() - getRightCurrentAngle();
		double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
		setRightSpeed(pOutput);
	}

	public void moveToLeftAngle()
	{
		double error = getLeftDesiredAngle() - getLeftCurrentAngle();
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
