
package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BarrelAngle;

public class ArticulateBarrel extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    
    private final BarrelAngle barrelSubsystem;
    private final DoubleSupplier move;

   /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArticulateBarrel(BarrelAngle subsystem, DoubleSupplier input) {
    barrelSubsystem = subsystem;
    move = input;
    addRequirements(subsystem);
  }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
      if (move.getAsDouble() > 0) {
        barrelSubsystem.angleUp();

      } else if (move.getAsDouble() < 0) {
        barrelSubsystem.angleDown();

      } else {
        barrelSubsystem.hold();
      }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }



}