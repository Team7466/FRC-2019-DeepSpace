package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
public class GripperSystem extends Subsystem {

    public static void intakeout(){
        RobotMap.leftintakemotor.set(-1);
        RobotMap.rightintakemotor.set(1);
    }

    public static void intakein(){
        RobotMap.leftintakemotor.set(1);
        RobotMap.rightintakemotor.set(-1);
    }
    public static void intakedefaultcommand(){
        RobotMap.leftintakemotor.set(0);
        RobotMap.rightintakemotor.set(0);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new GripperIntakeInCommand());
        setDefaultCommand(new GripperIntakeOutCommand());

    }
}