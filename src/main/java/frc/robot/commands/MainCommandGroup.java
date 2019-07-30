package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drivetrainCommands.JoystickCommand;
import frc.robot.commands.elevatorCommands.ElevatorCP;
import frc.robot.commands.elevatorCommands.ElevatorRawCommand;
import frc.robot.commands.intakeCommands.IntakeSpinRawCommand;

public class MainCommandGroup extends CommandGroup {
    public MainCommandGroup() {
        addParallel(new JoystickCommand());
        addParallel(new ElevatorRawCommand());
        addParallel(new IntakeSpinRawCommand());
        addParallel(new ElevatorCP());
    }
}
