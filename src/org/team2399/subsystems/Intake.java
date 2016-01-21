package org.team2399.subsystems;

import org.team2399.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem
{

	private CANTalon intakeTalon = new CANTalon(RobotMap.INTAKE_TALON_ADDRESS);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void setIntakeSpeed(double speed)
	{
		intakeTalon.set(speed);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
