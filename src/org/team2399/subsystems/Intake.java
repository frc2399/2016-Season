package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.IntakeBoulder;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem
{

	private CANTalon intakeTopTalon = new CANTalon(
			RobotMap.INTAKE_TOP_TALON_ADDRESS);
	private CANTalon intakeBottomTalon = new CANTalon(
			RobotMap.INTAKE_BOTTOM_TALON_ADDRESS);
	private double desiredPosition;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public double getCurrentPosition()
	{
		return 0; // TODO find actual value
	}

	public void setDesiredPosition(double goalPosition)
	{
		desiredPosition = goalPosition;
	}

	public double getDesiredPosition()
	{
		return desiredPosition;
	}

	public void moveToPosition()
	{
		double error = getDesiredPosition() - getCurrentPosition();
		double pOutput = error * RobotMap.INTAKE_P_CONSTANT;
		setIntakeSpeed(pOutput);
	}

	public void setIntakeSpeed(double speed)
	{
		intakeTopTalon.set(speed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
		intakeBottomTalon.set(speed * RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new IntakeBoulder(RobotMap.STOP_SPEED));
	}
}
