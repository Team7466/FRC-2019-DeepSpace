package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HatchSystem;

public class HatchRetractCommand extends Command {

    public HatchRetractCommand() {
        requires(Robot.hatchsystem);
    }
    protected void initialize() {
    }

    protected void execute() {
        HatchSystem.solenoidRetract();
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        HatchSystem.solenoidOff();
    }
    protected void interrupted() {
        HatchSystem.solenoidOff();
    }
}