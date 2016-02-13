package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyIntake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class Intake extends Subsystem
{
	/*
	 * Creates new Talons
	 */
	private CANTalon intakeTopTalon;
	private CANTalon intakeBottomTalon;

	private double desiredPosition;

	/**
	 * Created new encoders
	 */
	private Encoder topEncoder;
	private Encoder bottomEncoder;

	private Timer timer = new Timer();

	/**
	 * Takes in the encoder counts Created two encoders sets distance per pulse
	 * 
	 * @param encoderCounts
	 *            : pulse per rotation
	 */
	public Intake(int encoderCounts)
	{

		intakeTopTalon = new CANTalon(RobotMap.INTAKE_TOP_TALON_ADDRESS);
		intakeBottomTalon = new CANTalon(RobotMap.INTAKE_BOTTOM_TALON_ADDRESS);

		topEncoder = new Encoder(RobotMap.INTAKE_ENCODER_TOP_CHANNEL_A,
				RobotMap.INTAKE_ENCODER_TOP_CHANNEL_B);
		bottomEncoder = new Encoder(RobotMap.INTAKE_ENCODER_BOTTOM_CHANNEL_A,
				RobotMap.INTAKE_ENCODER_BOTTOM_CHANNEL_B);

		topEncoder.setDistancePerPulse(RobotMap.INTAKE_DISTANCE_PER_PULSE);
		bottomEncoder.setDistancePerPulse(RobotMap.INTAKE_DISTANCE_PER_PULSE);

		timer.stop();

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/**
	 * Gets the current position of the rotation
	 * 
	 * @return: the distance for the position
	 */
	public double getTopCurrentPosition()
	{
		return topEncoder.getDistance(); // TODO find actual value
	}

	public double getBottomCurrentPosition()
	{
		return bottomEncoder.getDistance();
	}

	/**
	 * Split desired position into top and bottom
	 * 
	 * @param goalPosition
	 *            : saves the value into the field
	 */

	public void setTopDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}

	public void setBottomDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}

	/**
	 * Resets encoder
	 * 
	 * @return: the desired position
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

	/**
	 * Split move to position into top and bottom P loop for moving to
	 * top/bottom position
	 */
	// TODO: Get this checked over
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

	/**
	 * Sets speed of top/bottom intake motors + method for setting both to same
	 * speed
	 * 
	 * @param topSpeed
	 *            : desired speed
	 */
	public void setTopIntakeSpeed(double topSpeed)
	{
		intakeTopTalon.set(topSpeed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
	}

	public void setBottomIntakeSpeed(double bottomSpeed)
	{
		intakeBottomTalon.set(bottomSpeed
				* RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
	}

	public void setIntakeSpeed(double speed)
	{
		intakeBottomTalon.set(speed * RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
		intakeTopTalon.set(speed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
	}

	/**
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyIntake(RobotMap.STOP_SPEED));
	}
}
