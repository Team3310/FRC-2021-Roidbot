package frc.robot.auto;

<<<<<<< Updated upstream
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
=======
>>>>>>> Stashed changes
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class BouncePath extends SequentialCommandGroup {

<<<<<<< Updated upstream
    Trajectory trajectory = RobotContainer.loadPathTrajectory("output/bouncePath.wpilib.json");
=======
    public BouncePath(DriveSubsystem robotDrive){
        Trajectory trajectory = RobotContainer.loadPathTrajectory("output/bouncePath.wpilib.json");
>>>>>>> Stashed changes

    public BouncePath(DriveSubsystem robotDrive){
        addCommands(
                new InitializeTrajectory(robotDrive, trajectory),
                RobotContainer.getSwerveTrajectoryCommand(robotDrive, trajectory),
<<<<<<< Updated upstream
                new StopTrajectory(robotDrive)
        );
=======
                new StopTrajectory(robotDrive));
>>>>>>> Stashed changes
    }
}
