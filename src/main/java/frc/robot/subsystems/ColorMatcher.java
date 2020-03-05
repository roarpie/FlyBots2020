/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.sensors.RobotColorSensor;
import frc.robot.sensors.RobotColorSensor.ColorType;

public class ColorMatcher extends SubsystemBase {
  private final RobotColorSensor robotColorSensor;
  private final ColorSensorV3 colorSensor;
  private final PWMVictorSPX colorWheelMotor;
  /**
   * Creates a new ColorMatcher.
   */
  public ColorMatcher(ColorSensorV3 colorSensorV3) {
    colorSensor = colorSensorV3;
    robotColorSensor = new RobotColorSensor(colorSensor);
    colorWheelMotor = new PWMVictorSPX(Constants.COLOR_WHEEL_MOTOR_PORT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public ColorType getCurrentColor() {
    return robotColorSensor.getCurrentColorType();
  }

  public void moveColorWheel() {
    colorWheelMotor.set(0.1);
  }

  public void stopColorWheel() {
    colorWheelMotor.stopMotor();
  }

  // Moves to the selectedColor and returns the moves it took to reach that color
  public int moveToColor(ColorType color) {
    int moves = 0;
    ColorType lastColor = getCurrentColor();
    while (lastColor != color) {
      moveColorWheel();
      if (lastColor != getCurrentColor()) {
        moves++;
        lastColor = getCurrentColor();
      }
    }
    stopColorWheel();
    return moves;
  }
}
