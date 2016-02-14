package org.team2399.subsystems;

import org.team2399.RobotMap;
import org.team2399.commands.JoyDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem
{

	/**
	 * Makes new CANTalons
	 */
	private CANTalon leftFrontTalon;
	private CANTalon rightFrontTalon;
	private CANTalon leftBackTalon;
	private CANTalon rightBackTalon;

	/**
	 * Makes new encoders
	 */
	private Encoder rightEncoder;
	private Encoder leftEncoder;

	private double desiredDistance;
	private double desiredAngle;

	/**
	 * Created an AHRS (the name of the type of object a NavX is)
	 */
	private AHRS Navx = new AHRS(SPI.Port.kMXP);

	private Timer timer = new Timer();

	/**
	 * Takes in counts for the encoder Construct two new encoders Setting the
	 * distance per pulse
	 * 
	 * @param encodercounts
	 *            : pulse per revolution
	 */
	public Drivetrain(int encodercounts)
	{
		leftFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_LEFTFRONT_TALON_ADDRESS);
		rightFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFTBACK_TALON_ADDRESS);
		rightBackTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTBACK_TALON_ADDRESS);

		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_RIGHT_ENCODER_CHANNEL_A,
				RobotMap.DRIVETRAIN_RIGHT_ENCODER_CHANNEL_B);
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_ENCODER_CHANNEL_A,
				RobotMap.DRIVETRAIN_LEFT_ENCODER_CHANNEL_B);

		rightEncoder
				.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);
		leftEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);

		timer.start();
	}

	/**
	 * Gets current position TODO: input encoder value
	 * 
	 * @return : the distance from the left encoder
	 */
	public double getLeftPosition()
	{
		return leftEncoder.getDistance();
	}

	public double getRightPosition()
	{
		return rightEncoder.getDistance();
	}

	/**
	 * Uses the NavX object to get the yaw (angle)
	 * 
	 * @return: the Yaw(angle)
	 */
	public double getCurrentAngle()
	{
		return Navx.getYaw();
	}

	// TODO: Figure out math to put in degrees and get out encoder value
	public void setDesiredAngle(double goalAngle)
	{
		desiredAngle = goalAngle;
	}

	public double getDesiredAngle()
	{
		return desiredAngle;
	}

	/**
	 * Resets the encoder
	 * 
	 * @param goalDistance
	 *            : saves the distance into the field
	 */
	public void setLeftDesiredDistance(double goalDistance)
	{
		leftEncoder.reset();
		desiredDistance = goalDistance;
	}

	public void setRightDesiredDistance(double goalDistance)
	{
		rightEncoder.reset();
		desiredDistance = goalDistance;
	}

	/**
	 * gets the desired distance
	 * 
	 * @return: the desired distance
	 */
	public double getLeftDesiredDistance()
	{
		return desiredDistance;
	}

	public double getRightDesiredDistance()
	{
		return desiredDistance;
	}

	/**
	 * P loop for going the distance Timer for loop speed control
	 */
	public void moveToLeftDistance()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.DRIVE_LOOP_HERTZ_CONSTANT)
		{
			double error = getLeftDesiredDistance() - getLeftPosition();
			double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
			setLeftSpeed(pOutput);
			timer.reset();
		}
	}

	public void moveToRightDistance()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.DRIVE_LOOP_HERTZ_CONSTANT)
		{
			double error = getRightDesiredDistance() - getRightPosition();
			double pOutput = error * RobotMap.DRIVE_P_CONSTANT;
			setRightSpeed(pOutput);
			timer.reset();
		}
	}

	/**
	 * Calculations to find the most efficient way to move to the desired angle
	 * 
	 * @return: error (desired angle - current angle)
	 */
	public double calculateAngleError()
	{
		double newDesiredAngle;
		if (getCurrentAngle() - 180 >= getDesiredAngle())
		{
			newDesiredAngle = getDesiredAngle() + 360;
		} 
		else if (getCurrentAngle() + 180 < getDesiredAngle())
		{
			newDesiredAngle = getDesiredAngle() - 360;
		} 
		else
		{
			newDesiredAngle = getDesiredAngle();
		}
		return newDesiredAngle - getCurrentAngle();
	}

	/**
	 * replaced error with a method to calculate the error
	 */
	public void moveToAngle()
	{
		double pOutput = calculateAngleError() * RobotMap.DRIVE_ANGLE_P_CONSTANT;
		setRightSpeed(-pOutput);
		setLeftSpeed(pOutput);
	}
	
	public void driveAtAngleToDistance()
	{
		double rightDistanceError = getRightDesiredDistance() - getRightPosition();
		double leftDistanceError = getLeftDesiredDistance() - getLeftPosition();
		double angleError = calculateAngleError();
		
		double rightPOutput = rightDistanceError * RobotMap.DRIVE_P_CONSTANT;
		double leftPOutput = leftDistanceError * RobotMap.DRIVE_P_CONSTANT;
		double anglePOutput = angleError * RobotMap.DRIVE_ANGLE_P_CONSTANT;
		
		setRightSpeed(rightPOutput * RobotMap.DRIVE_MIXED_LINEAR_CONSTANT - 
				anglePOutput * RobotMap.DRIVE_MIXED_ANGULAR_CONSTANT);
		setLeftSpeed(leftPOutput * RobotMap.DRIVE_MIXED_LINEAR_CONSTANT
				+ anglePOutput * RobotMap.DRIVE_MIXED_ANGULAR_CONSTANT);
	}

	/**
	 * Sets the left talons to the inputted speed
	 * 
	 * @param leftSpeed
	 *            : speed of the left side
	 */
	public void setLeftSpeed(double leftSpeed)
	{
		leftFrontTalon.set(leftSpeed
				* RobotMap.DRIVETRAIN_FORWARD_LEFT_CONSTANT);
		leftBackTalon
				.set(leftSpeed * RobotMap.DRIVETRAIN_FORWARD_LEFT_CONSTANT);
	}

	/**
	 * Sets the right talons to the inputted speed
	 * 
	 * @param rightSpeed
	 *            : speed of the right side
	 */
	public void setRightSpeed(double rightSpeed)
	{
		rightFrontTalon.set(rightSpeed
				* RobotMap.DRIVETRAIN_FORWARD_RIGHT_CONSTANT);
		rightBackTalon.set(rightSpeed
				* RobotMap.DRIVETRAIN_FORWARD_RIGHT_CONSTANT);
	}
	
	

	/**
	 * Sets the default command for the subsystem
	 */
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoyDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
