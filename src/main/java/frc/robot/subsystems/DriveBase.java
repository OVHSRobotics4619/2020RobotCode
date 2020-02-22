/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class DriveBase extends SubsystemBase {
    
    public DifferentialDrive driveTrain;

    private VictorSP frontLeftMotor;
    private VictorSP rearLeftMotor;
    private VictorSP frontRightMotor;
    private VictorSP rearRightMotor;

    public DriveBase() {

        // Left Motors
        this.frontLeftMotor = new VictorSP(Constants.MotorConstants.FRONT_LEFT_DRIVE_MOTOR_PORT);
        this.rearLeftMotor = new VictorSP(Constants.MotorConstants.REAR_LEFT_DRIVE_MOTOR_PORT);

        // Right Motors
        this.frontRightMotor = new VictorSP(Constants.MotorConstants.FRONT_RIGHT_DRIVE_MOTOR_PORT);
        this.rearRightMotor = new VictorSP(Constants.MotorConstants.REAR_RIGHT_DRIVE_MOTOR_PORT);

        SpeedControllerGroup leftMotors = new SpeedControllerGroup(this.frontLeftMotor, this.rearLeftMotor);
        SpeedControllerGroup rightMotors = new SpeedControllerGroup(this.frontRightMotor, this.rearRightMotor);

        this.driveTrain = new DifferentialDrive(leftMotors, rightMotors);
    }
    

    public void arcadeDrive(double speed, double rotation) {
        arcadeDrive(speed, rotation, true);
    }

    public void arcadeDrive(double speed, double rotation, boolean squareInputs) {
        this.driveTrain.arcadeDrive(speed, rotation, squareInputs);
    }


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
