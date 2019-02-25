package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ReversePIDCommand extends Command {
    double x;
    public ReversePIDCommand(double x) {
      this.x=x;
      requires(Robot.reversesystempid);
    }

    @Override
    protected void initialize() {
        Robot.reversesystempid.enable();
    }

    @Override
    protected void execute() {
        double tour = x;
        double setpoint = 360*tour;
        Robot.reversesystempid.setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        Timer.delay(1);
            if (RobotMap.reverseencoder.getStopped()){
            return true;
        }
        else {
            return false;
        }

        }

    @Override
    protected void end() {
        Robot.reversesystempid.disable();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}