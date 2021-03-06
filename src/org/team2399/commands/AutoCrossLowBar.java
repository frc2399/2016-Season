package org.team2399.commands;

import org.team2399.Utility;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Be sure to end your defense crossing with the robot as far away from the wall
 * as you can make it (otherwise you won't be able to make the turn)
 */
public class AutoCrossLowBar extends CommandGroup
{

	public AutoCrossLowBar()
	{
		// TODO: test/find measurements

		addSequential(new AnglePitch(-15));
		addSequential(new DriveAtAngleDistance(0, Utility.feetToInches(3.92), 5));
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
