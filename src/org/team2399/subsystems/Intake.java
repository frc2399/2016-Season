package org.team2399.subsystems;

import org.team2399.RobotMap;

import org.team2399.commands.IntakeBoulder;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 * 
 */
public class Intake extends Subsystem
{
	private CANTalon intakeTopTalon;
	private CANTalon intakeBottomTalon;
	
	private double desiredPosition;
	
	/* 
	 * Created new encoders 
	 */
	private Encoder topEncoder; 
	private Encoder bottomEncoder; 
	
	/* 
	 * Taking in the encoder counts
	 * Created two encoders 
	 * Sets encoder intake distance per pulse 
	 */
	public Intake(int encoderCounts){

	intakeTopTalon = new CANTalon(
			RobotMap.INTAKE_TOP_TALON_ADDRESS);
	intakeBottomTalon = new CANTalon(
			RobotMap.INTAKE_BOTTOM_TALON_ADDRESS);
	
	topEncoder = new Encoder(
			RobotMap.INTAKE_ENCODER_TOP_CHANNEL_A, RobotMap.INTAKE_ENCODER_TOP_CHANNEL_B);
	bottomEncoder = new Encoder(
			RobotMap.INTAKE_ENCODER_BOTTOM_CHANNEL_A, RobotMap.INTAKE_ENCODER_BOTTOM_CHANNEL_B);
	
	topEncoder.setDistancePerPulse(RobotMap.INTAKE_DISTANCE_PER_PULSE);
	bottomEncoder.setDistancePerPulse(RobotMap.INTAKE_DISTANCE_PER_PULSE);
	
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/*
	 * Gets the current position of the rotation 
	 */
	public double getTopCurrentPosition()
	{
		return topEncoder.getDistance(); // TODO find actual value
	}

	public double getBottomCurrentPosition()
	{
		return bottomEncoder.getDistance();
	}
	
	/* 
	 * Split desired position into top and bottom
	 */
	
	public void setTopDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}
	
	public void setBottomDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}
	
	/* 
	 * Resets encoder
	 */
	public double getTopDesiredPosition()
	{
		topEncoder.reset();
		return desiredPosition;
	}
	
	public double getBottomDesiredPosition()
	{
		bottomEncoder.reset();
		return desiredPosition;
	}
	
	/* 
	 * Split move to position into top and bottom 
	 */
	//TODO: Get this checked over
	public void moveToTopPosition()
	{
		double error = getTopDesiredPosition() - getTopCurrentPosition();
		double pOutput = error * RobotMap.INTAKE_P_CONSTANT;
		setTopIntakeSpeed(pOutput);
	}
	
	public void moveToBottomPosition()
	{
		double error = getBottomDesiredPosition() - getBottomCurrentPosition();
		double pOutput = error * RobotMap.INTAKE_P_CONSTANT;
		setBottomIntakeSpeed(pOutput);
	}

	/* 
	 * Added  set intake speed for top and bottom
	 */
	public void setTopIntakeSpeed(double topSpeed)
	{
		intakeTopTalon.set(topSpeed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
	}
	
	public void setBottomIntakeSpeed(double bottomSpeed)
	{
		intakeBottomTalon.set(bottomSpeed * RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
	}
	
	public void setIntakeSpeed(double speed)
	{
		intakeBottomTalon.set(speed * RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
		intakeTopTalon.set(speed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
	}
	

	public void initDefaultCommand()
	{
		setDefaultCommand(new IntakeBoulder(RobotMap.STOP_SPEED));
	}
}
