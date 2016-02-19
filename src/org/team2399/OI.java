package org.team2399;

import org.team2399.commands.AnglePitch;
import org.team2399.commands.CameraSwitch;
import org.team2399.commands.JoyIntake;
import org.team2399.commands.JoyPitch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

	/**
	 * DEVICES
	 */

	/**
	 * Joysticks
	 */
	private static Joystick leftJoy = new Joystick(
			RobotMap.JOYDRIVE_LEFT_STICK_PORT);
	private static Joystick rightJoy = new Joystick(
			RobotMap.JOYDRIVE_RIGHT_STICK_PORT);

	private static Joystick intakeJoy = new Joystick(RobotMap.INTAKE_STICK_PORT);

	/**
	 * Pitch buttons (preset angles)
	 * TODO: Set actual buttons for pitch
	 */
	/*
	 * private static Button lowPitchButt = new JoystickButton(intakeJoy, 11);
	 * private static Button medPitchButt = new JoystickButton(intakeJoy, 12);
	 * private static Button highPitchButt = new JoystickButton(intakeJoy, 13);
	 * private static Button stopPitchButt = new JoystickButton(intakeJoy, 14);
	 */

	/**
	 * Intake buttons
	 */
	private static Button intakeButt = new JoystickButton(intakeJoy, 1);
	private static Button outtakeButt = new JoystickButton(intakeJoy, 2);
	private static Button stopButt = new JoystickButton(intakeJoy, 10);

	private static Button cameraSwitchButt = new JoystickButton(intakeJoy, 12); // TODO
																				// find
																				// port
	/**
	 * PRESETS
	 */

	/**
	 * Preset angles for pitch
	 */
	private static AnglePitch lowAngle = new AnglePitch(
			RobotMap.LOW_ANGLE_CONSTANT);
	private static AnglePitch medAngle = new AnglePitch(
			RobotMap.MED_ANGLE_CONSTANT);
	private static AnglePitch highAngle = new AnglePitch(
			RobotMap.HIGH_ANGLE_CONSTANT);
	private static JoyPitch stopSpoon = new JoyPitch();

	/**
	 * Preset speeds
	 */
	private static JoyIntake inSpeed = new JoyIntake(RobotMap.INTAKE_SPEED);
	private static JoyIntake outSpeed = new JoyIntake(RobotMap.OUTTAKE_SPEED);
	private static JoyIntake stopSpeed = new JoyIntake(RobotMap.STOP_SPEED);

	private static CameraSwitch cameraSwitch = new CameraSwitch();

	/**
	 * Sets what buttons do (OI constructor)
	 */

	/**
	 * cameraSwitchButt: switches cameras when pressed
	 */
	public OI()
	{
		intakeButt.whileHeld(inSpeed);
		outtakeButt.whileHeld(outSpeed);
		stopButt.whenPressed(stopSpeed);

		/*
		 * lowPitchButt.whenPressed(lowAngle);
		 * medPitchButt.whenPressed(medAngle);
		 * highPitchButt.whenPressed(highAngle);
		 * stopPitchButt.whenPressed(stopSpoon);
		 */

		cameraSwitchButt.whenPressed(cameraSwitch);
	}

	/**
	 * JOYSTICK METHODS
	 */

	/**
	 * Get values from Joystick to set speeds in other commands/subsystems
	 * @return: returns the y value from joystick
	 */
	public static double getLeftY()
	{
		return leftJoy.getY() * RobotMap.JOYDRIVE_FORWARD_CONSTANT;
	}

	public static double getRightY()
	{
		return rightJoy.getY() * RobotMap.JOYDRIVE_FORWARD_CONSTANT;
	}

	public static double getIntakeY()
	{
		return intakeJoy.getY() * RobotMap.PITCH_JOY_FORWARD_CONSTANT;
	}

	/**
	 * THROTTLE METHODS
	 */

	/**
	 * Gets values from throttle for manual speed control
	 * (throttle + 1)/2 sets throttle value range from 0 to 1 rather than -1 to
	 * 1
	 * @return: returns the values of throttle by manual control
	 */
	public static double getRightThrottle()
	{
		double throttle = rightJoy.getZ() * RobotMap.THROTTLE_FORWARD_CONSTANT;
		return (throttle + 1) / 2;
	}

	public static double getLeftThrottle()
	{
		double throttle = leftJoy.getThrottle()
				* RobotMap.THROTTLE_FORWARD_CONSTANT;
		return (throttle + 1) / 2;
	}

	public static double getIntakeThrottle()
	{
		double throttle = intakeJoy.getThrottle()
				* RobotMap.THROTTLE_FORWARD_CONSTANT;
		return (throttle + 1) / 2;
	}

	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
