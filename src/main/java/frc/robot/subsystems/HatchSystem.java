package frc.robot.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
public class HatchSystem extends Subsystem {

    public static void solenoidExpand(){
        RobotMap.pushvalf.set(DoubleSolenoid.Value.kForward);
    }

    public static void solenoidRetract(){
        RobotMap.pushvalf.set(DoubleSolenoid.Value.kReverse);
    }

    public static void solenoidOff(){

        RobotMap.pushvalf.set(DoubleSolenoid.Value.kOff);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        RobotMap.pushvalf.set(DoubleSolenoid.Value.kOff);
    }
}