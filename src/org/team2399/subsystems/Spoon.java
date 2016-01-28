package org.team2399.subsystems;

import org.team2399.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
// The arm subsystem.
public class Spoon extends Subsystem
{

	private CANTalon armTalon = new CANTalon(RobotMap.ARM_TALON_ADDRESS);
	private AnalogPotentiometer armPot = new AnalogPotentiometer(
			RobotMap.ARM_POT_PORT);
	private double desiredAngle;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// This method isn't called getDegrees b/c we're not asking whether or not
	// the arm (spoon) has a bachelor's
	// or master's

	// sets what the desired angle is
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
		double error = getDesiredAngle() - getCurrentAngle();
		double pOutput = error * RobotMap.P_CONSTANT;
		armTalon.set(pOutput);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
