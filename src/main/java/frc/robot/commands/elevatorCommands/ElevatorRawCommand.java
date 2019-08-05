package frc.robot.commands.elevatorCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
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
        double input = 0.7 * (Robot.m_oi.getRightAxis(2) - Robot.m_oi.getRightAxis(3));

        if (input >= 0.05 || input <= -0.05) {
            Robot.elevatorSubsytem.setSpeed(input);
        } else {
            Robot.elevatorSubsytem.setSpeed(-0.06);
        }

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
