package frc.robot;
import edu.wpi.first.wpilibj.*;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    public static SpeedController motortest = new PWMVictorSPX(6);

    //Pnömatik Sistem
    public static DoubleSolenoid Valf = new DoubleSolenoid(2,3);
    public static Compressor Compressor1 = new Compressor(1);
}