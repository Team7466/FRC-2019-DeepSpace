package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */ 
public class RobotMap {
    public static Encoder leftencoder = new Encoder(2, 3);
    public static Encoder rightencoder = new Encoder(4, 5);
    public static AnalogGyro gyro =new AnalogGyro(0);
    public static Notifier followernotifier;
    public static WPI_VictorSPX leftfollower = new WPI_VictorSPX(2);
    public static WPI_VictorSPX leftmotor = new WPI_VictorSPX(1);
    public static WPI_VictorSPX rightfollower = new WPI_VictorSPX(3);
    public static WPI_VictorSPX rightmotor = new WPI_VictorSPX(4);
    public static DifferentialDrive _diffDrive = new DifferentialDrive(leftmotor, rightmotor);
    // Pnömatik Sistem
    public static DoubleSolenoid Valf = new DoubleSolenoid(2, 3);
    public static Compressor Compressor1 = new Compressor(1);
    //public static leftfollower = new leftencoder(left_trajectory);
    //public static rightfollower = new rightencoder(right_trajectory);
}