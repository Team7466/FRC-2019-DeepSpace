package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HatchSystem;
/**
 *
 */
public class HatchPushCommand extends Command {

    public HatchPushCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.hatchsystem);
    }

    // Called just before this Command runs the first time

    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run

    protected void execute() {
        HatchSystem.solenoidExpand();
    }

    // Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true

    protected void end() {
        HatchSystem.solenoidOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run

    protected void interrupted() {
        HatchSystem.solenoidOff();
    }
}