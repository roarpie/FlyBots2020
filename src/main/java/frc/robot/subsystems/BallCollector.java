/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallCollector extends SubsystemBase {
  private PWMVictorSPX ballIntakeMotor;
  private Solenoid ballReleasePiston;
  private Solenoid doorManipulationPiston;
  /**
   * Creates a new BallCollector.
   */
  public BallCollector() {
    ballIntakeMotor = new PWMVictorSPX(Constants.BALL_INTAKE_MOTOR_PORT);
    ballReleasePiston = new Solenoid(Constants.BALL_RELEASE_PISTON_PORT);
    doorManipulationPiston = new Solenoid(Constants.DOOR_MANIPULATION_PISTON_PORT);
  }

  public void startBallIntake() {
    ballIntakeMotor.set(1);
  }

  public void stopBallIntake() {
    ballIntakeMotor.stopMotor();
  }

  public void reverseBallIntake() {
    ballIntakeMotor.set(-1);
  }

  public void openDoor() {
    doorManipulationPiston.set(true);
  }

  public void closeDoor() {
    doorManipulationPiston.set(false);
  }

  public void releaseBalls() {
    ballReleasePiston.set(true);
  }

  public void closeBallRelease() {
    ballReleasePiston.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
