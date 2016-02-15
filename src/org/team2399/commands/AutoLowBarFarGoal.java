package org.team2399.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLowBarFarGoal extends CommandGroup
{

	public AutoLowBarFarGoal()
	{
		addSequential(new DriveAtAngleDistance(0, 10)); // TODO:Find actual
														// distance // DISTANCE
		addSequential(new DriveAtAngleDistance(0, 3.92));
		addSequential(new DriveAngle(120));
		addSequential(new DriveAtAngleDistance(120, 15)); // TODO: Find actual
															// distance
		addSequential(new DriveAngle(-60)); // TODO: Find actual angle
		addSequential(new IntakeBoulder(5, -1)); // TODO: find actual speed/time

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
