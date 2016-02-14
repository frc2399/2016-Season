package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyPitch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Pitch extends Subsystem
{

	/**
	 * Fields
	 * pitchTalon: Talon for the pitch
	 * pitchPot: potentiometer
	 * desiredAngle: the angle you want
	 * timer: timer for the P loop
	 */
	private CANTalon pitchTalon = new CANTalon(RobotMap.PITCH_TALON_ADDRESS);
	private double desiredAngle;
	private Encoder pitchEncoder;
	private Timer timer = new Timer();

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/**
	 * Pitch constructor
	 * enableBreakMode stops the motor from moving without input from the driver
	 * station
	 * TODO: What does setFeedbackDevice do?
	 */
	public Pitch()
	{
		pitchTalon.enableBrakeMode(true);
		pitchTalon
				.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		timer.start();
	}

	/**
	 * Sets the desired angle for the Pitch
	 * @param goal: saves the value of angle in the field
	 */
	public void setDesiredAngle(double goal)
	{
		desiredAngle = goal;
	}

	/**
	 * Gets the desired angle
	 * @return: the desired angle
	 */
	public double getDesiredAngle()
	{
		return desiredAngle;
	}

	/**
	 * @param degrees
	 * @return the rotations of the pitch (converted from degrees)
	 * for use with limit switches, etc.
	 */
	public double degreesToRotations(double degrees)
	{
		return degrees / (360 * RobotMap.PITCH_GEAR_RATIO);
	}

	/**
	 * @param rotations
	 * @return the number of degrees (converted from rotations)
	 * for use with limit switches, etc.
	 */
	public double rotationsToDegrees(double rotations)
	{
		return rotations * 360 * RobotMap.PITCH_GEAR_RATIO;
	}

	/**
	 * gets the current angle in degrees
	 * @return: gets the current angle of the pitch in degrees
	 */
	public double getCurrentAngle()
	{
		return pitchTalon.getPosition() * 360 * RobotMap.PITCH_GEAR_RATIO;
	}

	/**
	 * P loop for going to an angle
	 * Timer for loop speed control
	 */
	public void movePitch()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.PITCH_LOOP_HERTZ_CONSTANT)
		{
			double error = getDesiredAngle() - getCurrentAngle();
			double pOutput = error * RobotMap.PITCH_P_CONSTANT;
			setPitchSpeed(pOutput);
			timer.reset();
		}
	}

	/**
	 * Sets the speed of the Pitch
	 * @param speed: desired speed of the pitch
	 */
	public void setPitchSpeed(double speed)
	{
		pitchTalon.set(speed * RobotMap.PITCH_FORWARD_CONSTANT);
	}

	/**
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyPitch());
	}
}
