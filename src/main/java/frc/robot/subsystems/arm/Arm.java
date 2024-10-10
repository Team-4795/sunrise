package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Arm extends SubsystemBase {
  private final ArmIO io;
  private final ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();

  // You can choose to play with these if you want
  // private final ProfiledPIDController pidController;
  // private final ArmFeedforward feedforward;

  public double setpoint;

  public Arm(ArmIO io) {
    this.io = io;
    io.updateInputs(inputs);

    // Uncomment the lines below if you want to play around with PID/FF
    // pidController = new ProfiledPIDController(Constants.ArmConstants.kP,
    // Constants.ArmConstants.kI, Constants.ArmConstants.kD,
    //   new TrapezoidProfile.Constraints(0.75, 1));

    // feedforward = new ArmFeedforward(0.015, 0.015, 0.88);
  }

  public void move() { // example of a possible method you could make for arm
    io.set(0);
  }

  public void moveUp() {
    // change setpoint here incredmentally, use a conditional to make sure it stays under the max
    // pos defined in ArmConstants
  }

  public void moveDown() {
    // opposite of what you did in the moveUp method but make sure it doesn't go below minimum
  }

  public void setPoint() {
    // give it a parameter and set the setpoint to said parameter
  }

  @Override
  public void periodic() {
    io.set(setpoint);
    io.updateInputs(inputs);
    Logger.processInputs("Arm", inputs);
    SmartDashboard.putNumber("Arm setpoint", setpoint);
    SmartDashboard.putNumber("Arm position", inputs.positionRev);
    SmartDashboard.putNumber("Arm current", inputs.currentAmps);
  }
}
