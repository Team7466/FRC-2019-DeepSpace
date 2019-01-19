package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MotorTestCommand;

public class MotorTestSystem extends Subsystem {

    public void initDefaultCommand() {
        setDefaultCommand(new MotorTestCommand(0));
    }
    public void move(double x){
        RobotMap.motortest.set(x);
    }
}
