package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.BackGroundCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.ElevatorCommand.levelHeight;
import frc.robot.commands.ElevatorRawCommand;
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
    public ElevatorCommand elevatorCommand = new ElevatorCommand(levelHeight.LEVEL_1);

    //    Constants objects
    public static TimeConstants timeConstants = new TimeConstants();
    public static PhysicsConstants physicsConstants = new PhysicsConstants();
    public static PortConstants portConstants = new PortConstants();
    public static PIDConstants elevatorPID = new PIDConstants("Elevator", 0.5, 0, 0);
    public static PIDConstants intakePID = new PIDConstants("Intake", 0.5, 0, 0);
    public static PIDConstants dtLeftPID = new PIDConstants("dtLeft", 0.5, 0, 0);
    public static PIDConstants dtRightPID = new PIDConstants("dtRight", 0.5, 0, 0);

    //    Subsystem instances
    public static ElevatorSubsystem elevatorSubsytem = new ElevatorSubsystem();
    public static ElevatorRawCommand elevatorRawCommand = new ElevatorRawCommand();
    public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    public static DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();

    @Override
    public void robotInit() {
        m_oi = new OI();
        backGroundCommand.setRunWhenDisabled(true);
        backGroundCommand.start();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        elevatorRawCommand.start();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}
