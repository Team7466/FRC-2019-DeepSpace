
package frc.robot.commands;
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.FollowPathCommand;
import frc.robot.constants.Constants;
public class AutonomousCommandGroup extends CommandGroup {

  public AutonomousCommandGroup() {
     addSequential(new FollowPathCommand());
     //Constants.Pathname = "left";
     //example code
  }
}
