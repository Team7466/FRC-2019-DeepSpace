package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CompressorSwitchCommand extends Command {
	
	public CompressorSwitchCommand() {
		requires(Robot.hatchsystem);
	}
	protected void initialize() {
	
	}
	protected void execute() {
		if(Robot.compressorSwitchFlag  == 0) {
			RobotMap.compressor.setClosedLoopControl(false);
			Robot.compressorSwitchFlag = 1;
		}
		else {
			RobotMap.compressor.setClosedLoopControl(true);
			Robot.compressorSwitchFlag = 0;
		}
	}
	protected boolean isFinished() {
        return true;
    }
	 protected void end() 
	    {
	    	// Robot.hatchsystem.Off();
	    }
	 protected void interrupted() {
	    	end();
	    }
	}