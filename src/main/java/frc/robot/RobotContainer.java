/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.sensors.RobotColorSensor.ColorType;
import frc.robot.subsystems.BallCollector;
import frc.robot.subsystems.ColorMatcher;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem;
  private final BallCollector ballCollector;
  private final ColorSensorV3 colorSensor;
  private final ColorMatcher colorMatcher;

  XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveSubsystem = new DriveSubsystem();
    ballCollector = new BallCollector();

    colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    colorMatcher = new ColorMatcher(colorSensor);

    driveSubsystem.setDefaultCommand(new RunCommand(() -> {
      driveSubsystem.mecanumDrive(
        xboxController.getX(), 
        xboxController.getY(), 
        xboxController.getX(Hand.kRight)
      );
    }));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Button aButton = new JoystickButton(xboxController, 1);
    aButton.whenHeld(new RunCommand(() -> ballCollector.startBallIntake()));
    aButton.whenReleased(new RunCommand(() -> ballCollector.stopBallIntake()));

    Button bButton = new JoystickButton(xboxController, 2);
    bButton.whenPressed(new RunCommand(() -> colorMatcher.moveToColor(ColorType.RED)));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
