package frc.robot.constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PhysicsConstants implements Constants {
    public int elevatorAccel = 1448;
    public int elevatorCruiseV = 800;
    public int elevatorSCurveStrength = 3;
    public double elevatorLevelOneR = 3;
    public double elevatorLevelTwoR = 7;
    public double elevatorLevelThreeR = 10;
    public double elevatorRampRate = 0.8;
    public int elevatorForwardSensorLimit = 10;
    public int elevatorReverseSensorLimit = -10;
    public boolean elevatorForwardSoftLimit = false;
    public boolean elevatorReverseSoftLimit = false;

    public int intakeCruiseV = 560;
    public int intakeSCurveStrength = 3;
    public int intakeForwardSensorLimit = 10;
    public int intakeReverseSensorLimit = -10;
    public int intakeAllowableCloseLoopError = 10;
    public double intakeRampRate = 0.3;
    public boolean intakeForwardSoftLimit = false;
    public boolean intakeReverseSoftLimit = false;

    public boolean macinInvert = false;

    @Override
    public void refresh() {
        this.elevatorAccel = (int) SmartDashboard.getNumber("/Physics/elevatorAccel", elevatorAccel);
        this.elevatorCruiseV = (int) SmartDashboard.getNumber("/Physics/elevatorCruiseV", elevatorCruiseV);
        this.elevatorSCurveStrength = (int) SmartDashboard.getNumber("/Physics/elevatorSCurveStrength", elevatorSCurveStrength);
        this.elevatorLevelOneR = (double) SmartDashboard.getNumber("/Physics/elevatorLevelOneR", elevatorLevelOneR);
        this.elevatorLevelTwoR = (double) SmartDashboard.getNumber("/Physics/elevatorLevelTwoR", elevatorLevelTwoR);
        this.elevatorLevelThreeR = (double) SmartDashboard.getNumber("/Physics/elevatorLevelThreeR", elevatorLevelThreeR);
        this.elevatorRampRate = (double) SmartDashboard.getNumber("/Physics/elevatorRampRate", elevatorRampRate);
        this.elevatorForwardSensorLimit = (int) SmartDashboard.getNumber("/Physics/elevatorForwardSensorLimit", elevatorForwardSensorLimit);
        this.elevatorReverseSensorLimit = (int) SmartDashboard.getNumber("/Physics/elevatorReverseSensorLimit", elevatorReverseSensorLimit);
        this.elevatorForwardSoftLimit = (boolean) SmartDashboard.getBoolean("/Physics/elevatorForwardSoftLimit", elevatorForwardSoftLimit);
        this.elevatorReverseSoftLimit = (boolean) SmartDashboard.getBoolean("/Physics/elevatorReverseSoftLimit", elevatorReverseSoftLimit);

        this.intakeCruiseV = (int) SmartDashboard.getNumber("/Physics/intakeCruiseV", intakeCruiseV);
        this.intakeSCurveStrength = (int) SmartDashboard.getNumber("/Physics/intakeSCurveStrength", intakeSCurveStrength);
        this.intakeForwardSensorLimit = (int) SmartDashboard.getNumber("/Physics/intakeForwardSensorLimit", intakeForwardSensorLimit);
        this.intakeReverseSensorLimit = (int) SmartDashboard.getNumber("/Physics/intakeReverseSensorLimit", intakeReverseSensorLimit);
        this.intakeAllowableCloseLoopError = (int) SmartDashboard.getNumber("/Physics/intakeAllowableCloseLoopError", intakeAllowableCloseLoopError);
        this.intakeRampRate = (double) SmartDashboard.getNumber("/Physics/intakeRampRate", intakeRampRate);
        this.intakeForwardSoftLimit = (boolean) SmartDashboard.getBoolean("/Physics/intakeForwardSoftLimit", intakeForwardSoftLimit);
        this.intakeReverseSoftLimit = (boolean) SmartDashboard.getBoolean("/Physics/intakeReverseSoftLimit", intakeReverseSoftLimit);

        this.macinInvert = (boolean) SmartDashboard.getBoolean("/Physics/macinInvert", macinInvert);
    }


    @Override
    public void set() {
        SmartDashboard.putNumber("/Physics/elevatorAccel", elevatorAccel);
        SmartDashboard.putNumber("/Physics/elevatorCruiseV", elevatorCruiseV);
        SmartDashboard.putNumber("/Physics/elevatorSCurveStrength", elevatorSCurveStrength);
        SmartDashboard.putNumber("/Physics/elevatorLevelOneR", elevatorLevelOneR);
        SmartDashboard.putNumber("/Physics/elevatorLevelTwoR", elevatorLevelTwoR);
        SmartDashboard.putNumber("/Physics/elevatorLevelThreeR", elevatorLevelThreeR);
        SmartDashboard.putNumber("/Physics/elevatorRampRate", elevatorRampRate);
        SmartDashboard.putBoolean("/Physics/elevatorForwardSoftLimit", elevatorForwardSoftLimit);
        SmartDashboard.putBoolean("/Physics/elevatorReverseSoftLimit", elevatorReverseSoftLimit);

        SmartDashboard.putNumber("/Physics/intakeCruiseV", intakeCruiseV);
        SmartDashboard.putNumber("/Physics/intakeSCurveStrength", intakeSCurveStrength);
        SmartDashboard.putNumber("/Physics/intakeForwardSensorLimit", intakeForwardSensorLimit);
        SmartDashboard.putNumber("/Physics/intakeReverseSensorLimit", intakeReverseSensorLimit);
        SmartDashboard.putNumber("/Physics/intakeAllowableCloseLoopError", intakeAllowableCloseLoopError);
        SmartDashboard.putNumber("/Physics/intakeRampRate", intakeRampRate);
        SmartDashboard.putBoolean("/Physics/intakeForwardSoftLimit", intakeForwardSoftLimit);
        SmartDashboard.putBoolean("/Physics/intakeReverseSoftLimit", intakeReverseSoftLimit);

        SmartDashboard.putBoolean("/Physics/macinInvert", macinInvert);

    }

    @Override
    public void print_value() {
    }
}
