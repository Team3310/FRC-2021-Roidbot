package frc.robot.auto;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class BluePathB extends SequentialCommandGroup {

    public BluePathB(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {

        Trajectory trajectory = RobotContainer.loadPathTrajectory("output/BluePathB.wpilib.json");

        addCommands(
                new InstantCommand(() -> intakeSubsystem.setRollerSpeed(1)),
                new InitializeTrajectory(driveSubsystem, trajectory),
                RobotContainer.getSwerveTrajectoryCommand(driveSubsystem, trajectory),
                new StopTrajectory(driveSubsystem)
        );
    }


}
