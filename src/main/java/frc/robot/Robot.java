package frc.robot;
import frc.robot.RobotMap;
import frc.robot.constants.Constants;
import frc.robot.libs.Gyro;
import com.ctre.phoenix.motorcontrol.InvertType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.HatchSystem;
import frc.robot.subsystems.LedControlSystem;
import frc.robot.subsystems.ReverseSystem;
import frc.robot.subsystems.ReverseSystemPID;
import frc.robot.subsystems.ElevatorSystemPID;
import frc.robot.subsystems.GripperClawPID;
import frc.robot.subsystems.GripperSystem;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Notifier;


// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot {
    SendableChooser autoChooser;
    SendableChooser<Command> chooser = new SendableChooser<>();
    public static OI oi;

    //Manuel Systems
    public static DriveSystem drivesystem;
    public static HatchSystem hatchsystem;
    public static GripperSystem grippersystem;
    public static ReverseSystem reversesystem;


    //PID Systems
    public static ElevatorSystemPID elevatorsystempid;
    public static ReverseSystemPID reversesystempid;
    public static GripperClawPID gripperclawpid;
    
    //Sensors
    public static Gyro gyro;
    public static LedControlSystem ledcontrolsystem;
    public static int compressorSwitchFlag = 0;

    @Override
    public void robotInit() {
        CameraServer.getInstance().startAutomaticCapture();
        RobotMap.leftfollower.configFactoryDefault();
        RobotMap.leftmotor.configFactoryDefault();
        RobotMap.rightfollower.configFactoryDefault();
        RobotMap.rightmotor.configFactoryDefault();
        RobotMap.compressor.setClosedLoopControl(true);
        RobotMap.rightfollower.follow(RobotMap.rightmotor);
        RobotMap.leftfollower.follow(RobotMap.leftmotor);
        RobotMap.leftmotor.setInverted(false);
        RobotMap.rightmotor.setInverted(true);
        RobotMap.rightfollower.setInverted(InvertType.FollowMaster);
        RobotMap.leftfollower.setInverted(InvertType.FollowMaster);
        RobotMap.candrive.setRightSideInverted(false);

        oi = new OI();
        hatchsystem = new HatchSystem();
        drivesystem = new DriveSystem();
        grippersystem = new GripperSystem();
        reversesystem = new ReverseSystem();

        elevatorsystempid = new ElevatorSystemPID();
        reversesystempid = new ReverseSystemPID();
        gripperclawpid = new GripperClawPID();

        ledcontrolsystem = new LedControlSystem();
        gyro = new Gyro();


        //Reverse Encoder Code
        RobotMap.reverseencoder.setMaxPeriod(.1);
        RobotMap.reverseencoder.setMinRate(300);
        RobotMap.reverseencoder.setReverseDirection(true);
        RobotMap.reverseencoder.setSamplesToAverage(7);
        RobotMap.reverseencoder.setDistancePerPulse(0.62931);

        //


        
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
       Notifier followernotifier = new Notifier(drivesystem::followPath);

       RobotMap.leftencoderfollower.configureEncoder(RobotMap.leftencoder.get(), Constants.k_ticks_per_rev,  Constants.k_wheel_diameter);
       // You must tune the PID values on the following line!
       RobotMap.leftencoderfollower.configurePIDVA(1.0, 0.0, 0.0, 1 / Constants.k_max_velocity, 0);

       RobotMap.rightencoderfollower.configureEncoder(RobotMap.rightencoder.get(), Constants.k_ticks_per_rev, Constants.k_wheel_diameter);
       // You must tune the PID values on the following line!
       RobotMap.rightencoderfollower.configurePIDVA(1.0, 0.0, 0.0, 1 / Constants.k_max_velocity, 0);

       followernotifier.startPeriodic(RobotMap.left.get(0).dt);


       
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Notifier followernotifier = new Notifier(drivesystem::followPath);
        Scheduler.getInstance().run();
        followernotifier.stop();
        RobotMap.leftmotor.set(0);
        RobotMap.rightmotor.set(0);
        gyro.zeroGyro();
        gyro.updateGyro();
        gyro.setRotation(0);

        //double yawAngle = gyro.getAngle();

        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        gyro.updateGyro();
        SmartDashboard.putNumber("Rotation", gyro.getRotation());
        SmartDashboard.putNumber("Angle", gyro.getAngle());
        }

    @Override
    public void testPeriodic() {
    }
}