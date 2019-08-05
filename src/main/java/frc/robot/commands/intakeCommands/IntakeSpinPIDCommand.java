/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class IntakeSpinPIDCommand extends PIDCommand {
    public PIDController intakeController;
    public int currentButton;

    public IntakeSpinPIDCommand(double setPoint, int currentButton) {
        super(Robot.intakePID.kP, Robot.intakePID.kI, Robot.intakePID.kD);
        this.currentButton = currentButton;
        intakeController = this.getPIDController();
        intakeController.setAbsoluteTolerance(20);
        intakeController.setContinuous(false);
        intakeController.setInputRange(-600, 600);
        intakeController.setOutputRange(-0.3, 0.3);
        intakeController.setSetpoint(setPoint);
        SmartDashboard.putData(intakeController);
    }

    @Override
    protected void initialize() {
        Robot.intakeSubsystem.intake_config();
//        if (currentButton == 1) {
//            intakeController.enable();
//            Robot.m_oi.intakeMiddle.intakeController.disable();
//            Robot.m_oi.intakeUp.intakeController.disable();
//        } else if (currentButton == 2) {
//            intakeController.enable();
//            Robot.m_oi.intakeDown.intakeController.disable();
//            Robot.m_oi.intakeUp.intakeController.disable();
//        } else if (currentButton == 3) {
//            intakeController.enable();
//            Robot.m_oi.intakeMiddle.intakeController.disable();
//            Robot.m_oi.intakeDown.intakeController.disable();
//        }
    }

    @Override
    protected void execute() {
        SmartDashboard.putBoolean("IntakePIDTarget", intakeController.onTarget());
    }

    @Override
    protected boolean isFinished() {
        return intakeController.onTarget();
    }

    @Override
    protected void end() {
        intakeController.disable();
//        Robot.m_oi.intakeMiddle.intakeController.disable();
//        Robot.m_oi.intakeDown.intakeController.disable();
//        Robot.m_oi.intakeUp.intakeController.disable();
        intakeController.reset();
        Robot.intakeSubsystem.setIntakeSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected double returnPIDInput() {
        return Robot.intakeSubsystem.getPosition();
    }

    @Override
    protected void usePIDOutput(double v) {
        SmartDashboard.putNumber("IntakePIDOutput", v);
        Robot.intakeSubsystem.setIntakeSpeed(v);
    }
}