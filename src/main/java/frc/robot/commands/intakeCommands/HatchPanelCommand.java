package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        Robot.intakeSubsystem.setHatchSolenoid(true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeSubsystem.setHatchSolenoid(false);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
