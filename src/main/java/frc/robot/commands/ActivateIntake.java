package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FuelManipulator;

public class ActivateIntake extends Command {
    private final FuelManipulator m_intake;

    public ActivateIntake(FuelManipulator intake) {
        m_intake = intake;
        addRequirements(m_intake);
    }

    @Override
    public void execute() {
        m_intake.ActivateIntake();
    }
    
    @Override
    public void end(boolean interrupted) {
        m_intake.StopManipulators();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
