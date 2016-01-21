package org.team2399;

import org.team2399.commands.IntakeBoulder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

	private static Joystick leftJoy = new Joystick(
			RobotMap.JOYDRIVE_LEFT_STICK_PORT);
	private static Joystick rightJoy = new Joystick(
			RobotMap.JOYDRIVE_RIGHT_STICK_PORT);

	private Button intakeButt = new JoystickButton(rightJoy, 1);
	private Button outtakeButt = new JoystickButton(leftJoy, 1);
	private Button stopButt = new JoystickButton(rightJoy, 10);

	IntakeBoulder inSpeed = new IntakeBoulder(RobotMap.INTAKE_SPEED);
	IntakeBoulder outSpeed = new IntakeBoulder(RobotMap.OUTTAKE_SPEED);
	IntakeBoulder stopSpeed = new IntakeBoulder(RobotMap.STOP_SPEED);

	public OI()
	{
		intakeButt.whileHeld(inSpeed);
		intakeButt.whenReleased(stopSpeed);
		outtakeButt.whileHeld(outSpeed);
		outtakeButt.whenReleased(stopSpeed);
		stopButt.whenPressed(stopSpeed);
	}

	public double getLeftY()
	{
		return leftJoy.getY() * RobotMap.JOYDRIVE_FORWARD;
	}

	public double getRightY()
	{
		return rightJoy.getY() * RobotMap.JOYDRIVE_FORWARD;
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
