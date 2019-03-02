package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class LedControlSystem extends Subsystem {

    public void initDefaultCommand() {
    }
    public void changeMode (String x){
        RobotMap.arduino.writeString(x);
    }
}
