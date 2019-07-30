package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchPanelCommand;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.IntakeBallReleaseCommand;
import frc.robot.commands.IntakeSpinCP;

public class OI {
    public boolean finish = false;
    public Joystick xboxLeft = new Joystick(0);
    public Joystick xboxRight = new Joystick(1);
    public int revertDT = 0;
    public int elevatorPosition = 0;

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
        buttonA1.whileHeld(new IntakeBallReleaseCommand(-0.5, -0.5));
        buttonB1.whileHeld(new IntakeBallCommand(0.5,0.5));

        buttonA2.toggleWhenPressed(new IntakeSpinCP(-5000));
        buttonB2.toggleWhenPressed(new IntakeSpinCP(0));
        buttonY2.toggleWhenPressed(new IntakeSpinCP(30000));
        buttonX2.toggleWhenPressed(new HatchPanelCommand());
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

    public boolean getDrivetrainRevert() {
        if (xboxLeft.getRawButton(1)) {
            Timer.delay(0.02);
            if (!xboxLeft.getRawButton(1)) {
                revertDT++;
            }
        }
        return revertDT % 2 != 0;
    }
}
