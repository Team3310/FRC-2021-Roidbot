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

    public static final double absoluteTurnZeroDegRightFront = 113.379;
    public static final double absoluteTurnZeroDegLeftFront = 343.037;
    public static final double absoluteTurnZeroDegRightRear = 356.572;
    public static final double absoluteTurnZeroDegLeftRear = 214.102;

    public static final int kFrontLeftDriveMotorMasterPort = 13;
    public static final int kFrontLeftDriveMotorSlavePort = 12;
    public static final int kRearLeftDriveMotorMasterPort = 15;
    public static final int kRearLeftDriveMotorSlavePort = 14;
    public static final int kFrontRightDriveMotorMasterPort = 2;
    public static final int kFrontRightDriveMotorSlavePort = 3;
    public static final int kRearRightDriveMotorMasterPort = 0;
    public static final int kRearRightDriveMotorSlavePort = 1;

    public static final int kFrontLeftTurningMotorPort = 10;
    public static final int kRearLeftTurningMotorPort = 11;
    public static final int kFrontRightTurningMotorPort = 5;
    public static final int kRearRightTurningMotorPort = 4;

    public static final int kIntakeMotor = 6;

    public static final int kFrontLeftCanCoderPort = 0;
    public static final int kRearLeftCanCoderPort = 2;
    public static final int kFrontRightCanCoderPort = 1;
    public static final int kRearRightCanCoderPort = 3;

    public static final int kGyroPort = 0;

    public static final double TURN_OUTPUT_TO_ENCODER_RATIO = 1;//12.8;
    public static final double DRIVE_OUTPUT_TO_ENCODER_RATIO = 5.71;
    public static final double DRIVE_ENCODER_TICKS_PER_MOTOR_REVOLUTION = 2048.0;
    public static final double TURN_ENCODER_TICKS_PER_MOTOR_REVOLUTION = 4096.0;
    public static final double ENCODER_TICKS_PER_MOTOR_REVOLUTION = 2048;
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

    public static final double kMaxSpeedMetersPerSecond = 5.75;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;

  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 0;//4
    public static final double kMaxAccelerationMetersPerSecondSquared = 0;//7;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1.0;
    public static final double kIXController = 1.0;
    public static final double kDXController = 0;

    public static final double kPYController = 1.0;
    public static final double kIYController = 1.0;
    public static final double kDYController = 0;

    public static final double kPThetaController = 0.0;
    public static final double kIThetaController = 0.0;
    public static final double kDThetaController = 0.0;
    //public static final double kDThetaController = 0.0;

    // Constraint for the motion profilied robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
        new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }
}
