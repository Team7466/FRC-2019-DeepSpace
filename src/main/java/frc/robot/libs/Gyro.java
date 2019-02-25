package frc.robot.libs;
import frc.robot.RobotMap;

public class Gyro 
{
	private double angle = 0; // The accumulated degrees from the get rotations per second function
	private double rotation = 0; // The degrees of the blue gyro
	private double rotatedAmount = 0;		
	public double getAngle () 
	{
		return -angle;
    }
    
    public double getRotation() 
    {
        return rotation;
    }
    
    public void setAngle(double angleToSet) 
    {
        angle = angleToSet;
    }

    public void setRotation(double rotationToSet) 
    {
        rotation = rotationToSet;
    }

	public void zeroGyro () 
	{
        setAngle(0);
    }

    public Gyro() 
    { 
    	// Main constructor
       	setupGyro();
    }

    private void setupGyro()
    {
		RobotMap.gyro.write(0x6B, 0x00); // Power Config
		RobotMap.gyro.write(0x1A, 0x23); // Basic Config
		RobotMap.gyro.write(0x1B, 0x00); // Gyro Config
		RobotMap.gyro.write(0x38, 0x11); // Interrupt Config
		RobotMap.gyro.write(0x23, 0x10); // FIFO Config
		RobotMap.gyro.write(0x6A, 0x40); // User Control (Disable FIFO)
		RobotMap.gyro.write(0x6A, 0x04); // User Control (Reset FIFO)
		RobotMap.gyro.write(0x6A, 0x40); // User Control (Turn FIFO back on);
        RobotMap.gyro.write(0x19, 0x04); // Set sample rate to 200Hz    
    }

    private int uByteToInt (byte number) 
    	{
		int iNumber = number & 0b01111111;
		
		if (number < 0) {
			iNumber += 128;
		}
		
		return iNumber;
    }
    
    public void updateGyro() 
    {

    	updateGyroFromSensor();

    }

    public boolean updateGyroFromSensor() {
 		byte[] dataReady = new byte[1];
		 RobotMap.gyro.read(0x3A, 1, dataReady);
		
		if ((dataReady[0] & 0x00000001) > 0) {
			byte[] angleByte = new byte[2];
			RobotMap.gyro.read(0x43, 2, angleByte);
			int highOrder = (int) angleByte[0];
			int lowOrder = uByteToInt(angleByte[1]);
            
			int rawRotation = (highOrder << 8) + lowOrder;
			
            rotation = (rawRotation / 131.0); 
            rotatedAmount = rotation*0.02; // 20ms constant loop, 131 is gyro scale factor
            if (rotatedAmount > 0.055 || rotatedAmount < -0.055) { // Filter out noise
                angle += rotatedAmount; // angle in degrees
                
            }
            return true; // Succesfully read from sensor     
        }
        return false; // Failed to read from sensor
    }
}