package org.team2399;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{

	/*
	 * Things on the CAN network have addresses. Things on PWM network have
	 * ports.
	 */
	public static final int DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS = 0;
	public static final int DRIVETRAIN_LEFTFRONT_TALON_ADDRESS = 0;
	public static final int DRIVETRAIN_RIGHTBACK_TALON_ADDRESS = 0;
	public static final int DRIVETRAIN_LEFTBACK_TALON_ADDRESS = 0;

	/*
	 * PLEASE DO NOT CHANGE UNLESS JOYSTICKS BREAK
	 */
	public static final int JOYDRIVE_RIGHT_STICK_PORT = 0;
	public static final int JOYDRIVE_LEFT_STICK_PORT = 0;

	public static final int DRIVETRAIN_FORWARD_RIGHT = -1;
	public static final int DRIVETRAIN_FORWARD_LEFT = 1;

	public static final int JOYDRIVE_FORWARD = -1;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
