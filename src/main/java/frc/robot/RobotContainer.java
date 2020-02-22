/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

import frc.robot.Constants;

import static edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  // Define Subsystems
  //private final BarrelAngle barrelAngleSubsystem = new BarrelAngle();
  private final DriveBase driveBaseSubsystem = new DriveBase();
  private final ScissorLift scissorLiftSubsystem = new ScissorLift();
  private final Shooter shooterSubsystem = new Shooter();
  private final BarrelAngle barrelAngleSubsystem = new BarrelAngle();

  // Initialize Xbox Port
  XboxController driverController = new XboxController(Constants.OIConstants.XBOX_PORT);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();

    driveBaseSubsystem.setDefaultCommand(
      new DriveJoystick(
        driveBaseSubsystem,
        () -> driverController.getRawAxis(Constants.OIConstants.LEFT_STICK_Y_AXIS),
        () -> driverController.getRawAxis(Constants.OIConstants.LEFT_STICK_X_AXIS)
    ));

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // A button activates shooter
    new JoystickButton(driverController, Constants.OIConstants.A)
                      .whenPressed(new InstantCommand(shooterSubsystem::shoot, shooterSubsystem));

                      //() -> shooterSubsystem.shoot(), shooterSubsystem)

    // B button sucks balls
    new JoystickButton(driverController, Constants.OIConstants.B)
                      .whenPressed(() -> shooterSubsystem.suck(), shooterSubsystem);
    
    // Y Button Spins Wheel 
    new JoystickButton(driverController, Constants.OIConstants.Y)
                      .whenPressed(() -> shooterSubsystem.wheelSpin(), shooterSubsystem);
    
    // Rs articulate barrel
    barrelAngleSubsystem.setDefaultCommand(
      new ArticulateBarrel(
        barrelAngleSubsystem,
        () -> driverController.getRawAxis(Constants.OIConstants.LEFT_TRIGGER),
        () -> driverController.getRawAxis(Constants.OIConstants.RIGHT_TRIGGER)
    ));

    
    // LB and RB articulate ScissorLift
    scissorLiftSubsystem.setDefaultCommand(
      new ArticulateScissorLift(
        scissorLiftSubsystem,
        () -> driverController.getRawAxis(Constants.OIConstants.RIGHT_STICK_Y_AXIS)
    ));

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand();
  }
}
