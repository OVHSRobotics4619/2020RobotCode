
package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ScissorLift;

public class ArticulateScissorLift extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    
    private final ScissorLift scissorSubsystem;
    private final DoubleSupplier move;

   /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArticulateScissorLift(ScissorLift subsystem, DoubleSupplier upDown) {
    scissorSubsystem = subsystem;
    move = upDown;
    addRequirements(subsystem);
  }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
      if (move.getAsDouble() > 0) {
          scissorSubsystem.moveUp();
      } else if (move.getAsDouble() < 0) {
          scissorSubsystem.moveDown();
      } else { // No input
          scissorSubsystem.hold();
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