package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyIntake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class Intake extends Subsystem
{
	/**
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

	/**
	 * timer for use in loops
	 */
	private Timer timer = new Timer();

	private DigitalInput rightWhisperSwitch = new DigitalInput(RobotMap.RIGHT_WHISPER_SWITCH_PORT_CONSTANT);
	private DigitalInput leftWhisperSwitch = new DigitalInput(RobotMap.LEFT_WHISPER_SWITCH_PORT_CONSTANT);
	/**
	 * Takes in the encoder counts
	 * sets channels for encoders
	 * sets distance per pulse
	 * @param encoderCounts: pulse per rotation
	 */
	public Intake(int encoderCounts)
	{
		// sets talon addresses
		intakeTopTalon = new CANTalon(RobotMap.INTAKE_TOP_TALON_ADDRESS);
		intakeBottomTalon = new CANTalon(RobotMap.INTAKE_BOTTOM_TALON_ADDRESS);

		// sets encoder channels
		topEncoder = new Encoder(RobotMap.INTAKE_ENCODER_TOP_CHANNEL_A,
				RobotMap.INTAKE_ENCODER_TOP_CHANNEL_B);
		bottomEncoder = new Encoder(RobotMap.INTAKE_ENCODER_BOTTOM_CHANNEL_A,
				RobotMap.INTAKE_ENCODER_BOTTOM_CHANNEL_B);

		// sets distance per pulse for encoders
		topEncoder.setDistancePerPulse(RobotMap.INTAKE_DISTANCE_PER_PULSE);
		bottomEncoder.setDistancePerPulse(RobotMap.INTAKE_DISTANCE_PER_PULSE);

		// TODO: Why is this stop and not start?
		timer.stop();

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/**
	 * Gets the current position from the top encoder
	 * @return: the distance for the position
	 */
	public double getTopCurrentPosition()
	{
		return topEncoder.getDistance(); // TODO find actual value
	}

	/**
	 * Gets the current position from the bottom encoder
	 * @return: the distance for the position
	 */
	public double getBottomCurrentPosition()
	{
		return bottomEncoder.getDistance();
	}

	/**
	 * Sets the desired position for the top encoder
	 * @param goalPosition: saves the value into the field
	 */
	public void setTopDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}

	/**
	 * Sets the desired position for the top encoder
	 * @param goalPosition: saves the value into the field
	 */
	public void setBottomDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}

	/**
	 * Resets encoder
	 * @return: the top desired position
	 */
	public double getTopDesiredPosition()
	{
		topEncoder.reset();
		return desiredPosition;
	}

	/**
	 * Resets encoder
	 * @return: the bottom desired position
	 */
	public double getBottomDesiredPosition()
	{
		bottomEncoder.reset();
		return desiredPosition;
	}

	/**
	 * P loop for moving the top to a desired position
	 */
	public void moveToTopPosition()
	{
		double error = getTopDesiredPosition() - getTopCurrentPosition();
		double pOutput = error * RobotMap.INTAKE_P_CONSTANT;
		setTopIntakeSpeed(pOutput);
	}

	/**
	 * P loop for moving the bottom to a desired position
	 */
	public void moveToBottomPosition()
	{
		double error = getBottomDesiredPosition() - getBottomCurrentPosition();
		double pOutput = error * RobotMap.INTAKE_P_CONSTANT;
		setBottomIntakeSpeed(pOutput);
	}

	/**
	 * Sets speed of top motor
	 * TODO: make actual loops
	 * @param topSpeed: desired speed
	 */
	public void setTopIntakeSpeed(double topSpeed)
	{
		intakeTopTalon.set(topSpeed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
	}

	/**
	 * Sets speed of bottom intake motor
	 * speed
	 * TODO: make actual loops
	 * @param topSpeed: desired speed
	 */
	public void setBottomIntakeSpeed(double bottomSpeed)
	{
		intakeBottomTalon.set(bottomSpeed
				* RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
	}

	/**
	 * Setstop/bottom intake motors to the same speed
	 * TODO: make actual loops
	 * @param topSpeed: desired speed
	 */
	public void setIntakeSpeed(double speed)
	{
		intakeBottomTalon.set(speed * RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
		intakeTopTalon.set(speed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
	}
	
	public boolean isWhisperSwitchTriggered(){
		return (rightWhisperSwitch.get() == true) || (leftWhisperSwitch.get() == true);
	
	}

	/**
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyIntake(RobotMap.STOP_SPEED));
	}
}
