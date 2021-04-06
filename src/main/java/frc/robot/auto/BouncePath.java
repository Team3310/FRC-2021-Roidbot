package frc.robot.auto;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class BouncePath extends SequentialCommandGroup {

    Trajectory trajectory = RobotContainer.loadPathTrajectory("output/bouncePath.wpilib.json");

    public BouncePath(DriveSubsystem robotDrive){
        addCommands(
                new InitializeTrajectory(robotDrive, trajectory),
                RobotContainer.getSwerveTrajectoryCommand(robotDrive, trajectory),
                new StopTrajectory(robotDrive)
        );
    }
}
