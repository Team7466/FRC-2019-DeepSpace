package frc.robot.subsystems;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import jaci.pathfinder.Pathfinder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    public void drive(double x, double y) {
        RobotMap.candrive.tankDrive(x, y);
    }

    public void drivefunc(Joystick joy, double speed) {
        drive(joy.getRawAxis(1) * -speed, joy.getRawAxis(5) * -speed);
    }
    public void followPath() {
        Notifier followernotifier = new Notifier(this::followPath);
        if (RobotMap.leftencoderfollower.isFinished() || RobotMap.rightencoderfollower.isFinished()) {
            followernotifier.stop();
        } else {
          double leftspeed = RobotMap.leftencoderfollower.calculate(RobotMap.leftencoder.get());
          double rightspeed = RobotMap.rightencoderfollower.calculate(RobotMap.rightencoder.get());
          double heading = Robot.gyro.getAngle();
          double desired_heading = Pathfinder.r2d(RobotMap.leftencoderfollower.getHeading());
          double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
          double turn =  0.8 * (-1.0/80.0) * heading_difference;
          RobotMap.leftmotor.set(leftspeed + turn);
          RobotMap.rightmotor.set(rightspeed - turn);

}
}
}
      
