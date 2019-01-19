package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.MotorTestSystem;
public class MotorTestCommand extends Command {
    double x;
    public MotorTestCommand(double x) {
        requires(Robot.motorTestSystem);
        this.x = x;

    }
    protected void initialize() { }

    @Override
    protected void execute() {
        Robot.motorTestSystem.move(x);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.motorTestSystem.move(0);
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}