package frc.robot.constants;

public class Constants {

    public static final double drive_speed = 0.6;

    public static final int k_ticks_per_rev = 1024;
    public static final double k_wheel_diameter = 4.0 / 12.0;
    public static final double k_max_velocity = 10;
  
    public static final String k_path_name = "Test";

    /*PID Values*/

    //Elevator
    public static final double Elevator_P = 0.1;
    public static final double Elevator_I = 0.1;
    public static final double Elevator_D = 0.1;
    //Reverse
    public static final double Reverse_P = 0.1;
    public static final double Reverse_I = 0.1;
    public static final double Reverse_D = 0.1;
    
    //Claw
    public static final double Claw_P = 0.1;
    public static final double Claw_I = 0.1;
    public static final double Claw_D = 0.1;
}