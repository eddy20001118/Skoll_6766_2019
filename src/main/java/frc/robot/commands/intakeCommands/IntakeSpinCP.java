package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        currentPosition = Robot.intakeSubsystem.getPosition() / 1000;
        if (currentPosition < targetPosition - 2) {
            Robot.intakeSubsystem.setIntakeSpeed(0.3);
        } else if (currentPosition > targetPosition + 2) {
            Robot.intakeSubsystem.setIntakeSpeed(-0.3);
        } else {
            Robot.intakeSubsystem.setIntakeSpeed(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(currentPosition - Robot.intakeSubsystem.getPosition()) <= 4;
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
