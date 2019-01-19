package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.PneumaticsSystem;
public class SolenoidDefaultCommand extends Command {

    public SolenoidDefaultCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(Robot.pneumaticsSystem);
    }

    // Called just before this Command runs the first time

    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run

    protected void execute() {
        PneumaticsSystem.solenoidOff();

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