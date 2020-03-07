package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    private Spark elevator;
    private VictorSP ratchet;


  public Elevator() {
    this.ratchet = new VictorSP(Constants.MotorConstants.RATCHET_PORT);
    this.ratchet.setInverted(Constants.MotorConstants.RATCHET_INVERTED);

    this.elevator = new Spark(Constants.MotorConstants.ELEVATOR_PORT);
    this.elevator.setInverted(Constants.MotorConstants.ELEVATOR_INVERTED);
  }

  public void moveUp() {
    elevator.set(0.2);
  }

  public void moveDown() {
    elevator.set(-0.7);
  }

  public void pullUp() {
    ratchet.set(0.6);
  }

  public void hold() {
    elevator.stopMotor();;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}