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
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class IntakeSubsystem extends Subsystem {

    private WPI_TalonSRX intakeMacin;
    private WPI_VictorSPX intakeAttrition;
    private WPI_TalonSRX intakeMotor;
    private Compressor compressor = new Compressor();
    private Solenoid hatchSolenoid0 = new Solenoid(0);
    private Solenoid hatchSolenoid1 = new Solenoid(1);

    public IntakeSubsystem() {
        intake_config();
    }

    public void intake_config() {
        compressor.stop();
        intakeAttrition = new WPI_VictorSPX(Robot.portConstants.pIntakeDown);
        intakeMacin = new WPI_TalonSRX(Robot.portConstants.pIntakeUp);
        intakeMotor = new WPI_TalonSRX(Robot.portConstants.pIntakeSpin);

//      Main talon controller programmed with mag encoder
        intakeMotor.configFactoryDefault();
        intakeMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, Robot.timeConstants.kTimeOutMs);
        intakeMotor.setSensorPhase(false);
        intakeMotor.setNeutralMode(NeutralMode.Brake);
//        intakeMotor.configNeutralDeadband(0.02);

//      Config ramp rate
        intakeMotor.configClosedloopRamp(Robot.physicsConstants.intakeRampRate, Robot.timeConstants.kTimeOutMs);
        intakeMotor.configOpenloopRamp(Robot.physicsConstants.intakeRampRate, Robot.timeConstants.kTimeOutMs);

        intakeMotor.setInverted(true);
//      Open-loop motors
        intakeMacin.configFactoryDefault();
        intakeAttrition.configFactoryDefault();
        intakeMacin.configOpenloopRamp(Robot.physicsConstants.intakeRampRate, Robot.timeConstants.kTimeOutMs);
        intakeAttrition.configOpenloopRamp(Robot.physicsConstants.intakeRampRate, Robot.timeConstants.kTimeOutMs);

        intakeAttrition.setInverted(true);
    }

    public void setIntakePosition(double targetPosition) {
        intakeMotor.set(ControlMode.MotionMagic, targetPosition);
    }

    public void setIntakeSpeed(double targetSpeed) {
        SmartDashboard.putNumber("IntakeSpin", targetSpeed);
        intakeMotor.set(ControlMode.PercentOutput, targetSpeed);
    }

    public void setIntakeUDSpeed(double targetSpeedUp, double targetSpeedDown) {
        if (targetSpeedUp < 0 && targetSpeedDown < 0){
            SmartDashboard.putBoolean("Ball", true);
        } else {
            SmartDashboard.putBoolean("Ball", false);
        }
        intakeMacin.set(ControlMode.PercentOutput, targetSpeedUp);
        intakeAttrition.set(ControlMode.PercentOutput, targetSpeedDown);
    }

    public void setHatchSolenoid0(boolean forward) {
        SmartDashboard.putBoolean("HatchPanel", forward);
        hatchSolenoid0.set(forward);
        hatchSolenoid1.set(!forward);
    }

    public void chongqi(){
        compressor.start();
    }

    public void stopchongqi(){
        compressor.stop();
    }

    public void resetEncoder() {
        intakeMotor.setSelectedSensorPosition(0, 0, Robot.timeConstants.kTimeOutMs);
    }

    public double getSpeed() {
        double velocity = intakeMotor.getSelectedSensorVelocity();
        SmartDashboard.putNumber("Sensor/intakeSpeed", velocity);
        return velocity;
    }

    public double getPosition() {
        double position = intakeMotor.getSelectedSensorPosition() / 1000.0;
        SmartDashboard.putNumber("Sensor/intakePostion", position);
        return position;
    }


    @Override
    public void initDefaultCommand() {
    }
}
