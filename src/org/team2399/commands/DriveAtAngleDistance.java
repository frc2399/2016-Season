package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveAtAngleDistance extends Command
{
	private Drivetrain driveTrain = Robot.drivetrain;
	private double desiredAngle;
	private double desiredDistance;
	
	public DriveAtAngleDistance(double desiredAngle, double desiredDistance)
	{
		this.desiredAngle = desiredAngle;
		this.desiredDistance = desiredDistance;
		setInterruptible(true);
	}

	@Override
	protected void initialize()
	{
		driveTrain.setDesiredAngle(desiredAngle);
		driveTrain.setRightDesiredDistance(desiredDistance);
		driveTrain.setLeftDesiredDistance(desiredDistance);
	}

	@Override
	protected void execute()
	{
		driveTrain.driveAtAngleToDistance();
		
	}

	@Override
	protected boolean isFinished()
	{ 
		if(driveTrain.isDriveAngleFinished() == true && 
			driveTrain.isDriveDistanceFinished() == true)
		{ 
			return true; 
		}
		else 
		{ 
			return false;
		}
	} 
	

	@Override
	protected void end()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted()
	{
		// TODO Auto-generated method stub
		
	}

}
