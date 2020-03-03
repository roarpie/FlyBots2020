/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private PWMVictorSPX frontLeft;
  private PWMVictorSPX frontRight;
  private PWMVictorSPX rearLeft;
  private PWMVictorSPX rearRight;
  private MecanumDrive robotDrive;
 
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    frontLeft = new PWMVictorSPX(Constants.FRONT_LEFT_MOTOR_PORT);
    frontRight = new PWMVictorSPX(Constants.FRONT_RIGHT_MOTOR_PORT);
    rearLeft = new PWMVictorSPX(Constants.REAR_LEFT_MOTOR_PORT);
    rearRight = new PWMVictorSPX(Constants.REAR_RIGHT_MOTOR_PORT);

    robotDrive = new MecanumDrive(rearLeft, rearRight, frontLeft, frontRight);
  }

  public void mecanumDrive(double xSpeed, double ySpeed, double zRotation) {
    robotDrive.driveCartesian(xSpeed, ySpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
