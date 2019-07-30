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

public class IntakeSpinPID extends PIDCommand {
    public PIDController intakeController;

    public IntakeSpinPID(double setPoint) {
        super(Robot.intakePID.kP, Robot.intakePID.kI, Robot.intakePID.kD);
        intakeController = getPIDController();
        intakeController.setAbsoluteTolerance(4);
        intakeController.setContinuous(false);
        intakeController.setInputRange(-400, 400);
        intakeController.setOutputRange(-0.3, 0.3);
        intakeController.setSetpoint(setPoint);
        SmartDashboard.putData(intakeController);
    }

    @Override
    protected void initialize() {
        Robot.intakeSubsystem.intake_config();
        intakeController.enable();
    }

    @Override
    protected void execute() {
        intakeController.setPID(Robot.intakePID.kP, Robot.intakePID.kI, Robot.intakePID.kD);
        SmartDashboard.putBoolean("IntakePIDTarget", intakeController.onTarget());
    }

    @Override
    protected boolean isFinished() {
        return intakeController.onTarget();
    }

    @Override
    protected void end() {
        intakeController.disable();
        intakeController.reset();
        Robot.intakeSubsystem.setIntakeSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected double returnPIDInput() {
        return Robot.intakeSubsystem.getPosition() / 1000;
    }

    @Override
    protected void usePIDOutput(double v) {

        SmartDashboard.putNumber("IntakePIDOutput", v);
        Robot.intakeSubsystem.setIntakeSpeed(v);
    }
}