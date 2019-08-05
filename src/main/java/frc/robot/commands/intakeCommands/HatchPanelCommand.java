package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchPanelCommand extends Command {
    public HatchPanelCommand() {

    }

    @Override
    protected void initialize() {
        Robot.intakeSubsystem.intake_config();
    }

    @Override
    protected void execute() {
        Robot.intakeSubsystem.setHatchSolenoid0(true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeSubsystem.setHatchSolenoid0(false);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
