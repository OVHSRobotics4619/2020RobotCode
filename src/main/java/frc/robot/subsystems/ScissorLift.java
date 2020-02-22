package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ScissorLift extends SubsystemBase {
    private VictorSP motor;

  public ScissorLift() {
    this.motor = new VictorSP(Constants.MotorConstants.SCISSOR_LIFT_PORT);
    this.motor.setInverted(Constants.MotorConstants.SCISSOR_LIFT_INVERTED);
  }

  public void moveUp() {
    motor.set(0.5);
  }

  public void moveDown() {
    motor.set(-0.5);
  }

  public void hold() {
    motor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}