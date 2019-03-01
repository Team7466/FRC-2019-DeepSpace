package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
public class ReverseSystem extends Subsystem {

    public static void reversegoback(){
        RobotMap.reversemotor1.set(-1);    
        RobotMap.reversemotor2.set(-1);    
    }

    public static void reversegofront(){                                                                                                                                                                                                                                                                                                
        RobotMap.reversemotor1.set(1);
        RobotMap.reversemotor2.set(1);
        }
    public static void reversedefaultcommand(){
        RobotMap.reversemotor1.set(0);
        RobotMap.reversemotor2.set(0);

    }
    public void initDefaultCommand() {
        setDefaultCommand(new ReverseGoBackCommand());
        setDefaultCommand(new ReverseGoFrontCommand());
    }                                                                                   
}