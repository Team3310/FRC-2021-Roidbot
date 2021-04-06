package frc.robot.auto;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class GalacticSearch extends SequentialCommandGroup {
    private Preferences prefs;
    private String pathToRun;

    public GalacticSearch(DriveSubsystem drive, IntakeSubsystem intakeSubsystem) {
        prefs = Preferences.getInstance();
        pathToRun = prefs.getString("Path", "A");

        Trajectory BluePathA = RobotContainer.loadPathTrajectory("output/BluePathA.wpilib.json");
        Trajectory BluePathB = RobotContainer.loadPathTrajectory("output/BluePathB.wpilib.json");

        switch (pathToRun) {
            case "A":
                addCommands(
                        new InstantCommand(() -> intakeSubsystem.setRollerSpeed(1)),
                        new InitializeTrajectory(drive, BluePathA),
                        RobotContainer.getSwerveTrajectoryCommand(drive, BluePathA),
                        new StopTrajectory(drive)
                );


            case "B":
                addCommands(
                        new InstantCommand(() -> intakeSubsystem.setRollerSpeed(1)),
                        new InitializeTrajectory(drive, BluePathB),
                        RobotContainer.getSwerveTrajectoryCommand(drive, BluePathB),
                        new StopTrajectory(drive)
                );
                prefs.putString("Path", "A");
        }
    }
}
