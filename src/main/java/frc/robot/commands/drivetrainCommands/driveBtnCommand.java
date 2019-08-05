/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrainCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class driveBtnCommand extends Command {
    public double linearX, angularZ;

    public driveBtnCommand(double linearX, double angularZ) {
        this.linearX = linearX;
        this.angularZ = angularZ;
    }

    @Override
    protected void initialize() {
        Robot.drivetrainSubsystem.config();
    }

    @Override
    protected void execute() {
        Robot.drivetrainSubsystem.arcadeDrive(linearX, angularZ + Robot.m_oi.getLeftAxis(1));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.drivetrainSubsystem.arcadeDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
