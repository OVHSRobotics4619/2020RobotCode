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
  private final Elevator elevatorSubsystem = new Elevator();
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
                      .whenPressed(() -> shooterSubsystem.shoot())
                      .whenReleased(() -> shooterSubsystem.stop());

                      //() -> shooterSubsystem.shoot(), shooterSubsystem)

    // B button sucks balls
    new JoystickButton(driverController, Constants.OIConstants.B)
                      .whenPressed(() -> shooterSubsystem.suck())
                      .whenReleased(() -> shooterSubsystem.stop());
    
    // Y Button Spins Wheel 
    new JoystickButton(driverController, Constants.OIConstants.Y)
                      .whenPressed(() -> shooterSubsystem.wheelSpin())
                      .whenReleased(() -> shooterSubsystem.stop());
    
    // Triggers articulate barrel
    /*
    barrelAngleSubsystem.setDefaultCommand(
      new ArticulateBarrel(
        barrelAngleSubsystem,
        () -> driverController.getRawAxis(Constants.OIConstants.LEFT_TRIGGER),
        () -> driverController.getRawAxis(Constants.OIConstants.RIGHT_TRIGGER)
    ));
    */

    // Start and Back Control the Angle
    /*new JoystickButton(driverController, Constants.OIConstants.BACK)
                      .whenPressed(() -> barrelAngleSubsystem.angleDown())
                      .whenReleased(() -> barrelAngleSubsystem.hold());

    new JoystickButton(driverController, Constants.OIConstants.START)
                      .whenPressed(() -> barrelAngleSubsystem.angleUp())
                      .whenReleased(() -> barrelAngleSubsystem.hold());*/
    
    // Right stick y axis controls the angle
    new ArticulateBarrel(barrelAngleSubsystem,
      () -> driverController.getRawAxis(Constants.OIConstants.RIGHT_STICK_Y_AXIS)
      );

    
    // LB and RB move elevator
      new JoystickButton(driverController, Constants.OIConstants.L_BUMPER)
                        .whenPressed(() -> elevatorSubsystem.moveDown(), elevatorSubsystem)
                        .whenReleased(() -> elevatorSubsystem.hold());

      new JoystickButton(driverController, Constants.OIConstants.R_BUMPER)
                        .whenPressed(() -> elevatorSubsystem.moveUp(), elevatorSubsystem)
                        .whenReleased(() -> elevatorSubsystem.hold());

    // Start Button for Speed Boost 
     new JoystickButton(driverController, Constants.OIConstants.X)
    .whenPressed(() -> driveBaseSubsystem.setMaxOutput(1))
    .whenReleased(() -> driveBaseSubsystem.setMaxOutput(0.7));
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
