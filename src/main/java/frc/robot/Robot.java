package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.BackGroundCommand;
import frc.robot.commands.MainCommandGroup;
import frc.robot.constants.PIDConstants;
import frc.robot.constants.PhysicsConstants;
import frc.robot.constants.PortConstants;
import frc.robot.constants.TimeConstants;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class Robot extends TimedRobot {
    public static OI m_oi;

    //    Command instances
    public BackGroundCommand backGroundCommand = new BackGroundCommand();
    public MainCommandGroup mainCommandGroup = new MainCommandGroup();
    public frc.robot.commands.intakeCommands.IntakeSpinPID intakeSpinPID = new frc.robot.commands.intakeCommands.IntakeSpinPID(200);

    //    Constants objects
    public static TimeConstants timeConstants = new TimeConstants();
    public static PhysicsConstants physicsConstants = new PhysicsConstants();
    public static PortConstants portConstants = new PortConstants();
    public static PIDConstants elevatorPID = new PIDConstants("Elevator", 0.5, 0, 0);
    public static PIDConstants intakePID = new PIDConstants("Intake", 100, 0, 0);

    //    Subsystem instances
    public static ElevatorSubsystem elevatorSubsytem = new ElevatorSubsystem();
    public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    public static DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
    public UsbCamera camera0, camera1;

    @Override
    public void robotInit() {
        m_oi = new OI();
        backGroundCommand.setRunWhenDisabled(true);
        backGroundCommand.start();

        elevatorSubsytem.resetEncoder();
        intakeSubsystem.resetEncoder();

        camera0 = CameraServer.getInstance().startAutomaticCapture(0);
        camera1 = CameraServer.getInstance().startAutomaticCapture(1);

    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        mainCommandGroup.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        mainCommandGroup.start();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        Robot.drivetrainSubsystem.arcadeDrive(0, 0);
        Robot.elevatorSubsytem.setSpeed(0);
        Robot.intakeSubsystem.setIntakeSpeed(0);
        Robot.intakeSubsystem.setIntakeUDSpeed(0, 0);
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
