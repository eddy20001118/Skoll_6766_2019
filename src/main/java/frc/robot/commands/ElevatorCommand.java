/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorCommand extends Command {
    public double rotation = 0;
    public levelHeight currentLevel;

    public static enum levelHeight {
        LEVEL_1,
        LEVEL_2,
        LEVEL_3
    }

    public ElevatorCommand(levelHeight level) {
        requires(Robot.elevatorSubsytem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.elevatorSubsytem.config();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.elevatorSubsytem.setSpeed(Robot.m_oi.getLeftAxis(1));
        // if (currentLevel == levelHeight.LEVEL_1){
        //     this.rotation = Robot.physicsConstants.elevatorLevelOneR;
        // } else if (currentLevel == levelHeight.LEVEL_2) {
        //     this.rotation = Robot.physicsConstants.elevatorLevelTwoR;
        // } else if (currentLevel == levelHeight.LEVEL_3) {
        //     this.rotation = Robot.physicsConstants.elevatorLevelThreeR;
        // }

        // Robot.elevatorSubsytem.setRotation(rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
