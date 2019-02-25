/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/*
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Birinci Joystick Tanımlamalarısss
    public static Joystick xbox = new Joystick(0);
    Button A1 = new JoystickButton(xbox, 1);
    Button B1 = new JoystickButton(xbox, 2);
    Button X1 = new JoystickButton(xbox, 3);
    Button Y1 = new JoystickButton(xbox, 4);
    Button LB1 = new JoystickButton(xbox, 5);
    Button RB1 = new JoystickButton(xbox, 6);
    Button BCK1 = new JoystickButton(xbox, 7);
    Button SRT1 = new JoystickButton(xbox, 8);
    Button PRSL1 = new JoystickButton(xbox, 9);
    Button PRSR1 = new JoystickButton(xbox, 10);

    // İkinci Joystick Tanımlamaları
    public static Joystick extreme = new Joystick(0);
    Button Trigger = new JoystickButton(extreme, 1);
    Button Two = new JoystickButton(extreme, 2);
    Button Tree = new JoystickButton(extreme, 3);
    Button Four = new JoystickButton(extreme, 4);
    Button Five = new JoystickButton(extreme, 5);
    Button Six = new JoystickButton(extreme, 6);
    Button Seven = new JoystickButton(extreme, 7);
    Button Eight = new JoystickButton(extreme, 8);
    Button Nine = new JoystickButton(extreme, 9);
    Button Ten = new JoystickButton(extreme, 10);
    Button Eleven = new JoystickButton(extreme, 11);
    Button Twelfe = new JoystickButton(extreme, 12);

    OI() {

        
    }
}