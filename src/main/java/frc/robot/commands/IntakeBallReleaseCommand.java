/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeBallReleaseCommand extends Command {
    double upSpeed = 0;
    double downSpeed = 0;


    public IntakeBallReleaseCommand(double upSpeed, double downSpeed) {
        this.downSpeed = downSpeed;
        this.upSpeed = upSpeed;
    }

    @Override
    protected void initialize() {
        Robot.intakeSubsystem.intake_config();
    }

    @Override
    protected void execute() {
        Robot.intakeSubsystem.setIntakeUDSpeed(upSpeed, downSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeSubsystem.setIntakeUDSpeed(-0.05, -0.05);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
