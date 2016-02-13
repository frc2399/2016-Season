package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyIntake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem
{
	/*
	 * Intake motors
	 */
	private CANTalon intakeTopTalon = new CANTalon(
			RobotMap.INTAKE_TOP_TALON_ADDRESS);
	private CANTalon intakeBottomTalon = new CANTalon(
			RobotMap.INTAKE_BOTTOM_TALON_ADDRESS);
	/*
	 * Timer for the P loop
	 */
	private Timer timer = new Timer();

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/*
	 * Intake constructor
	 */
	public Intake()
	{
		timer.stop();
	}

	/*
	 * Sets the intake speed
	 */
	public void setIntakeSpeed(double speed)
	{
		intakeTopTalon.set(speed * RobotMap.INTAKE_TOP_SPEED_IN_CONSTANT);
		intakeBottomTalon.set(speed * RobotMap.INTAKE_BOTTOM_SPEED_IN_CONSTANT);
	}

	/*
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyIntake(RobotMap.STOP_SPEED));
	}
}
