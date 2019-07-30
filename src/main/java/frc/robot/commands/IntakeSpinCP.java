package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeSpinCP extends Command {
    double targetPosition;
    double currentPosition;

    public IntakeSpinCP(double targetPosition) {
        this.targetPosition = targetPosition;
    }

    @Override
    protected void initialize() {
        Robot.intakeSubsystem.intake_config();
    }

    @Override
    protected void execute() {
        currentPosition = Robot.intakeSubsystem.getPosition();
        if (currentPosition < targetPosition - 2000) {
            Robot.intakeSubsystem.setIntakeSpeed(0.3);
        } else if (currentPosition > targetPosition + 2000) {
            Robot.intakeSubsystem.setIntakeSpeed(-0.3);
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
