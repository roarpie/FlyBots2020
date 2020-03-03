/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.sensors.RobotColorSensor;
import frc.robot.sensors.RobotColorSensor.ColorType;

public class ColorMatcher extends SubsystemBase {
  private final RobotColorSensor robotColorSensor;
  /**
   * Creates a new ColorMatcher.
   */
  public ColorMatcher() {
    robotColorSensor = new RobotColorSensor(colorSensorV3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public ColorType getCurrentColor() {

  }

  // Moves to the selectedColor and returns the moves it took to reach that color
  public int moveToColor(ColorType color) {
    int moves = 0;
    return moves;
  }
}
