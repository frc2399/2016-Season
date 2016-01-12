package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private CANTalon leftTalon = new CANTalon(
			RobotMap.DRIVETRAIN_LEFT_TALON_ADDRESS);
	private CANTalon rightTalon = new CANTalon(
			RobotMap.DRIVETRAIN_RIGHT_TALON_ADDRESS);

	public void driveLeft(double leftSpeed) {
		leftTalon.set(leftSpeed * RobotMap.DRIVETRAIN_FORWARD_LEFT);
	}

	// If wired positively, negate the right speed
	public void driveRight(double rightSpeed) {
		rightTalon.set(rightSpeed * RobotMap.DRIVETRAIN_FORWARD_RIGHT);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoyDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
