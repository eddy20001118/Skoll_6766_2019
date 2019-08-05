package frc.robot.commands.elevatorCommands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ElevatorPIDCommand extends PIDCommand {
    public PIDController elevatorController;
    public double setPoint = 0;

    public ElevatorPIDCommand() {
        super(Robot.elevatorPID.kP, Robot.elevatorPID.kI, Robot.elevatorPID.kD);

        elevatorController = this.getPIDController();
        elevatorController.setAbsoluteTolerance(20);
        elevatorController.setContinuous(false);
        elevatorController.setInputRange(0, 700);
        elevatorController.setOutputRange(-0.5, 0.5);
        elevatorController.setSetpoint(setPoint);
        SmartDashboard.putData(elevatorController);
    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
        elevatorController.enable();
    }

    @Override
    protected void execute() {
        if (Robot.m_oi.elevatorLevel == 0) {
            setPoint = 330;
            elevatorController.enable();
        } else if (Robot.m_oi.elevatorLevel == 1) {
            setPoint = 400;
            elevatorController.enable();
        } else if (Robot.m_oi.elevatorLevel == 2) {
            setPoint = 500;
            elevatorController.enable();
        } else if (Robot.m_oi.elevatorLevel == 3) {
            setPoint = 600;
            elevatorController.enable();
        } else if (Robot.m_oi.elevatorLevel == -1) {
            elevatorController.disable();
            Robot.elevatorSubsytem.setSpeed(Robot.m_oi.getRightAxis(2) - Robot.m_oi.getRightAxis(3));
        }
        elevatorController.setSetpoint(setPoint);
        SmartDashboard.putBoolean("ElevatorPIDTarget", elevatorController.onTarget());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        elevatorController.disable();
        elevatorController.reset();
        Robot.elevatorSubsytem.setSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected double returnPIDInput() {
        return Robot.elevatorSubsytem.getPosition();
    }

    @Override
    protected void usePIDOutput(double v) {
        SmartDashboard.putNumber("ElevatorPIDOutput", v);
        Robot.elevatorSubsytem.setSpeed(v);
    }
}
