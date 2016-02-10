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
	public static final int DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS = 3;
	public static final int DRIVETRAIN_LEFTFRONT_TALON_ADDRESS = 4;
	public static final int DRIVETRAIN_RIGHTBACK_TALON_ADDRESS = 5;
	public static final int DRIVETRAIN_LEFTBACK_TALON_ADDRESS = 2;

	public static final int INTAKE_TOP_TALON_ADDRESS = 1;
	public static final int INTAKE_BOTTOM_TALON_ADDRESS = 7;

	public static final int PITCH_TALON_ADDRESS = 6;
	// TODO: CHANGE PORT NUMBER
	public static final int PITCH_POT_PORT = 0;
	/*
	 * PLEASE DO NOT CHANGE UNLESS JOYSTICKS BREAK
	 */
	public static final int JOYDRIVE_RIGHT_STICK_PORT = 1;
	public static final int JOYDRIVE_LEFT_STICK_PORT = 0;
	public static final int INTAKE_STICK_PORT = 2;

	public static final int DRIVETRAIN_FORWARD_RIGHT = -1;
	public static final int DRIVETRAIN_FORWARD_LEFT = 1;
	public static final int INTAKE_TOP_SPEED_IN_CONSTANT = -1;
	public static final int INTAKE_BOTTOM_SPEED_IN_CONSTANT = -1;
	public static final int PITCH_FORWARD = 1; // TODO: figure out what this
												// constant actually is

	public static final int JOYDRIVE_FORWARD = -1;
	public static final int PITCH_JOY_FORWARD = -1;
	public static final int THROTTLE_FORWARD = -1;

	public static final double INTAKE_SPEED = 1.0;
	public static final double OUTTAKE_SPEED = -1.0;
	public static final double STOP_SPEED = 0.0;

	public static final double PITCH_P_CONSTANT = 0.0;
	public static final double DRIVE_P_CONSTANT = 0.0;

	public static final double LOW_ANGLE_CONSTANT = 0.0;
	public static final double MED_ANGLE_CONSTANT = 0.0;
	public static final double HIGH_ANGLE_CONSTANT = 0.0;
	public static final double STOP_PITCH_SPEED_CONSTANT = 0.0;

	// Hertz: number of times you go through a loop in a second
	public static final double PITCH_LOOP_HERTZ_CONSTANT = 100;
	public static final double DRIVE_LOOP_HERTZ_CONSTANT = 100;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
