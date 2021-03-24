// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {

    public static final double absoluteTurnZeroDegRightFront = 254.1;
    public static final double absoluteTurnZeroDegLeftFront = 256.3;
    public static final double absoluteTurnZeroDegRightRear = 136.5 ;
    public static final double absoluteTurnZeroDegLeftRear = 69.5;

    public static final int kFrontLeftDriveMotorMasterPort = 14;
    public static final int kFrontLeftDriveMotorSlavePort = 14;
    public static final int kRearLeftDriveMotorMasterPort = 15;
    public static final int kRearLeftDriveMotorSlavePort = 15;
    public static final int kFrontRightDriveMotorMasterPort = 1;
    public static final int kFrontRightDriveMotorSlavePort = 1;
    public static final int kRearRightDriveMotorMasterPort = 0;
    public static final int kRearRightDriveMotorSlavePort = 0;

    public static final int kFrontLeftTurningMotorPort = 10;
    public static final int kRearLeftTurningMotorPort = 11;
    public static final int kFrontRightTurningMotorPort = 5;
    public static final int kRearRightTurningMotorPort = 4;

    public static final int kFrontLeftCanCoderPort = 2;
    public static final int kRearLeftCanCoderPort = 3;
    public static final int kFrontRightCanCoderPort = 1;
    public static final int kRearRightCanCoderPort = 0;

    public static final int kGyroPort = 16;

    public static final double TURN_OUTPUT_TO_ENCODER_RATIO = 1;//12.8;
    public static final double DRIVE_OUTPUT_TO_ENCODER_RATIO = 8.16;
    public static final double DRIVE_ENCODER_TICKS_PER_MOTOR_REVOLUTION = 2048.0;
    public static final double TURN_ENCODER_TICKS_PER_MOTOR_REVOLUTION = 4096.0;
    public static final double kWheelDiameterInches = 3.89;

    // Distance between centers of right and left wheels on robot
    public static final double kTrackWidth = 0.34;

    // Distance between front and back wheels on robot
    public static final double kWheelBase = 0.34;

    public static final SwerveDriveKinematics kDriveKinematics =
        new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
    // These characterization values MUST be determined either experimentally or theoretically
    // for *your* robot's drive.
    // The RobotPy Characterization Toolsuite provides a convenient tool for obtaining these
    // values for your robot.
    public static final double ksVolts = 1;
    public static final double kvVoltSecondsPerMeter = 0.8;
    public static final double kaVoltSecondsSquaredPerMeter = 0.15;

    public static final double kMaxSpeedMetersPerSecond = 4;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;

  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 4;
    public static final double kMaxAccelerationMetersPerSecondSquared = 7;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1.5;
    public static final double kIXController = 1.5;
    public static final double kDXController = 1.5;

    public static final double kPYController = 0;
    public static final double kIYController = 0;
    public static final double kDYController = 0;

    public static final double kPThetaController = 0.1;
    public static final double kIThetaController = 0.1;
    public static final double kDThetaController = 0.1;

    // Constraint for the motion profilied robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
        new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }
}