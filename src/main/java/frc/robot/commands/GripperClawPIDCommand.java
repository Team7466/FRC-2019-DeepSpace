package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class GripperClawPIDCommand extends Command {
    double x;
    public GripperClawPIDCommand(double x) {
      this.x=x;
      requires(Robot.gripperclawpid);
    }


    @Override
    protected void initialize() {
        Robot.gripperclawpid.enable();
    }

    @Override
    protected void execute() {
        double tour = x;
        double setpoint = 348*tour;
        Robot.elevatorsystempid.setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        Timer.delay(1);
        if (RobotMap.clawcounter.getStopped()){
        return true;
    }
    else {
        return false;
    }    }

    @Override
    protected void end() {
        Robot.gripperclawpid.disable();
    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}