package org.team2399.commands;

import org.team2399.Utility;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDefenseCrossRockWall extends CommandGroup
{

	public AutoDefenseCrossRockWall()
	{
		// TODO: test/find measurements
		addSequential(new DriveAtAngleDistance(0, Utility.feetToInches(2), 5));
		addSequential(new DriveDistance(4, 5));
		addSequential(new DriveAtAngleDistance(0, Utility.feetToInches(4), 5));
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
