package frc.robot.commands.elevatorCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ElevatorBBCommand extends Command {
    private double targetPosition = 0;
    private double currentPosition = 0;

    public ElevatorBBCommand() {

    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("ElevatorLevel", Robot.m_oi.elevatorLevel);

        if (Robot.m_oi.elevatorLevel == 0) {
            targetPosition = 330;
        } else if (Robot.m_oi.elevatorLevel == 1) {
            targetPosition = 400;
        } else if (Robot.m_oi.elevatorLevel == 2) {
            targetPosition = 500;
        } else if (Robot.m_oi.elevatorLevel == 3) {
            targetPosition = 600;
        } else if (Robot.m_oi.elevatorLevel == -1){
            end();
        }

        currentPosition = Robot.elevatorSubsytem.getPosition();
        if (currentPosition < targetPosition - 200) {
            Robot.elevatorSubsytem.setSpeed(0.3);
        } else if (currentPosition > targetPosition + 200) {
            Robot.elevatorSubsytem.setSpeed(-0.3);
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
