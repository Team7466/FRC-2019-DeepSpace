package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
// 
public class RobotMap {
    public static WPI_VictorSPX leftfollower = new WPI_VictorSPX(2);
    public static WPI_VictorSPX leftmotor1 = new WPI_VictorSPX(1);
    public static WPI_VictorSPX rightfollower = new WPI_VictorSPX(3);
    public static WPI_VictorSPX rightmotor1 = new WPI_VictorSPX(4);
    public static DifferentialDrive _diffDrive = new DifferentialDrive(leftmotor1, rightmotor1);
    // Pnömatik Sistem
    public static DoubleSolenoid Valf = new DoubleSolenoid(2, 3);
    public static Compressor Compressor1 = new Compressor(1);
}