package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ElevatorSubsystem extends Subsystem {

    // Initialise motor controller
    private WPI_TalonSRX elevatorMain;
    private WPI_TalonSRX elevatorSlave;

    public ElevatorSubsystem() {
        config();
    }

    @Override
    public void initDefaultCommand() {
    }

    public void config() {
        elevatorMain = new WPI_TalonSRX(Robot.portConstants.pElevatorMain);
        elevatorSlave = new WPI_TalonSRX(Robot.portConstants.pElevatorSlave);

//        Main talon controller programmed with mag encoder
        elevatorMain.configFactoryDefault();
        elevatorMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Robot.timeConstants.kTimeOutMs);
        elevatorMain.setSensorPhase(true);
        elevatorMain.setNeutralMode(NeutralMode.Brake);
        elevatorSlave.setNeutralMode(NeutralMode.Brake);
        elevatorMain.configMotionAcceleration(Robot.physicsConstants.elevatorAccel, Robot.timeConstants.kTimeOutMs);
        elevatorMain.configMotionCruiseVelocity(Robot.physicsConstants.elevatorCruiseV, Robot.timeConstants.kTimeOutMs);
        elevatorMain.configMotionSCurveStrength(Robot.physicsConstants.elevatorSCurveStrength, Robot.timeConstants.kTimeOutMs);

//        Config ramp rate
        elevatorMain.configClosedloopRamp(Robot.physicsConstants.elevatorRampRate, Robot.timeConstants.kTimeOutMs);
        elevatorMain.configOpenloopRamp(Robot.physicsConstants.elevatorRampRate, Robot.timeConstants.kTimeOutMs);

//        Config PID value
        elevatorMain.config_kP(0, Robot.elevatorPID.kP, Robot.timeConstants.kTimeOutMs);
        elevatorMain.config_kI(0, Robot.elevatorPID.kI, Robot.timeConstants.kTimeOutMs);
        elevatorMain.config_kD(0, Robot.elevatorPID.kD, Robot.timeConstants.kTimeOutMs);

//        Config follow mode
        elevatorSlave.follow(elevatorMain);
        elevatorSlave.setInverted(false);

    }

    public void setPosition(double targetPosition) {
        elevatorMain.set(ControlMode.MotionMagic, targetPosition);
    }

    public void setSpeed(double targetSpeed) {
        elevatorMain.set(ControlMode.PercentOutput, targetSpeed);
    }

    public void resetEncoder() {
        elevatorMain.setSelectedSensorPosition(0, 0, Robot.timeConstants.kTimeOutMs);
    }

    public double getSpeed() {
        double speed = elevatorMain.getSelectedSensorVelocity();
        SmartDashboard.putNumber("Sensor/elevatorSpeed", speed);
        return speed;
    }

    public double getPosition() {
        double position = elevatorMain.getSelectedSensorPosition();
        SmartDashboard.putNumber("Sensor/elevatorPosition", position);
        return position;
    }

}
