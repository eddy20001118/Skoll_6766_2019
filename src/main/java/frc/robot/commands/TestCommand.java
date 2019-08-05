package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TestCommand extends Command {
    public TestCommand() {
        SmartDashboard.putData(this);
    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
        Robot.intakeSubsystem.intake_config();
    }

    @Override
    protected void execute() {
        Robot.elevatorSubsytem.setSpeed(Robot.m_oi.getLeftAxis(1));
        Robot.intakeSubsystem.setIntakeSpeed(Robot.m_oi.getLeftAxis(5));
        Robot.intakeSubsystem.setIntakeUDSpeed(Robot.m_oi.getLeftAxis(0),Robot.m_oi.getLeftAxis(4));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.elevatorSubsytem.setSpeed(0);
        Robot.intakeSubsystem.setIntakeSpeed(0);
        Robot.intakeSubsystem.setIntakeUDSpeed(0,0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
