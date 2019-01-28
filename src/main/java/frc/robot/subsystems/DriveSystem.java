package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
    public static boolean running;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    public void drive(double x, double y) {
        RobotMap._diffDrive.tankDrive(x, y);
    }

    public void drivefunc(Joystick joy, double mult) {
        drive(joy.getRawAxis(1) * -mult, joy.getRawAxis(5) * -mult);
    }
}