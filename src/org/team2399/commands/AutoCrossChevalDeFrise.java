package org.team2399.commands;

import org.team2399.Utility;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossChevalDeFrise extends CommandGroup {
    
    public  AutoCrossChevalDeFrise() {
    	
    	//TODO check values
    	addSequential(new AnglePitch(15));
    	addSequential(new AnglePitch(-30));
    	addSequential(new DriveAtAngleDistance(0, Utility.feetToInches(1.25)));
    	addParallel(new AnglePitch(70));
    	addSequential(new DriveAtAngleDistance(0, Utility.feetToInches(1)));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
