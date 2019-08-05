/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ELUPCountCommand extends Command {
    public int downCount = 0;
    public int oldLevelValue;

    public ELUPCountCommand() {

    }

    @Override
    protected void initialize() {
        this.oldLevelValue = Robot.m_oi.elevatorLevel;
    }

    @Override
    protected void execute() {
        if (Robot.m_oi.elevatorLevel > -1) {
            Robot.m_oi.elevatorLevel--;
        }
        SmartDashboard.putNumber("ElevatorLevel", Robot.m_oi.elevatorLevel);
    }

    @Override
    protected boolean isFinished() {
        return Robot.m_oi.elevatorLevel - oldLevelValue == -1 || Robot.m_oi.elevatorLevel == -1;
    }

    @Override
    protected void end() {
        SmartDashboard.putNumber("ElevatorLevel", Robot.m_oi.elevatorLevel);
    }

    @Override
    protected void interrupted() {
    }
}
