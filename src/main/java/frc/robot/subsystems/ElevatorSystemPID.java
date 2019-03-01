package frc.robot.subsystems;
import frc.robot.constants.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

public class ElevatorSystemPID extends PIDSubsystem {

  public ElevatorSystemPID() {
      super("Elevator Encoder",Constants.Elevator_P,Constants.Elevator_I, Constants.Elevator_D);
      setAbsoluteTolerance(0.1);
      getPIDController().setContinuous(false);
      // enable() - Enables the PID controller.
  }


  public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
  }


  protected double returnPIDInput() {
      // Return your input value for the PID loop
      // e.g. a sensor, like a potentiometer:
      // yourPot.getAverageVoltage() / kYourMaxVoltage;
      return RobotMap.elevatorencoder.getDistance();
  }


  protected void usePIDOutput(double output) {
      // Use output to drive your system, like a motor
      // e.g. yourMotor.set(output);
      RobotMap.elevatormotor1.pidWrite(output);
      RobotMap.elevatormotor2.pidWrite(output);
      RobotMap.elevatormotor3.pidWrite(output);
      }
}