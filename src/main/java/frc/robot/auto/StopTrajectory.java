package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class StopTrajectory extends CommandBase {
    private DriveSubsystem robotDrive;

    public StopTrajectory(DriveSubsystem robotDrive) {
        this.robotDrive = robotDrive;
    }

    @Override
    public void initialize() {
        System.out.println("Stopping Trajectory");
//        robotDrive.drive(0, 0, 0, false);
        robotDrive.setWheelSpeed(0.0);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
