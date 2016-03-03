package org.team2399.commands;

import org.team2399.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootFromPositionThree extends CommandGroup
{

	public AutoShootFromPositionThree()
	{
		addSequential(new DriveAtAngleDistance(0, 9)); // TODO: Find actual
														// distance
		addSequential(new DriveAngle(45)); // TODO: Find actual angle
		addSequential(new AutoIntakeBoulder(RobotMap.OUTTAKE_SPEED, 5));
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
