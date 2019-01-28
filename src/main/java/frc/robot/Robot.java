/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.PneumaticsSystem;
import frc.robot.subsystems.DriveSystem;

// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot {
    public static PneumaticsSystem pneumaticsSystem;
    public static OI oi;
    public static DriveSystem drivesystem;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.leftfollower.configFactoryDefault();
        RobotMap.leftmotor1.configFactoryDefault();
        RobotMap.rightfollower.configFactoryDefault();
        RobotMap.rightmotor1.configFactoryDefault();
        RobotMap.Compressor1.setClosedLoopControl(true);
        RobotMap.rightfollower.follow(RobotMap.rightmotor1);
        RobotMap.leftfollower.follow(RobotMap.leftmotor1);
        // alttaki 5 satır değişebilir
        // ********
        RobotMap.leftmotor1.setInverted(false);
        RobotMap.rightmotor1.setInverted(true);
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
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().run();
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