package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
public class RobotMap {

    //Pathfinder Configuration
    public static Trajectory left;
    public static Trajectory right;
    public static EncoderFollower leftencoderfollower;
    public static EncoderFollower rightencoderfollower;
    public static SerialPort arduino = new SerialPort(9600,SerialPort.Port.kUSB1); 

    //Encoders Sensors&Other Usefull Devices
    public static Counter clawcounter = new Counter(new DigitalInput(5));
    public static I2C gyro = new I2C(I2C.Port.kOnboard, 0x68);
    public static Encoder reverseencoder = new Encoder(6, 7);
    public static Encoder elevatorencoder = new Encoder(1, 2);
    
    //Drive System Motors
    public static Encoder leftencoder = new Encoder(8,9);
    public static Encoder rightencoder = new Encoder(10, 11);
    public static WPI_VictorSPX leftmotor = new WPI_VictorSPX(1);
    public static WPI_VictorSPX leftfollower = new WPI_VictorSPX(2);
    public static WPI_VictorSPX rightmotor = new WPI_VictorSPX(9);
    public static WPI_VictorSPX rightfollower = new WPI_VictorSPX(4);
    public static WPI_VictorSPX elevatormotor = new WPI_VictorSPX(5);
    public static DifferentialDrive candrive = new DifferentialDrive(leftmotor, rightmotor);
    
    //Cargo System Motors
    public static WPI_VictorSPX rightintakemotor = new WPI_VictorSPX(6);
    public static WPI_VictorSPX leftintakemotor = new WPI_VictorSPX(7);
    public static WPI_VictorSPX clawmotor = new WPI_VictorSPX(8);
    public static WPI_VictorSPX reversemotor1 =new WPI_VictorSPX(3);
    public static WPI_VictorSPX reversemotor2 =new WPI_VictorSPX(10);

    //Pneumatic System
    public static DoubleSolenoid pushvalf = new DoubleSolenoid(2, 3);//Define the system to be used for hatch push
    public static Compressor compressor = new Compressor(1);

    static{
        try {
            left = PathfinderFRC.getTrajectory("Test"+".left");
            right = PathfinderFRC.getTrajectory("Test"+".right");
            leftencoderfollower= new EncoderFollower(left);
            rightencoderfollower = new EncoderFollower(right);
        } catch (Exception e) {
            System.out.println("Can't find path.");
            e.printStackTrace();
        }
        try{
           // arduino = new SerialPort(9600,SerialPort.Port.kUSB2);
        }
        catch(Exception e){
        System.out.println("Arduino not connected.");
        e.printStackTrace();
        }
    }
}