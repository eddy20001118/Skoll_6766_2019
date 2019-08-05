package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveTrainRevertCommand extends Command {

    public DriveTrainRevertCommand() {

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.m_oi.dtRevert = true;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.m_oi.dtRevert = false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}
