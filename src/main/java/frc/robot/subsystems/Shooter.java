package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.VictorSP;

public class Shooter extends SubsystemBase {

  private VictorSP leftMotor;
  private VictorSP rightMotor;
  private VictorSP ballFeedMotor;
  private double shooterSpeed = 0.6;
  private double beltSpeed = 0.4;

  public Shooter() {
    
    // Initialize Left Motor
    this.leftMotor = new VictorSP(Constants.MotorConstants.LEFT_SHOOTER_PORT);
    this.leftMotor.setInverted(Constants.MotorConstants.LEFT_SHOOTER_INVERTED);

    // Initialize Right Motor
    this.rightMotor = new VictorSP(Constants.MotorConstants.RIGHT_SHOOTER_PORT);
    this.rightMotor.setInverted(Constants.MotorConstants.RIGHT_SHOOTER_INVERTED);

    // Initialize Ball Feed Motor
    this.ballFeedMotor = new VictorSP(Constants.MotorConstants.BALL_FEED_PORT);
    this.ballFeedMotor.setInverted(Constants.MotorConstants.BALL_FEED_INVERTED);

  }

  public void shoot() {
    leftMotor.set(-shooterSpeed);
    rightMotor.set(shooterSpeed);
    ballFeedMotor.set(-beltSpeed);
  }

  public void suck() {
    leftMotor.set(shooterSpeed);
    rightMotor.set(-shooterSpeed);
    ballFeedMotor.set(beltSpeed);
  }

  public void wheelSpin() {
    rightMotor.set(-0.5);
    leftMotor.set(-0.5);
  }

  public void stop() {
    leftMotor.set(0);
    rightMotor.set(0);
    ballFeedMotor.set(0);
  }

  /*
  public void initDefaultCommand() {
    Shooter.setDefaultCommand();
  }
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}