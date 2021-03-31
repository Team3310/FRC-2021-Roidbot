package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utilities.Util;

public class IntakeSubsystem extends SubsystemBase {

    private static final double INTAKE_ROLLER_OUTPUT_TO_ENCODER_RATIO = 11.0 / 30.0;
    public static final double INTAKE_ROLLER_REVOLUTIONS_TO_ENCODER_TICKS = INTAKE_ROLLER_OUTPUT_TO_ENCODER_RATIO * Constants.DriveConstants.ENCODER_TICKS_PER_MOTOR_REVOLUTION;

    // Motor Controllers
    private TalonFX intakeMotor;

    // Misc
    private static final int kIntakeVelocitySlot = 0;
    private double targetPositionTicks = 0;

    public final static IntakeSubsystem INSTANCE = new IntakeSubsystem();

    public IntakeSubsystem() {
        intakeMotor = new TalonFX(Constants.DriveConstants.kIntakeMotor);

        TalonFXConfiguration configs = new TalonFXConfiguration();
        configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;
        intakeMotor.configAllSettings(configs);

        intakeMotor.setInverted(TalonFXInvertType.CounterClockwise);
        intakeMotor.setNeutralMode(NeutralMode.Brake);
        intakeMotor.configMotionCruiseVelocity(6000);
        intakeMotor.configMotionAcceleration(14000);
        intakeMotor.configMotionSCurveStrength(4);

        final StatorCurrentLimitConfiguration statorCurrentConfigs = new StatorCurrentLimitConfiguration();
        statorCurrentConfigs.currentLimit = 40;
        statorCurrentConfigs.enable = true;
        intakeMotor.configStatorCurrentLimit(statorCurrentConfigs);

        intakeMotor.config_kF(kIntakeVelocitySlot, 0.055);
        intakeMotor.config_kP(kIntakeVelocitySlot, 0.10);
        intakeMotor.config_kI(kIntakeVelocitySlot, 0.0001);
        intakeMotor.config_kD(kIntakeVelocitySlot, 0.0);
        intakeMotor.config_IntegralZone(kIntakeVelocitySlot, (int)this.RollerRPMToNativeUnits(200));
    }


    public void setRollerSpeed(double speed) {
        this.intakeMotor.set(ControlMode.PercentOutput, speed);
        System.out.println("Set Intake Speed");
    }

    public void resetIntakeEncoder() {
        this.intakeMotor.setSelectedSensorPosition(0);
    }


    public void setRollerRPM(double rpm) {
        this.intakeMotor.set(ControlMode.Velocity, this.RollerRPMToNativeUnits(rpm));
    }

    public double RollerRPMToNativeUnits(double rpm) {
        return rpm * INTAKE_ROLLER_REVOLUTIONS_TO_ENCODER_TICKS / 10.0D / 60.0D;
    }

}

