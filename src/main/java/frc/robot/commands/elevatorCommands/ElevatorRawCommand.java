package frc.robot.commands.elevatorCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ElevatorRawCommand extends Command {
    public ElevatorRawCommand() {

    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
    }

    @Override
    protected void execute() {
        double input = Robot.m_oi.getRightAxis(3) - Robot.m_oi.getRightAxis(2);
        Robot.elevatorSubsytem.setSpeed(input);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.elevatorSubsytem.setSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
