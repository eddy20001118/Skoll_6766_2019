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

public class ELDownCountCommand extends Command {

    public int up = 0;
    public int oldLevelValue;

    public ELDownCountCommand() {

    }

    @Override
    protected void initialize() {
        this.oldLevelValue = Robot.m_oi.elevatorLevel;
    }

    @Override
    protected void execute() {
        if (Robot.m_oi.elevatorLevel < 3) {
            Robot.m_oi.elevatorLevel++;
        }
    }

    @Override
    protected boolean isFinished() {
        return Robot.m_oi.elevatorLevel - oldLevelValue == 1 || Robot.m_oi.elevatorLevel == 3;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
