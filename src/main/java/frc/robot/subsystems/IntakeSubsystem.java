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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class IntakeSubsystem extends Subsystem {

    private WPI_TalonSRX intakeMacin;
    private WPI_VictorSPX intakeAttrition;
    private WPI_TalonSRX intakeMotor;
    private Solenoid hatchSolenoid;

    public IntakeSubsystem() {
        intake_config();
    }

    public void intake_config() {
        intakeAttrition = new WPI_VictorSPX(Robot.portConstants.pIntakeDown);
        intakeMacin = new WPI_TalonSRX(Robot.portConstants.pIntakeUp);
        intakeMotor = new WPI_TalonSRX(Robot.portConstants.pIntakeSpin);
        hatchSolenoid = new Solenoid(Robot.portConstants.pHatchPanel);

//      Main talon controller programmed with mag encoder
        intakeMotor.configFactoryDefault();
        intakeMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Robot.timeConstants.kTimeOutMs);
        intakeMotor.setSensorPhase(false);
        intakeMotor.setNeutralMode(NeutralMode.Brake);

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
        intakeMotor.set(ControlMode.PercentOutput, targetSpeed);
    }

    public void setIntakeUDSpeed(double targetSpeedUp, double targetSpeedDown) {
        intakeMacin.set(ControlMode.PercentOutput, targetSpeedUp);
        intakeAttrition.set(ControlMode.PercentOutput, targetSpeedDown);
    }

    public void setHatchSolenoid(boolean forward) {
        hatchSolenoid.set(forward);
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
        double position = intakeMotor.getSelectedSensorPosition();
        SmartDashboard.putNumber("Sensor/intakePostion", position);
        return position;
    }


    @Override
    public void initDefaultCommand() {
    }
}
