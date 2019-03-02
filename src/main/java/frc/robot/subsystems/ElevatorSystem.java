package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
public class ElevatorSystem extends Subsystem {

    public static void elevatorup(){
        RobotMap.elevatormotor1.set(1);
        RobotMap.elevatormotor2.set(1);
        RobotMap.elevatormotor3.set(1);
    }

    public static void elevatordown(){
        RobotMap.elevatormotor1.set(-1);
        RobotMap.elevatormotor2.set(-1);
        RobotMap.elevatormotor3.set(-1);
    }

    public static void elevatordefaultcommand(){
        RobotMap.elevatormotor1.set(0);
        RobotMap.elevatormotor2.set(0);
        RobotMap.elevatormotor3.set(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorManuelUp());
        setDefaultCommand(new ElevatorManuelDown());
    }
    
}