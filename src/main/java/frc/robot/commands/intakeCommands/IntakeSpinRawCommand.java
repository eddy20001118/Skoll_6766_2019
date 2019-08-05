package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
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
        double input = 0.5 * -Robot.m_oi.getRightAxis(1);
        if (input >= 0.05 || input <= -0.05) {
            Robot.intakeSubsystem.setIntakeSpeed(input);
        } else {
            Robot.intakeSubsystem.setIntakeSpeed(0.04);
        }
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
