package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MainCommandGroup extends CommandGroup {
    public MainCommandGroup() {
        addParallel(new JoystickCommand());
        addParallel(new ElevatorRawCommand());
        addParallel(new IntakeSpinRawCommand());
        addParallel(new ElevatorCP());
    }
}
