package org.team2399.subsystems;

import org.team2399.commands.JoyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private CANTalon leftTalon = new CANTalon(1);
	private CANTalon rightTalon = new CANTalon(2);

	public void driveLeft(double leftSpeed) {
		leftTalon.set(leftSpeed);
	}

	// If wired positively, negate the right speed
	public void driveRight(double rightSpeed) {
		rightTalon.set(-rightSpeed);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoyDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
