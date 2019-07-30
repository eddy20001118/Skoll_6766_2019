package frc.robot.commands.elevatorCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ElevatorCP extends Command {
    private double targetPosition = 0;
    private double currentPosition = 0;

    public ElevatorCP() {

    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("ElevatorLevel", Robot.m_oi.elevatorLevel);

        if (Robot.m_oi.elevatorLevel == 0) {
            targetPosition = -33073;
        } else if (Robot.m_oi.elevatorLevel == 1) {
            targetPosition = -40000;
        } else if (Robot.m_oi.elevatorLevel == 2) {
            targetPosition = -50000;
        } else if (Robot.m_oi.elevatorLevel == 3) {
            targetPosition = -60000;
        } else {
            targetPosition = 0;
        }

        currentPosition = Robot.elevatorSubsytem.getPosition();
        if (currentPosition < targetPosition - 200) {
            Robot.elevatorSubsytem.setSpeed(-0.3);
        } else if (currentPosition > targetPosition + 200) {
            Robot.elevatorSubsytem.setSpeed(0.3);
        } else {
            Robot.elevatorSubsytem.setSpeed(0);
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
