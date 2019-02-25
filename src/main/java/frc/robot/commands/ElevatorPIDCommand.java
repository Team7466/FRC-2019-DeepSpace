package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ElevatorPIDCommand extends Command {
    double x;
    public ElevatorPIDCommand(double x) {
      this.x=x;
      requires(Robot.elevatorsystempid);
    }

    @Override
    protected void initialize() {
        Robot.elevatorsystempid.enable();
    }

    @Override
    protected void execute() {
        double tour = x;
        double setpoint = 360*tour;
        Robot.elevatorsystempid.setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        Timer.delay(1);
            if (RobotMap.elevatorencoder.getStopped()){
            return true;
        }
        else {
            return false;
        }

        }

    @Override
    protected void end() {
        Robot.elevatorsystempid.disable();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}