package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import jaci.pathfinder.Pathfinder;
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
    private void followPath() {
        if (RobotMap.leftfollower.isFinished() || RobotMap.rightfollower.isFinished()) {
          RobotMap.followernotifier.stop();
        } else {
          double left_speed = RobotMap.leftfollower.calculate(RobotMap.leftencoder.get());
          double right_speed = RobotMap.rightfollower.calculate(RobotMap.rightencoder.get());
          double heading = RobotMap.gyro.getAngle();
          double desired_heading = Pathfinder.r2d(RobotMap.leftfollower.getHeading());
          double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
          double turn =  0.8 * (-1.0/80.0) * heading_difference;
          RobotMap.leftfollower.set(left_speed + turn);
          RobotMap.rightfollower.set(right_speed - turn);
        }
      }
}