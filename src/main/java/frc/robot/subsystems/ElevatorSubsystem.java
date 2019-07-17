package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class ElevatorSubsytem extends Subsystem {

    // Initialise motor controller
    private WPI_TalonSRX elevator_main;
    private WPI_VictorSPX elevator_slave;

    public ElevatorSubsytem() {
        config();
    }

    @Override
    public void initDefaultCommand() {
    }

    public void config() {
        elevator_main = new WPI_TalonSRX(Robot.portConstants.pElevatorMain);
        elevator_slave = new WPI_VictorSPX(Robot.portConstants.pElevatorSlave);

//        Main talon controller programmed with mag encoder
        elevator_main.configFactoryDefault();
        elevator_main.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Robot.timeConstants.kTimeOutMs);
        elevator_main.setSensorPhase(true);
        elevator_main.setNeutralMode(NeutralMode.Brake);
        elevator_main.configMotionAcceleration(Robot.physicsConstants.elevatorAccel, Robot.timeConstants.kTimeOutMs);
        elevator_main.configMotionCruiseVelocity(Robot.physicsConstants.elevatorCruiseV, Robot.timeConstants.kTimeOutMs);
        elevator_main.configMotionSCurveStrength(Robot.physicsConstants.elevatorSCurveStrength, Robot.timeConstants.kTimeOutMs);

//        Config soft limit
        elevator_main.configForwardSoftLimitEnable(Robot.physicsConstants.elevatorForwardSoftLimit, Robot.timeConstants.kTimeOutMs);
        elevator_main.configReverseSoftLimitEnable(Robot.physicsConstants.elevatorReverseSoftLimit, Robot.timeConstants.kTimeOutMs);

//        Config ramp rate
        elevator_main.configClosedloopRamp(Robot.physicsConstants.elevatorRampRate, Robot.timeConstants.kTimeOutMs);
        elevator_main.configOpenloopRamp(Robot.physicsConstants.elevatorRampRate, Robot.timeConstants.kTimeOutMs);

//        Config PID value
        elevator_main.config_kP(0, Robot.elevatorPID.kP, Robot.timeConstants.kTimeOutMs);
        elevator_main.config_kI(0, Robot.elevatorPID.kI, Robot.timeConstants.kTimeOutMs);
        elevator_main.config_kD(0, Robot.elevatorPID.kD, Robot.timeConstants.kTimeOutMs);

//        Config follow mode
        elevator_slave.follow(elevator_main);
        elevator_slave.setInverted(true);

    }

    public void setRotation(double targetRotation) {
        elevator_main.set(ControlMode.MotionMagic, targetRotation * 4096);
    }

    public void setSpeed(double targetSpeed) {
        elevator_main.set(ControlMode.PercentOutput, targetSpeed);
    }

    public void resetEncoder() {
        elevator_main.setSelectedSensorPosition(0,0,Robot.timeConstants.kTimeOutMs);
    }

    public double getSpeed() {
        return elevator_main.getSelectedSensorVelocity();
    }

    public double getPosition() {
        return elevator_main.getSelectedSensorPosition();
    }

}
