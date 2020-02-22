package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BarrelAngle extends SubsystemBase {
    private VictorSP motor;

  public BarrelAngle() {
    this.motor = new VictorSP(Constants.MotorConstants.ANGLE_PORT);
    //this.motor.setInverted(Constants.MotorConstants.ANGLE_INVERTED);
  }

  public void angleUp() {
    motor.set(0.7);
  }

  public void angleDown() {
    motor.set(-0.7);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}