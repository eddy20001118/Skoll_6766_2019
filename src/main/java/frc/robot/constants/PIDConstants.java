package frc.robot.constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDConstants implements Constants{
    public double kP, kI, kD;
    String name;
    public PIDConstants(String name, double kP, double kI, double kD){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.name = name;
    }

    @Override
    public void refresh() {
        this.kP = (double) SmartDashboard.getNumber("/"+this.name+"PID/"+"kP", this.kP);
        this.kI = (double) SmartDashboard.getNumber("/"+this.name+"PID/"+"kI", this.kI);
        this.kI = (double) SmartDashboard.getNumber("/"+this.name+"PID/"+"kD", this.kD);
    }

    @Override
    public void set() {
        SmartDashboard.putNumber("/"+this.name+"_PID/"+"kP", this.kP);
        SmartDashboard.putNumber("/"+this.name+"_PID/"+"kD", this.kD);
        SmartDashboard.putNumber("/"+this.name+"_PID/"+"kI", this.kI);
    }

    @Override
    public void print_value() {
    }
}
