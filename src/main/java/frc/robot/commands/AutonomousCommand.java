package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
public class AutonomousCommand extends Command {

    public AutonomousCommand() {
    requires(Robot.drivesystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    //Robot.drivesystem.followPath();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    RobotMap.leftmotor.set(0);
    RobotMap.rightmotor.set(0);
    }

    protected void interrupted() {
    	end();
    }
}

