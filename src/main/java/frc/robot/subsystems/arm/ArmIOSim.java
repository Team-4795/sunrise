package frc.robot.subsystems.arm;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.Constants;

public class ArmIOSim implements ArmIO {
  private double volts = 0.0;
  private SingleJointedArmSim sim =
      new SingleJointedArmSim(DCMotor.getNEO(2), 60, 0.4, 0.36, 0, 3.47, true, volts);

  @Override
  public void updateInputs(ArmIOInputs inputs) {
    sim.update(Constants.DT);
    inputs.positionRev = Units.radiansToRotations(sim.getAngleRads());
    inputs.velocityRev = Units.radiansToRotations(sim.getVelocityRadPerSec());
    inputs.currentAmps = sim.getCurrentDrawAmps();
    inputs.appliedVolts = volts;
  }

  @Override
  public void set(double input) {
    volts = MathUtil.clamp(input * 12.0, -12.0, 12.0);
    sim.setInputVoltage(volts);
  }
}
