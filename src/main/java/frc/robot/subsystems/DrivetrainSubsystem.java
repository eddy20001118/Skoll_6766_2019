package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class DrivetrainSubsystem extends Subsystem {
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

    private WPI_VictorSPX dtLeftMain = new WPI_VictorSPX(Robot.portConstants.pDtLeftMain);
    private WPI_VictorSPX dtRightMain = new WPI_VictorSPX(Robot.portConstants.pDtRightMain);
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

        dtLeftMain.configOpenloopRamp(Robot.physicsConstants.dtRampRate, Robot.timeConstants.kTimeOutMs);
        dtRightMain.configOpenloopRamp(Robot.physicsConstants.dtRampRate, Robot.timeConstants.kTimeOutMs);

        dtLeftSlave.follow(dtLeftMain);
        dtRightSlave.follow(dtRightMain);

        dtRightMain.setInverted(true);
        dtRightSlave.setInverted(true);
    }

    public void arcadeDrive(double linearX, double angularZ) {
        angularZ *= 0.77;

        leftSpeed = linearX + angularZ;
        rightSpeed = linearX - angularZ;

        SmartDashboard.putNumber("LeftSpeed", leftSpeed);
        SmartDashboard.putNumber("RightSpeed", rightSpeed);

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

    public double getRightSpeed() {
        return dtRightMain.getSelectedSensorVelocity();
    }
}
