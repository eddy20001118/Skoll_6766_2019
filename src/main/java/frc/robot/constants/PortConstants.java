package frc.robot.constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PortConstants implements Constants {
//    CAN port
    public int pElevatorMain = 11;
    public int pElevatorSlave = 12;
    public int pDtLeftMain = 19;
    public int pDtLeftSlave = 17;
    public int pDtRightMain = 16;
    public int pDtRightSlave = 15;
    public int pIntakeSpin = 13;
    public int pIntakeUp = 14;
    public int pIntakeDown = 18;

//    DigitalInput port
    public int pIFRLeft = 0;
    public int pIFRRight = 1;

//    Solenoid Node ID
    public int pHatchPanel0 = 0;
    public int pHatchPanel1 = 1;

    @Override
    public void refresh() {
//        CAN port
        this.pElevatorMain = (int) SmartDashboard.getNumber("/Port/pElevatorMain", this.pElevatorMain);
        this.pElevatorSlave = (int) SmartDashboard.getNumber("/Port/pElevatorSlave", this.pElevatorSlave);
        this.pDtLeftMain = (int) SmartDashboard.getNumber("/Port/pDtLeftMain", this.pDtLeftMain);
        this.pDtLeftSlave = (int) SmartDashboard.getNumber("/Port/pDtLeftSlave", this.pDtLeftSlave);
        this.pDtRightMain = (int) SmartDashboard.getNumber("/Port/pDtRightMain", this.pDtRightMain);
        this.pDtRightSlave = (int) SmartDashboard.getNumber("/Port/dtRightSlave", this.pDtRightSlave);
        this.pIntakeSpin = (int) SmartDashboard.getNumber("/Port/intakeSpin", this.pIntakeSpin);
        this.pIntakeUp = (int) SmartDashboard.getNumber("/Port/pIntakeUp", this.pIntakeUp);
        this.pIntakeDown = (int) SmartDashboard.getNumber("/Port/pIntakeDown", this.pIntakeDown);

//        DigitalInput port
        this.pIFRLeft = (int) SmartDashboard.getNumber("/Port/pIFRLeft", this.pIFRLeft);
        this.pIFRRight = (int) SmartDashboard.getNumber("/Port/pIFRRight", this.pIFRRight);

//        Solenoid Node ID
        this.pHatchPanel0 = (int) SmartDashboard.getNumber("/Port/pHatchPanel", this.pHatchPanel0);
    }

    @Override
    public void set() {
//        CAN Port
        SmartDashboard.putNumber("/Port/pElevatorMain", pElevatorMain);
        SmartDashboard.putNumber("/Port/pElevatorSlave", pElevatorSlave);
        SmartDashboard.putNumber("/Port/pDtLeftMain", pDtLeftMain);
        SmartDashboard.putNumber("/Port/pDtLeftSlave", pDtLeftSlave);
        SmartDashboard.putNumber("/Port/pDtRightMain", pDtRightMain);
        SmartDashboard.putNumber("/Port/pDtRightSlave", pDtRightSlave);
        SmartDashboard.putNumber("/Port/pIntakeSpin", pIntakeSpin);
        SmartDashboard.putNumber("/Port/pIntakeUp", pIntakeUp);
        SmartDashboard.putNumber("/Port/pIntakeDown", pIntakeDown);

//        DigitalInput Port
        SmartDashboard.putNumber("/Port/pIFRLeft", pIFRLeft);
        SmartDashboard.putNumber("/Port/pIFRRight", pIFRRight);

//      Solenoid Node ID
        SmartDashboard.putNumber("/Port/pHatchPanel", pHatchPanel0);
    }

    @Override
    public void print_value() {

    }
}
