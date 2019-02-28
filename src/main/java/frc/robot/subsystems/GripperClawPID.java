package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.constants.Constants;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GripperClawPID extends PIDSubsystem {

    public GripperClawPID() {
        super("Gripper Claw PID",Constants.Reverse_P, Constants.Reverse_I, Constants.Reverse_D);
        setAbsoluteTolerance(0.01);
        getPIDController().setContinuous(false);
        enable();
    }


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }


    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return RobotMap.clawcounter.getDistance();
    }


    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        RobotMap.clawmotor.pidWrite(-output);
    }
}