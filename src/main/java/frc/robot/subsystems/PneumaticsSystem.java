package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
public class PneumaticsSystem extends Subsystem {
    public static boolean running;

    public static void solenoidExpand(){
        RobotMap.Valf.set(DoubleSolenoid.Value.kForward);
    }

    public static void solenoidRetract(){
        RobotMap.Valf.set(DoubleSolenoid.Value.kReverse);
    }

    public static void solenoidOff(){

        RobotMap.Valf.set(DoubleSolenoid.Value.kOff);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new SolenoidDefaultCommand());
    }
}