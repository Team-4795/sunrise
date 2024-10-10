package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
  @AutoLog
  public static class ArmIOInputs {
    public double positionRev = 0.0;
    public double velocityRev = 0.0;
    public double currentAmps = 0.0;
    public double appliedVolts = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(ArmIOInputs inputs) {}

  /** Set input amount to motor */
  public default void set(double input) {}
}
