package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class LedControlSystem extends Subsystem {

    public void initDefaultCommand() {
        RobotMap.arduino.writeString("2");

    }
    public void changeMode (String x){
        RobotMap.arduino.writeString(x);
    }
}
