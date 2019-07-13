package frc.robot.constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TimeConstants implements Constants{
    public int kTimeOutMs = 20;
    public double kElevatorFinishS = 2.5;

    @Override
    public void refresh(){
        this.kTimeOutMs = (int) SmartDashboard.getNumber("/Time/kTimeOutMs", kTimeOutMs);
        this.kElevatorFinishS = (double) SmartDashboard.getNumber("/Time/kElevatorFinishS", kElevatorFinishS);
    }

    @Override
    public void set() {
        SmartDashboard.putNumber("/Time/kTimeOutMs", kTimeOutMs);
        SmartDashboard.putNumber("/Time/kElevatorFinishS", kElevatorFinishS);
    }

    @Override
    public void print_value() {
    }
}
