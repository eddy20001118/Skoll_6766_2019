package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorCP extends Command {
    double targetPosition = 0;
    double currentPosition;

    public ElevatorCP() {
    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
    }

    @Override
    protected void execute() {
        if (Robot.m_oi.getRightButton(5) && Robot.m_oi.elevatorPosition > 0) {
            Robot.m_oi.elevatorPosition--;
        }

        if (Robot.m_oi.getRightButton(6) && Robot.m_oi.elevatorPosition < 3) {
            Robot.m_oi.elevatorPosition++;
        }

        if (Robot.m_oi.elevatorPosition == 0){
            targetPosition = -33073;
        } else if(Robot.m_oi.elevatorPosition == 1){
            targetPosition = -40000;
        } else if (Robot.m_oi.elevatorPosition == 2){
            targetPosition = -50000;
        } else if(Robot.m_oi.elevatorPosition == 3){
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
