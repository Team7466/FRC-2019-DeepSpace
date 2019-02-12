package frc.robot;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.InvertType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.PneumaticsSystem;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot {
    public static PneumaticsSystem pneumaticsSystem;
    public static OI oi;
    public static DriveSystem drivesystem;
    private static final int k_ticks_per_rev = 1024;
  private static final double k_wheel_diameter = 4.0 / 12.0;
  private static final double k_max_velocity = 10;

  private static final int k_left_channel = 0;
  private static final int k_right_channel = 1;

  private static final int k_left_encoder_port_a = 0;
  private static final int k_left_encoder_port_b = 1;
  private static final int k_right_encoder_port_a = 2;
  private static final int k_right_encoder_port_b = 3;

  private static final int k_gyro_port = 0;

  private static final String k_path_name = "example";

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.leftfollower.configFactoryDefault();
        RobotMap.leftmotor.configFactoryDefault();
        RobotMap.rightfollower.configFactoryDefault();
        RobotMap.rightmotor.configFactoryDefault();
        RobotMap.Compressor1.setClosedLoopControl(true);
        RobotMap.rightfollower.follow(RobotMap.rightmotor);
        RobotMap.leftfollower.follow(RobotMap.leftmotor);
        // ********
        RobotMap.leftmotor.setInverted(false);
        RobotMap.rightmotor.setInverted(true);
        RobotMap.rightfollower.setInverted(InvertType.FollowMaster);
        RobotMap.leftfollower.setInverted(InvertType.FollowMaster);
        RobotMap._diffDrive.setRightSideInverted(false);
        // ********

        SmartDashboard.putNumber("Z ekseni", OI.extreme.getTwist());
        pneumaticsSystem = new PneumaticsSystem();
        drivesystem = new DriveSystem();
        oi = new OI();
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
        return;
        // new AutonomousCommand().start();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
         * switch(autoSelected) { case "My Auto": autonomousCommand = new
         * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
         * ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        Trajectory left_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".left");
        Trajectory right_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".right");
    
        RobotMap.leftfollower = new EncoderFollower(left_trajectory);
        RobotMap.rightfollower = new EncoderFollower(right_trajectory);
    
        RobotMap.leftfollower.configureEncoder(RobotMap.leftencoder.get(), k_ticks_per_rev, k_wheel_diameter);
        // You must tune the PID values on the following line!
        RobotMap.leftfollower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);
        //Alt satırlarda CTRE için bulduğum kütüphaneler var.
          //RobotMap.leftfollower.config_kF(0, 1);
         //RobotMap.leftfollower.config_kP(0, 0);
        //RobotMap.leftfollower.config_kI(0, 0);
       //RobotMap.leftfollower.config_kD(0, 0);
        RobotMap.rightfollower.configureEncoder(RobotMap.rightencoder.get(), k_ticks_per_rev, k_wheel_diameter);
        // You must tune the PID values on the following line!
        RobotMap.rightfollower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);
        
        RobotMap.followernotifier = new Notifier(DriveSystem.followpa);
        RobotMap.followernotifier.startPeriodic(left_trajectory.get(0).dt);
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().run();
        RobotMap.followernotifier.stop();
        RobotMap.leftmotor.set(0);
        RobotMap.rightmotor.set(0);
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        // SmartDashboard.putNumber("Pov",OI.primary.getPOV());
    }

    @Override
    public void testPeriodic() {
    }
}