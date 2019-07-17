/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;


public class IntakeSubsystem extends Subsystem {

    private WPI_VictorSPX intakeMacin; // Victor1 Open-loop Macin
    private WPI_VictorSPX intakeAttrition;// Victor2 Open-loop Attrition
    private WPI_TalonSRX intakeMotor;// Talon1 Closed-loop
    private Solenoid hatchSolenoid;

    public IntakeSubsystem() {
        intake_config();
    }

    public void intake_config() {
        intakeAttrition = new WPI_VictorSPX(Robot.portConstants.pIntakeSpin);
        intakeMacin = new WPI_VictorSPX(Robot.portConstants.pIntakeUp);
        intakeMotor = new WPI_TalonSRX(Robot.portConstants.pIntakeDown);
        hatchSolenoid = new Solenoid(Robot.portConstants.pHatchPanel);

//      Main talon controller programmed with mag encoder
        intakeMotor.configFactoryDefault();
        intakeMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Robot.timeConstants.kTimeOutMs);
        intakeMotor.setSensorPhase(true);
        intakeMotor.setNeutralMode(NeutralMode.Brake);

//      position loop set
        intakeMotor.configForwardSoftLimitEnable(Robot.physicsConstants.intakeForwardSoftLimit);
        intakeMotor.configForwardSoftLimitThreshold(Robot.physicsConstants.intakeForwardSensorLimit, Robot.timeConstants.kTimeOutMs);
        intakeMotor.configReverseSoftLimitEnable(true);
        intakeMotor.configReverseSoftLimitThreshold(Robot.physicsConstants.intakeReverseSensorLimit, Robot.timeConstants.kTimeOutMs);
// 1
        intakeMotor.configAllowableClosedloopError(Robot.portConstants.pIntakeSpin, Robot.physicsConstants.intakeAllowableCloseLoopError, Robot.timeConstants.kTimeOutMs);
        intakeMotor.configMotionCruiseVelocity(Robot.physicsConstants.intakeCruiseV, Robot.timeConstants.kTimeOutMs);
        intakeMotor.configMotionSCurveStrength(Robot.physicsConstants.intakeSCurveStrength, Robot.timeConstants.kTimeOutMs);

//      Config ramp rate
        intakeMotor.configClosedloopRamp(Robot.physicsConstants.intakeRampRate, Robot.timeConstants.kTimeOutMs);
        intakeMotor.configOpenloopRamp(Robot.physicsConstants.intakeRampRate, Robot.timeConstants.kTimeOutMs);

//      Config PID value
        intakeMotor.config_kP(0, Robot.intakePID.kP, Robot.timeConstants.kTimeOutMs);
        intakeMotor.config_kI(0, Robot.intakePID.kI, Robot.timeConstants.kTimeOutMs);
        intakeMotor.config_kD(0, Robot.intakePID.kD, Robot.timeConstants.kTimeOutMs);

//      Open-loop motors
        intakeMacin.configFactoryDefault();
        intakeAttrition.configFactoryDefault();
        intakeMacin.setInverted(Robot.physicsConstants.macinInvert);
        intakeAttrition.setInverted(!Robot.physicsConstants.macinInvert);

    }

    public void setIntakeRotation(double targetRotation) {
        intakeMotor.set(ControlMode.MotionMagic, targetRotation * 4096);
    }

    public void setIntakeSpeed(double targetSpeed) {
        intakeMotor.set(ControlMode.PercentOutput, targetSpeed);
    }

    public void setIntakeUDSpeed(double targetSpeedUp, double targerSpeedDown) {
        intakeMacin.set(ControlMode.PercentOutput, targetSpeedUp);
        intakeAttrition.set(ControlMode.PercentOutput, targerSpeedDown);
    }

    public void setHatchSolenoid(boolean forward){
        hatchSolenoid.set(forward);
    }

    public void resetEncoder() {
        intakeMotor.setSelectedSensorPosition(0, 0, Robot.timeConstants.kTimeOutMs);
    }

    public double getSpeed() {
        return intakeMotor.getSelectedSensorVelocity();
    }

    public double getPosition() {
        return intakeMotor.getSelectedSensorPosition();
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
