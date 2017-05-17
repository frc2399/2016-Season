package org.team2399;

import org.team2399.commands.AnglePitch;
import org.team2399.commands.DistancePConstantAdjustment;
import org.team2399.commands.DrivetrainAnglePConstantAdjustment;
import org.team2399.commands.JoyIntake;
import org.team2399.commands.JoyPitch;
import org.team2399.commands.PitchAnglePConstantAdjustment;
import org.team2399.commands.PositionAndIntake;
import org.team2399.commands.PositiveIntakeValues;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
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
	
	/**
	private static Joystick leftJoy = new Joystick(
			RobotMap.JOYDRIVE_LEFT_STICK_PORT);
	private static Joystick rightJoy = new Joystick(
			RobotMap.JOYDRIVE_RIGHT_STICK_PORT);
	**/

	private static XboxController xbox = new XboxController(RobotMap.XBOX_PORT);
	private static Joystick intakeJoy = new Joystick(
			RobotMap.INTAKE_STICK_PORT);

	/**
	 * Pitch buttons (preset angles)
	 * TODO: Set actual buttons for pitch
	 */

	private static Button lowPitchButt = new JoystickButton(intakeJoy, 11);
	private static Button medPitchButt = new JoystickButton(intakeJoy, 12);
	private static Button highPitchButt = new JoystickButton(intakeJoy, 9);
	private static Button stopPitchButt = new JoystickButton(intakeJoy, 10);

	private static Button automaticPitchAndIntakeButt = new JoystickButton(
			xbox, 1); // A
	private static Button porticulliusButt = new JoystickButton(xbox, 2); //B


	/**
	 * Intake buttons
	 */
	private static Button intakeButt = new JoystickButton(xbox, 0); //X
	private static Button outtakeButt = new JoystickButton(xbox, 3); //Y
	private static Button stopButt = new JoystickButton(xbox, 4);

	// private static Button switchToCameraOneButt = new
	// JoystickButton(intakeJoy,
	// 5); // TODO
	// private static Button switchToCameraZeroButt = new JoystickButton(
	// intakeJoy, 6); // find
	// port

	/**
	private static Button incrementDistancePConstantButt = new JoystickButton(
			rightJoy, 5);
	private static Button decrementDistancePConstantButt = new JoystickButton(
			rightJoy, 6);

	private static Button incrementDrivetrainAnglePConstantButt = new JoystickButton(
			rightJoy, 3);
	private static Button decrementDrivetrainAnglePConstantButt = new JoystickButton(
			rightJoy, 4);

	private static Button incrementPitchAnglePConstantButt = new JoystickButton(
			leftJoy, 3);
	private static Button decrementPitchAnglePConstantButt = new JoystickButton(
			leftJoy, 4);
			
	**/

	/**
	 * PRESETS
	 */

	private static PositionAndIntake positionAndIntake = new PositionAndIntake();
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

	// private static SwitchToCameraOne switchToCameraOne = new
	// SwitchToCameraOne();

	/**
	private static DistancePConstantAdjustment incrementDistancePConstant = new DistancePConstantAdjustment(
			true);
	private static DistancePConstantAdjustment decrementDistancePConstant = new DistancePConstantAdjustment(
			false);

	private static DrivetrainAnglePConstantAdjustment incrementDrivetrainAnglePConstant = new DrivetrainAnglePConstantAdjustment(
			true);
	private static DrivetrainAnglePConstantAdjustment decrementDrivetrainAnglePConstant = new DrivetrainAnglePConstantAdjustment(
			false);

	private static PitchAnglePConstantAdjustment incrementPitchAnglePConstant = new PitchAnglePConstantAdjustment(
			true);
	private static PitchAnglePConstantAdjustment decrementPitchAnglePConstant = new PitchAnglePConstantAdjustment(
			false);
	**/
	
	private static PositiveIntakeValues positiveIntakeValues = new PositiveIntakeValues(
			1);

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

		automaticPitchAndIntakeButt.whenPressed(positionAndIntake);

		// switchToCameraOneButt.whenPressed(switchToCameraOne);
		// switchToCameraZeroButt.whenPressed(switchToCameraZero);
		lowPitchButt.whenPressed(lowAngle);
		medPitchButt.whenPressed(medAngle);
		highPitchButt.whenPressed(highAngle);
		stopPitchButt.whenPressed(stopSpoon);

		/**
		incrementDistancePConstantButt.whenPressed(incrementDistancePConstant);
		decrementDistancePConstantButt.whenPressed(decrementDistancePConstant);

		incrementDrivetrainAnglePConstantButt
				.whenPressed(incrementDrivetrainAnglePConstant);
		decrementDrivetrainAnglePConstantButt
				.whenPressed(decrementDrivetrainAnglePConstant);

		incrementPitchAnglePConstantButt
				.whenPressed(incrementPitchAnglePConstant);
		decrementPitchAnglePConstantButt
				.whenPressed(decrementPitchAnglePConstant);
		**/

		porticulliusButt.whileHeld(positiveIntakeValues);

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
		return xbox.getY(GenericHID.Hand.kLeft) * RobotMap.JOYDRIVE_FORWARD_CONSTANT;
	}

	public static double getRightY()
	{
		return xbox.getY(GenericHID.Hand.kRight) * RobotMap.JOYDRIVE_FORWARD_CONSTANT;
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
		double throttle = xbox.getTriggerAxis(GenericHID.Hand.kRight) * RobotMap.THROTTLE_FORWARD_CONSTANT;
		return (throttle + 1) / 2;
	}

	public static double getLeftThrottle()
	{
		double throttle = xbox.getTriggerAxis(GenericHID.Hand.kLeft)
				* RobotMap.THROTTLE_FORWARD_CONSTANT;
		return (throttle + 1) / 2;
	}

	public static double getIntakeThrottle()
	{
		double throttle = intakeJoy.getThrottle()
				* RobotMap.THROTTLE_FORWARD_CONSTANT;
		return (throttle + 1) / 2;
	}

	public static boolean isPorticullasButtPressed()
	{
		return porticulliusButt.get();
	}

	public static boolean isOutputButtPressed()
	{
		return outtakeButt.get();
	}

	public static boolean isSwitchButtonPressed()
	{
		return xbox.getBumper(GenericHID.Hand.kRight);
	}
	
	public static void rumble(double right, double left)
	{
		xbox.setRumble(GenericHID.RumbleType.kLeftRumble, left);
		xbox.setRumble(GenericHID.RumbleType.kRightRumble, right);
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
