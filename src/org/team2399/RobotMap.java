package org.team2399;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{

	/**
	 * Address for Talons Things on the CAN network have addresses. Things on
	 * PWM network have ports.
	 */
	public static final int DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS = 3;
	public static final int DRIVETRAIN_LEFTFRONT_TALON_ADDRESS = 2;
	public static final int DRIVETRAIN_RIGHTBACK_TALON_ADDRESS = 5;
	public static final int DRIVETRAIN_LEFTBACK_TALON_ADDRESS = 4;

	public static final int INTAKE_TOP_TALON_ADDRESS = 1;
	public static final int INTAKE_BOTTOM_TALON_ADDRESS = 7;

	public static final int PITCH_TALON_ADDRESS = 6;

	/**
	 * Sets the drivetrain encoder port numbers
	 */
	public static final int DRIVETRAIN_LEFT_ENCODER_CHANNEL_A = 1;
	public static final int DRIVETRAIN_LEFT_ENCODER_CHANNEL_B = 1;
	public static final int DRIVETRAIN_RIGHT_ENCODER_CHANNEL_A = 1;
	public static final int DRIVETRAIN_RIGHT_ENCODER_CHANNEL_B = 1; // TODO find
																	// the
																	// actual
																	// ports for
																	// all
																	// encoder
																	// channels

	/**
	 * Sets the intake encoder port numbers
	 */
	public static final int INTAKE_ENCODER_TOP_CHANNEL_A = 1;
	public static final int INTAKE_ENCODER_TOP_CHANNEL_B = 1;
	public static final int INTAKE_ENCODER_BOTTOM_CHANNEL_A = 1;
	public static final int INTAKE_ENCODER_BOTTOM_CHANNEL_B = 1;
	// TODO find actual port numbers

	/**
	 * Sets the encoder counts for drivetrain and intake
	 */
	public static final int DRIVETRAIN_ENCODER_COUNT = 256;
	public static final int INTAKE_ENCODER_COUNT = 0;
	
	public static final double PITCH_GEAR_RATIO = 18.0/84.0;
	

	/**
	 * Calculates the distance robot travels per rotation of encoder in feet
	 */
	public static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI; // circumference
																	// of wheel
																	// in inches
	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = WHEEL_CIRCUMFERENCE
			* (1 / DRIVETRAIN_ENCODER_COUNT) / 12;

	/**
	 * Finds the rotational distance of intake per one rotation of encoder
	 */
	public static final double INTAKE_DISTANCE_PER_PULSE = 0; // TODO: write
																// actual
																// calculation

	/**
	 * Ports for sensors and joysticks PLEASE DO NOT CHANGE UNLESS JOYSTICKS
	 * BREAK
	 */
	// TODO: CHANGE PORT NUMBER
	public static final int PITCH_POT_PORT = 0;

	public static final int JOYDRIVE_LEFT_STICK_PORT = 0;
	public static final int JOYDRIVE_RIGHT_STICK_PORT = 1;
	public static final int INTAKE_STICK_PORT = 2;

	/**
	 * Motor forward constants
	 */
	public static final int DRIVETRAIN_FORWARD_RIGHT_CONSTANT = -1;
	public static final int DRIVETRAIN_FORWARD_LEFT_CONSTANT = 1;
	public static final int INTAKE_TOP_SPEED_IN_CONSTANT = -1;
	public static final int INTAKE_BOTTOM_SPEED_IN_CONSTANT = -1;
	// TODO: figure out what this constant actually is
	public static final int PITCH_FORWARD_CONSTANT = 1;

	/**
	 * Joystick forward constants
	 */
	public static final int JOYDRIVE_FORWARD_CONSTANT = -1;
	public static final int PITCH_JOY_FORWARD_CONSTANT = -1;
	public static final int THROTTLE_FORWARD_CONSTANT = -1;

	/**
	 * Sensor forward constants
	 *TODO: set actual constants
	 */
	public static final int RIGHT_ENCODER_FORWARD_CONSTANT = 1;
	public static final int LEFT_ENCODER_FORWARD_CONSTANT = 1;
	
	public static final int TOP_ENCODER_FORWARD_CONSTANT = 1;
	public static final int BOTTOM_ENCODER_FORWARD_CONSTANT = 1;
	
	public static final int PITCH_ENCODER_FORWARD_CONSTANT = 1;
	
	public static final int GYRO_FORWARD_CONSTANT = 1;
	
	/**
	 * Preset speeds for intake/pitch
	 */
	public static final double INTAKE_SPEED = 1.0;
	public static final double OUTTAKE_SPEED = -1.0;
	public static final double STOP_SPEED = 0.0;

	public static final double STOP_PITCH_SPEED_CONSTANT = 0.0;

	/**
	 * P constants
	 */
	public static final double PITCH_P_CONSTANT = 0.0;
	public static final double DRIVE_P_CONSTANT = 0.0;
	public static final double DRIVE_ANGLE_P_CONSTANT = 0.0;
	public static final double INTAKE_P_CONSTANT = 0.0;
	
	public static final double DRIVE_MIXED_LINEAR_CONSTANT = 1;
	public static final double DRIVE_MIXED_ANGULAR_CONSTANT = -1;

	/**
	 * Present angles
	 */
	public static final double LOW_ANGLE_CONSTANT = 0.0;
	public static final double MED_ANGLE_CONSTANT = 0.0;
	public static final double HIGH_ANGLE_CONSTANT = 0.0;

	/**
	 * Loop hertz constants Hertz: number of times you go through a loop in a
	 * second
	 */
	public static final double PITCH_LOOP_HERTZ_CONSTANT = 100;
	public static final double DRIVE_LOOP_HERTZ_CONSTANT = 100;
	
	//is converted in commands
	public static final double DRIVE_DISTANCE_ERROR_CONSTANT = 3;
	public static final double DRIVE_ANGLE_ERROR_CONSTANT = 7; 

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
