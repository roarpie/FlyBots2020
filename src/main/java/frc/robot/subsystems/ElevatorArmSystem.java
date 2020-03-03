/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class ElevatorArmSystem implements Subsystem {
  private PWMVictorSPX elevatorMotor;
  private PWMVictorSPX armMotor;
  
  public ElevatorArmSystem() {
    elevatorMotor = new PWMVictorSPX(Constants.ELEVATOR_MOTOR_PORT);
    armMotor = new PWMVictorSPX(Constants.ARM_MOTOR_PORT);
  }

  public void moveUp() {
    elevatorMotor.set(0.5);
  }

  public void moveDown() {
    elevatorMotor.set(-0.5);
  }

  public void moveLeft() {
    armMotor.set(0.5);
  }

  public void moveRight() {
    armMotor.set(-0.5);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
