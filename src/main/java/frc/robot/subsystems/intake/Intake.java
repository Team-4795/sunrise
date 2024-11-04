package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private IntakeIO io;
    private IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();
    private double intakeSpeed = 0.0;

    private static Intake instance;

    public static Intake getInstance(){
        return instance;
    }

    public static Intake initialize(IntakeIO io){
        if(instance == null){
            instance = new Intake(io);
        }
        return instance;
    }

    public Intake(IntakeIO io) {
        this.io = io;
        io.updateInputs(inputs);
    }

    public void setIntakeSpeed(double speed){
        intakeSpeed = speed;
    }

    public boolean isIntaking() {
        return inputs.currentAmps > IntakeConstants.intakeCurrent && inputs.angularVelocityRPM > 2400;
    }

    public Command intake() {
        return startEnd(() -> setIntakeSpeed(-0.85), () -> setIntakeSpeed(0));
    }

    public Command reverse() {
        return startEnd(() -> setIntakeSpeed(0.7), () -> setIntakeSpeed(0));
    }

    public Command slowReverse() {
        return startEnd(() -> setIntakeSpeed(0.4), () -> setIntakeSpeed(0));
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake", inputs);
        io.setMotorSpeed(intakeSpeed);
        Logger.recordOutput("Intake/Intake speed", intakeSpeed);
    }
}
