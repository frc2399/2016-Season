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

	/**
	 * desiredDistance: distance you want to be at
	 * desiredAngle: angle you want to be at
	 */
	private double desiredDistance;
	private double desiredAngle;

	/**
	 * Navx gyro (object type AHRS)
	 */
	private AHRS Navx = new AHRS(SPI.Port.kMXP);

	/**
	 * timer for use with loops
	 */
	private Timer timer = new Timer();
	
	private double distancePConstant = 0.01;
	private double anglePConstant = 0.01;

	/**
	 * Drivetrain constructor
	 * Takes in counts for the encoder
	 * Construct two new encoders
	 * Sets the distance per pulse
	 * @param encodercounts: pulse per revolution
	 */
	public Drivetrain(int encodercounts)
	{
		// creates talons
		leftFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_LEFTFRONT_TALON_ADDRESS);
		rightFrontTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTFRONT_TALON_ADDRESS);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFTBACK_TALON_ADDRESS);
		rightBackTalon = new CANTalon(
				RobotMap.DRIVETRAIN_RIGHTBACK_TALON_ADDRESS);

		// sets encoder channels
		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_RIGHT_ENCODER_CHANNEL_A,
				RobotMap.DRIVETRAIN_RIGHT_ENCODER_CHANNEL_B);
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_ENCODER_CHANNEL_A,
				RobotMap.DRIVETRAIN_LEFT_ENCODER_CHANNEL_B);

		// sets distance per pulse
		rightEncoder
				.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);
		leftEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);

		// starts the timer
		timer.start();
	}

	/**
	 * ENCODER/DRIVE DISTANCE METHODS
	 */

	/**
	 * Gets current left position
	 * TODO: input encoder value
	 * @return : the distance from the left encoder
	 */
	public double getLeftPosition()
	{
		return leftEncoder.getDistance();
	}

	/**
	 * Gets current right position
	 * TODO: input encoder value
	 * @return : the distance from the right encoder
	 */
	public double getRightPosition()
	{
		return rightEncoder.getDistance();
	}

	/**
	 * Resets the left encoder
	 * @param goalDistance: saves the local variable into the field
	 */
	public void setLeftDesiredDistance(double goalDistance)
	{
		leftEncoder.reset();
		desiredDistance = goalDistance;
	}

	/**
	 * Resets the right encoder
	 * @param goalDistance: saves the local variable into the field
	 */
	public void setRightDesiredDistance(double goalDistance)
	{
		rightEncoder.reset();
		desiredDistance = goalDistance;
	}

	/**
	 * gets the left desired distance for use in other classes
	 * @return: the left desired distance
	 */
	public double getLeftDesiredDistance()
	{
		return desiredDistance;
	}

	/**
	 * gets the right desired distance for use in other classes
	 * @return: the right desired distance
	 */
	public double getRightDesiredDistance()
	{
		return desiredDistance;
	}

	/**
	 * P loop for going a desired distance (left)
	 * Timer for loop speed control
	 */
	public void moveToLeftDistance()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.DRIVE_LOOP_HERTZ_CONSTANT)
		{
			double error = getLeftDesiredDistance() - getLeftPosition();
			double pOutput = error * distancePConstant;
			setLeftSpeed(pOutput);
			timer.reset();
		}
	}

	/**
	 * P loop for going a desired distance (right)
	 * Timer for loop speed control
	 */
	public void moveToRightDistance()
	{
		double currentTime = timer.get();

		if (currentTime > RobotMap.DRIVE_LOOP_HERTZ_CONSTANT)
		{
			double error = getRightDesiredDistance() - getRightPosition();
			double pOutput = error * distancePConstant;
			setRightSpeed(pOutput);
			timer.reset();
		}
	}

	/**
	 * Calculates left error for use in commands (determining if robot is within
	 * acceptable error range)
	 * @return: error (desired - current)
	 */
	public double calculateLeftDistanceError()
	{
		return getLeftDesiredDistance() - getLeftPosition();
	}

	/**
	 * Calculates right error for use in commands (determining if robot is
	 * within
	 * acceptable error range)
	 * @return: error (desired - current)
	 */
	public double calculateRightDistanceError()
	{
		return getRightDesiredDistance() - getRightPosition();
	}

	/**
	 * If error is within an acceptable range, return true
	 * for use in isFinished method in commands
	 * @return: true/false
	 */
	public boolean isDriveDistanceFinished()
	{
		if (Math.abs(calculateLeftDistanceError()) <= RobotMap.DRIVE_DISTANCE_ERROR_CONSTANT
				&& Math.abs(calculateRightDistanceError()) <= RobotMap.DRIVE_DISTANCE_ERROR_CONSTANT)
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	/**
	 * the units for this is inches/percent
	 */
	public void incrementDistancePConstant()
	{
		distancePConstant += 0.005;
	}
	
	public void decrementDistancePConstant()
	{
		distancePConstant -= 0.005;
	}
	
	public double getDistancePConstant()
	{
		return distancePConstant;
	}
	
	

	/**
	 * GYRO/ANGLE METHODS
	 */

	/**
	 * Uses the NavX object to get the yaw (angle)
	 * @return: the yaw (angle)
	 */
	public double getCurrentAngle()
	{
		return Navx.getYaw();
	}

	/**
	 * sets desired angle for pitch
	 * @param goalAngle: desired angle
	 */
	public void setDesiredAngle(double goalAngle)
	{
		desiredAngle = goalAngle;
	}

	/**
	 * gets desired angle for use in other classes
	 * @return: desired angle
	 */
	public double getDesiredAngle()
	{
		return desiredAngle;
	}

	/**
	 * Calculations to find the most efficient way to move to the desired angle
	 * @return: error (desired angle - current angle)
	 */
	public double calculateAngleError()
	{
		double newDesiredAngle;
		if (getCurrentAngle() - 180 >= getDesiredAngle())
		{
			newDesiredAngle = getDesiredAngle() + 360;
		} else if (getCurrentAngle() + 180 < getDesiredAngle())
		{
			newDesiredAngle = getDesiredAngle() - 360;
		} else
		{
			newDesiredAngle = getDesiredAngle();
		}
		return newDesiredAngle - getCurrentAngle();
	}

	/**
	 * P loop for driving to a specified angle
	 */
	public void moveToAngle()
	{
		double pOutput = calculateAngleError()
				* anglePConstant;
		setRightSpeed(-pOutput);
		setLeftSpeed(pOutput);
	}

	/**
	 * If error is within an acceptable range, return true
	 * for use in isFinished method in commands
	 * @return: true/false
	 */
	public boolean isDriveAngleFinished()
	{
		if (Math.abs(calculateAngleError()) <= RobotMap.DRIVE_ANGLE_ERROR_CONSTANT)
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	/**
	 * the units for this is percent/degrees
	 */
	public void incrementAnglePConstant()
	{
		anglePConstant += 0.005;
	}
	
	public void decrementAnglePConstant()
	{
		anglePConstant -= 0.005;
	}
	
	public double getAnglePConstant()
	{
		return anglePConstant;
	}

	/**
	 * DISTANCE + ANGLE METHODS
	 */

	/**
	 * P loop for driving at a constant angle to a distance
	 */
	public void driveAtAngleToDistance()
	{
		double rightDistanceError = getRightDesiredDistance()
				- getRightPosition();
		double leftDistanceError = getLeftDesiredDistance() - getLeftPosition();
		double angleError = calculateAngleError();

		double rightPOutput = rightDistanceError * distancePConstant;
		double leftPOutput = leftDistanceError * distancePConstant;
		double anglePOutput = angleError * anglePConstant;

		setRightSpeed(rightPOutput * RobotMap.DRIVE_MIXED_LINEAR_CONSTANT
				- anglePOutput * RobotMap.DRIVE_MIXED_ANGULAR_CONSTANT);
		setLeftSpeed(leftPOutput * RobotMap.DRIVE_MIXED_LINEAR_CONSTANT
				+ anglePOutput * RobotMap.DRIVE_MIXED_ANGULAR_CONSTANT);
	}

	/**
	 * SPEED METHODS
	 */

	/**
	 * Sets the left Talons to the inputed speed
	 * @param leftSpeed: speed of the left side
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
	 * @param rightSpeed: speed of the right side
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
