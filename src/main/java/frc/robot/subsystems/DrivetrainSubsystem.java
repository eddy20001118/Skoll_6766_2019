package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class DrivetrainSubsystem extends Subsystem {
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

    private WPI_TalonSRX dtLeftMain = new WPI_TalonSRX(Robot.portConstants.pDtLeftMain);
    private WPI_TalonSRX dtRightMain = new WPI_TalonSRX(Robot.portConstants.pDtRightMain);
    private WPI_VictorSPX dtLeftSlave = new WPI_VictorSPX(Robot.portConstants.pDtLeftSlave);
    private WPI_VictorSPX dtRightSlave = new WPI_VictorSPX(Robot.portConstants.pDtRightSlave);

    private double leftSpeed = 0;
    private double rightSpeed = 0;


    public DrivetrainSubsystem() {
        config();
    }

    @Override
    public void initDefaultCommand() {

    }

    public void config() {
        dtLeftMain.configFactoryDefault();
        dtRightMain.configFactoryDefault();

        dtLeftMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Robot.timeConstants.kTimeOutMs);
        dtRightMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Robot.timeConstants.kTimeOutMs);

        dtLeftMain.setSensorPhase(true);
        dtRightMain.setSensorPhase(true);

        dtLeftMain.setNeutralMode(NeutralMode.Brake);
        dtRightMain.setNeutralMode(NeutralMode.Brake);

        dtLeftMain.configClosedloopRamp(Robot.physicsConstants.dtRampRate, Robot.timeConstants.kTimeOutMs);
        dtRightMain.configClosedloopRamp(Robot.physicsConstants.dtRampRate, Robot.timeConstants.kTimeOutMs);

        dtLeftMain.configOpenloopRamp(Robot.physicsConstants.dtRampRate, Robot.timeConstants.kTimeOutMs);
        dtRightMain.configOpenloopRamp(Robot.physicsConstants.dtRampRate, Robot.timeConstants.kTimeOutMs);

        dtLeftMain.config_kP(0, Robot.dtLeftPID.kP, Robot.timeConstants.kTimeOutMs);
        dtLeftMain.config_kI(0, Robot.dtLeftPID.kI,Robot.timeConstants.kTimeOutMs);
        dtLeftMain.config_kD(0, Robot.dtLeftPID.kD, Robot.timeConstants.kTimeOutMs);

        dtRightMain.config_kP(0,Robot.dtRightPID.kP,Robot.timeConstants.kTimeOutMs);
        dtRightMain.config_kI(0, Robot.dtRightPID.kI,Robot.timeConstants.kTimeOutMs);
        dtRightMain.config_kD(0,Robot.dtRightPID.kD,Robot.timeConstants.kTimeOutMs);

        dtLeftSlave.follow(dtLeftMain);
        dtRightSlave.follow(dtRightMain);

        dtRightMain.setInverted(true);
        dtRightSlave.setInverted(true);
    }

    public void arcadeDrive(double linearX, double angularZ) {
        leftSpeed = linearX + angularZ;
        rightSpeed = linearX - angularZ;

        dtLeftMain.set(ControlMode.PercentOutput, leftSpeed);
        dtLeftSlave.set(ControlMode.PercentOutput, leftSpeed);
        dtRightMain.set(ControlMode.PercentOutput, rightSpeed);
        dtRightSlave.set(ControlMode.PercentOutput, rightSpeed);
    }

    public void resetGyro() {
        gyro.reset();
    }

    public double getAngle() {
        return gyro.getAngle();
    }

    public double getLeftSpeed() {
        return dtLeftMain.getSelectedSensorVelocity();
    }

    public double getRightSpeed(){
        return dtRightMain.getSelectedSensorVelocity();
    }
}
