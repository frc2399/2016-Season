package org.team2399.commands;

import org.team2399.Robot;
import org.team2399.subsystems.Pitch;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
// Command that moves the arm
public class AnglePitch extends Command
{
	/*
	 * pitch: Creates a new instance of the pitch subsystem desiredAngle: where
	 * you want to go
	 */
	private Pitch pitch = Robot.pitch;
	private double desiredAngle;

	/*
	 * AnglePitch constructor Sets the desired angle needs the pitch subsystem
	 * allows command to be interrupted
	 */
	public AnglePitch(double desiredAngle)
	{
		this.desiredAngle = desiredAngle;
		requires(pitch);
		setInterruptible(true);
	}

	/*
	 * Called just before this command runs the first time Sets desired angle at
	 * time of initialization
	 */
	protected void initialize()
	{
		pitch.setDesiredAngle(desiredAngle);
	}

	/*
	 * Called repeatedly when this command is scheduled to run Moves the arm to
	 * the desired angle
	 */
	protected void execute()
	{
		pitch.movePitch();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
