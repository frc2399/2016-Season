package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	private CANTalon leftFrontTalon;
	private CANTalon rightFrontTalon;
	private CANTalon leftBackTalon;
	private CANTalon rightBackTalon;
	
	/*
	 * Makes new encoders
	 */
	private Encoder rightEncoder;
	private Encoder leftEncoder;
	
	private double desiredDistance;
	private double desiredAngleRight;
	private double desiredAngleLeft;

	/*
	 * Takes in counts for the encoder
	 * Construct two new encoders
	 * Setting the distance per pulse 
	 */
	public Drivetrain(int encodercounts)
	{
		leftFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_LEFTFRONT_TALON_ADDRESS);
		rightFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFTBACK_TALON_ADDRESS);
		rightBackTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTBACK_TALON_ADDRESS);
		
		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_RIGHT_ENCODER_CHANNEL_A, RobotMap.DRIVETRAIN_RIGHT_ENCODER_CHANNEL_B);
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_ENCODER_CHANNEL_A, RobotMap.DRIVETRAIN_LEFT_ENCODER_CHANNEL_B);
		
		rightEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);
		leftEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);
	}
	
	/*
	 * Gets position of left and right encoder
	 */
	public double getLeftPosition()
	{
		return leftEncoder.getDistance();
	}

	public double getRightPosition()
	{
		return rightEncoder.getDistance();
	}

	public double getCurrentAngle()
	{
		return 0; // left encoder value
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

	/*
	 * Resets the encoder
	 */
	public void setLeftDesiredDistance(double goalDistance)
	{
		leftEncoder.reset();
		desiredDistance = goalDistance;
	}

	public void setRightDesiredDistance(double goalDistance)
	{
		rightEncoder.reset();
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
		double error = getRightDesiredAngle() - getCurrentAngle();
		double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
		setRightSpeed(pOutput);
	}

	public void moveToLeftAngle()
	{
		double error = getLeftDesiredAngle() - getCurrentAngle();
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
