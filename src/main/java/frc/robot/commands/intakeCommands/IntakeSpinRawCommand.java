package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class IntakeSpinRawCommand extends Command {
    public IntakeSpinRawCommand() {

    }

    @Override
    protected void initialize() {
        Robot.intakeSubsystem.intake_config();
    }

    @Override
    protected void execute() {
        Robot.intakeSubsystem.setIntakeSpeed(Robot.m_oi.getRightAxis(1));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeSubsystem.setIntakeSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
