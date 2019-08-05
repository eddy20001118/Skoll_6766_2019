package frc.robot.commands.drivetrainCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class JoystickCommand extends Command {
    public JoystickCommand() {

    }

    @Override
    protected void initialize() {
        Robot.drivetrainSubsystem.config();
    }

    @Override
    protected void execute() {
        double linearX = Robot.m_oi.getLeftAxis(3) - Robot.m_oi.getLeftAxis(2);
        double angularZ = Robot.m_oi.getLeftAxis(0) + Robot.m_oi.getLeftAxis(4);

        SmartDashboard.putBoolean("DTRevert", Robot.m_oi.dtRevert);

        if (Robot.m_oi.dtRevert) {
            linearX *= -1;
        }

        if (linearX >= 0.9 && angularZ >= 0.7) {
            linearX *= 0.3;
        }

        if (Robot.m_oi.getLeftButton(5)) {
            angularZ -= 0.4;
        }

        if (Robot.m_oi.getLeftButton(6)) {
            angularZ += 0.4;
        }

        Robot.drivetrainSubsystem.arcadeDrive(linearX, angularZ);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
