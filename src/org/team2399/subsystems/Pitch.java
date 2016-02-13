package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyPitch;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
// The arm subsystem.
public class Pitch extends Subsystem
{

	/*
	 * Fields pitchTalon: Talon for the pitch pitchPot: potentiometer
	 * desiredAngle: the angle you want timer: timer for the P loop
	 */
	private CANTalon pitchTalon = new CANTalon(RobotMap.PITCH_TALON_ADDRESS);
	private double desiredAngle;
	private Timer timer = new Timer();

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// This method isn't called getDegrees b/c we're not asking whether or not
	// the arm (spoon) has a bachelor's
	// or master's

	// sets what the desired angle is

	/*
	 * Pitch constructor enableBreakMode stops the motor from moving without
	 * input from the driver station
	 */
	public Pitch()
	{
		pitchTalon.enableBrakeMode(true);
		pitchTalon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		timer.start();
	}

	/*
	 * sets the desired angle for the Pitch
	 */
	public void setDesiredAngle(double goal)
	{
		desiredAngle = goal;
	}

	// gets the private variable of the desired angle
	public double getDesiredAngle()
	{
		return desiredAngle;
	}

	// gets the current angle in degrees
	public double getCurrentAngle()
	{
		return pitchPot.get();
	}

	/*
	 * P loop for going to an angle Timer for loop speed control
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

	/*
	 * Sets the speed of the Pitch
	 */
	public void setPitchSpeed(double speed)
	{
		pitchTalon.set(speed * RobotMap.PITCH_FORWARD_CONSTANT);
	}

	/*
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyPitch());
	}
}
