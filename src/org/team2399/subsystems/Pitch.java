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

	private CANTalon armTalon = new CANTalon(RobotMap.ARM_TALON_ADDRESS);
	private AnalogPotentiometer armPot = new AnalogPotentiometer(
			RobotMap.ARM_POT_PORT);
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
		armTalon.enableBrakeMode(true);
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
		return armPot.get();
	}

	// finds the error and gets the output of the P loop (see Control Loops doc
	// for more info) and
	// sets the armTalon to the output
	public void moveArm()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.ARM_LOOP_HERTZ_CONSTANT)
		{
			double error = getDesiredAngle() - getCurrentAngle();
			double pOutput = error * RobotMap.ARM_P_CONSTANT;
			setArmSpeed(pOutput);
			timer.reset();
		}
	}

	public void setArmSpeed(double speed)
	{
		armTalon.set(speed * RobotMap.ARM_FORWARD);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyPitch());
	}
}
