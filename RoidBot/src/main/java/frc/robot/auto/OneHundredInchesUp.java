package frc.robot.auto;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class OneHundredInchesUp extends SequentialCommandGroup {

    public OneHundredInchesUp(DriveSubsystem driveSubsystem) {

        Trajectory trajectory = RobotContainer.loadPathTrajectory("output/100inchesUp.wpilib.json");

        addCommands(
                new InstantCommand(() -> driveSubsystem.resetEncoders()),
                new InstantCommand(() -> driveSubsystem.resetHeading()),
                new InitializeTrajectory(driveSubsystem, trajectory),
                RobotContainer.getSwerveTrajectoryCommand(driveSubsystem, trajectory),
                new StopTrajectory(driveSubsystem)
        );
    }

}
