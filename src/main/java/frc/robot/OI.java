/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ElevatorCommand.levelHeight;
import frc.robot.commands.ElevatorCommand;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick xboxLeft = new Joystick(0);
    public Button buttonA1 = new JoystickButton(xboxLeft, 1),
            buttonB1 = new JoystickButton(xboxLeft, 2),
            buttonX1 = new JoystickButton(xboxLeft, 3),
            buttonY1 = new JoystickButton(xboxLeft, 4),
            buttonLeft1 = new JoystickButton(xboxLeft, 5),
            buttonRight1 = new JoystickButton(xboxLeft, 6),
            buttonBack1 = new JoystickButton(xboxLeft, 7),
            buttonStart1 = new JoystickButton(xboxLeft, 8);

    public OI(){
        // buttonA1.whenPressed(new ElevatorCommand(levelHeight.LEVEL_1));
        // buttonB1.whenPressed(new ElevatorCommand(levelHeight.LEVEL_2));
        // buttonX1.whenPressed(new ElevatorCommand(levelHeight.LEVEL_3));
    }

    public double getLeftAxis(int port){
        return xboxLeft.getRawAxis(port);
    }

    public boolean getLeftButton(int port){
        return xboxLeft.getRawButton(port);
    }
}
