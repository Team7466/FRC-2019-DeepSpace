package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.Constants;
import frc.robot.OI;

public class DriveCommand extends Command {
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivesystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run

    protected void execute() {
        Robot.drivesystem.drivefunc(OI.xbox, Constants.drive_speed);
    }

    // Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true

    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run

    protected void interrupted() {

    }
}