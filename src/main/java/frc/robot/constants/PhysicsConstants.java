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
    public boolean elevatorForwardSoftLimit = false;
    public boolean elevatorReverseSoftLimit = false;

    @Override
    public void refresh() {
        this.elevatorAccel = (int) SmartDashboard.getNumber("/Physics/elevatorAccel", elevatorAccel);
        this.elevatorCruiseV = (int) SmartDashboard.getNumber("/Physics/elevatorCruiseV", elevatorCruiseV);
        this.elevatorSCurveStrength = (int) SmartDashboard.getNumber("/Physics/elevatorSCurveStrength", elevatorSCurveStrength);
        this.elevatorLevelOneR = (double) SmartDashboard.getNumber("/Physics/elevatorLevelOneR", elevatorLevelOneR);
        this.elevatorLevelTwoR = (double) SmartDashboard.getNumber("/Physics/elevatorLevelTwoR", elevatorLevelTwoR);
        this.elevatorLevelThreeR = (double) SmartDashboard.getNumber("/Physics/elevatorLevelThreeR", elevatorLevelThreeR);
        this.elevatorRampRate = (double) SmartDashboard.getNumber("/Physics/elevatorRampRate", elevatorRampRate);
        this.elevatorForwardSoftLimit = (boolean) SmartDashboard.getBoolean("/Physics/elevatorForwardSoftLimit", elevatorForwardSoftLimit);
        this.elevatorReverseSoftLimit = (boolean) SmartDashboard.getBoolean("/Physics/elevatorReverseSoftLimit", elevatorReverseSoftLimit);
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
    }

    @Override
    public void print_value() {
    }
}
