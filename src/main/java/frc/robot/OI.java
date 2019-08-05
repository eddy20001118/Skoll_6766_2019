package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.buttonCommands.DriveTrainRevertCommand;
import frc.robot.commands.elevatorCommands.ElevatorBtnCommand;
import frc.robot.commands.intakeCommands.ChongqiCommand;
import frc.robot.commands.intakeCommands.HatchPanelCommand;
import frc.robot.commands.intakeCommands.IntakeBallCommand;
import frc.robot.commands.intakeCommands.IntakeBallReleaseCommand;

public class OI {
    public Joystick xboxLeft = new Joystick(0);
    public Joystick xboxRight = new Joystick(1);

    public int elevatorLevel = -1; // elevatorLevel from 0 - 3
    public boolean dtRevert = false; // drivetrain revert flag

//    public IntakeSpinPIDCommand intakeDown = new IntakeSpinPIDCommand(-200, 1);
//    public IntakeSpinPIDCommand intakeMiddle = new IntakeSpinPIDCommand(60, 2);
//    public IntakeSpinPIDCommand intakeUp = new IntakeSpinPIDCommand(300, 3);

    public HatchPanelCommand hatchPanelCommand = new HatchPanelCommand();

    public Button buttonA1 = new JoystickButton(xboxLeft, 1),
            buttonB1 = new JoystickButton(xboxLeft, 2),
            buttonX1 = new JoystickButton(xboxLeft, 3),
            buttonY1 = new JoystickButton(xboxLeft, 4),
            buttonLeft1 = new JoystickButton(xboxLeft, 5),
            buttonRight1 = new JoystickButton(xboxLeft, 6),
            buttonBack1 = new JoystickButton(xboxLeft, 7),
            buttonStart1 = new JoystickButton(xboxLeft, 8);

    public Button buttonA2 = new JoystickButton(xboxRight, 1),
            buttonB2 = new JoystickButton(xboxRight, 2),
            buttonX2 = new JoystickButton(xboxRight, 3),
            buttonY2 = new JoystickButton(xboxRight, 4),
            buttonLeft2 = new JoystickButton(xboxRight, 5),
            buttonRight2 = new JoystickButton(xboxRight, 6),
            buttonBack2 = new JoystickButton(xboxRight, 7),
            buttonStart2 = new JoystickButton(xboxRight, 8);

    public OI() {
        buttonA1.toggleWhenPressed(new IntakeBallReleaseCommand(-0.5, -0.5));
        buttonB1.whileHeld(new IntakeBallCommand(0.7, 0.7));
        buttonX1.toggleWhenPressed(hatchPanelCommand);
        buttonBack1.toggleWhenPressed(new IntakeBallCommand(0, 0));
//        buttonStart1.toggleWhenPressed(new DriveTrainRevertCommand());
        buttonY1.toggleWhenPressed(new IntakeBallCommand(0, 0));

        buttonStart1.toggleWhenPressed(new ElevatorBtnCommand(0));
        buttonX2.toggleWhenPressed(hatchPanelCommand);
        buttonBack2.toggleWhenPressed(new ChongqiCommand());
    }

    public double getLeftAxis(int port) {
        return xboxLeft.getRawAxis(port);
    }

    public boolean getLeftButton(int port) {
        return xboxLeft.getRawButton(port);
    }

    public double getRightAxis(int port) {
        return xboxRight.getRawAxis(port);
    }

    public boolean getRightButton(int port) {
        return xboxRight.getRawButton(port);
    }

}
