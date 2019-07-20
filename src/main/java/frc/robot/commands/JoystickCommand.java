/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
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
    double linearX = Robot.m_oi.getLeftAxis(3)-Robot.m_oi.getLeftAxis(2);
    double angularZ = Robot.m_oi.getLeftAxis(0);

    if (linearX >= 0.9 && angularZ >= 0.7){
      linearX *= 0.3;
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
