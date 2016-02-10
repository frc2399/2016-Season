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

	private CANTalon pitchTalon = new CANTalon(RobotMap.PITCH_TALON_ADDRESS);
	private AnalogPotentiometer pitchPot = new AnalogPotentiometer(
			RobotMap.PITCH_POT_PORT);
	private double desiredAngle;
	private Timer timer = new Timer();

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// This method isn't called getDegrees b/c we're not asking whether or not
	// the arm (spoon) has a bachelor's
	// or master's

	// sets what the desired angle is

	public Pitch()
	{
		pitchTalon.enableBrakeMode(true);
		timer.start();
	}

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

	// finds the error and gets the output of the P loop (see Control Loops doc
	// for more info) and
	// sets the armTalon to the output
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

	public void setPitchSpeed(double speed)
	{
		pitchTalon.set(speed * RobotMap.PITCH_FORWARD);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyPitch());
	}
}
