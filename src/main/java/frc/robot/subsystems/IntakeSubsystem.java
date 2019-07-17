/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private WPI_VictorSPX intakeMacin; //victor1 openloop Mac
    private WPI_VictorSPX intakeAttrition;// victor2 openloop attrition
    private WPI_TalonSRX intakeMotor;// talon1 closeloop

    public IntakeSubsystem() {
        intake_config();
    }

    public void intake_config() {
        intakeAttrition = new WPI_VictorSPX(Robot.portConstants.pIntakeSpin); //attrition pip control
        intakeMacin = new WPI_VictorSPX(Robot.portConstants.pIntakeUp);//intake_macin control up
        intakeMotor = new WPI_TalonSRX(Robot.portConstants.pIntakeDown);//intakeMotor contorl down

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

    public void setRotation(double targetRotation) {
        intakeMotor.set(ControlMode.MotionMagic, targetRotation * 4096);
    }

    public void setSpeed(double targetSpeed) {
        intakeMotor.set(ControlMode.PercentOutput, targetSpeed);
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
