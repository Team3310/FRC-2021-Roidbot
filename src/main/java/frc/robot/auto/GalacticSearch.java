package frc.robot.auto;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class GalacticSearch extends SequentialCommandGroup {
    private Preferences prefs;
    private int pathToRun;

    public GalacticSearch(DriveSubsystem drive, IntakeSubsystem intake){
        prefs = Preferences.getInstance();
        pathToRun = prefs.getInt("Path", 4);

        Trajectory RedPathA = RobotContainer.loadPathTrajectory("output/RedPathA.wpilib.json");
        Trajectory BluePathA = RobotContainer.loadPathTrajectory("output/BluePathA.wpilib.json");
        Trajectory RedPathB = RobotContainer.loadPathTrajectory("output/RedPathB.wpilib.json");
        Trajectory BluePathB = RobotContainer.loadPathTrajectory("output/BluePathB.wpilib.json");

        switch (pathToRun) {
            case 0:
                addCommands(
                        new InitializeTrajectory(drive, RedPathA),
                        RobotContainer.getSwerveTrajectoryCommand(drive, RedPathA),
                        new StopTrajectory(drive)
                );

            case 1:
                addCommands(
                        new InitializeTrajectory(drive, RedPathB),
                        RobotContainer.getSwerveTrajectoryCommand(drive, RedPathB),
                        new StopTrajectory(drive)
                );

            case 2:
                addCommands(
                        new InitializeTrajectory(drive, BluePathA),
                        RobotContainer.getSwerveTrajectoryCommand(drive, BluePathB),
                        new StopTrajectory(drive)
                );

            case 3:
                addCommands(
                        new InitializeTrajectory(drive, BluePathB),
                        RobotContainer.getSwerveTrajectoryCommand(drive, BluePathB),
                        new StopTrajectory(drive)
                );

            case 4:
                System.out.println("You messed up");
        }
    }
}
