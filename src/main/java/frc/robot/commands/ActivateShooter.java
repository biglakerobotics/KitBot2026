package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FuelManipulator;

public class ActivateShooter extends Command {
    private final FuelManipulator m_shooter;

    public ActivateShooter(FuelManipulator shooter) {
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void execute() {
        m_shooter.ActivateShooter();
    }
    
     @Override
    public void end(boolean interrupted) {
        m_shooter.StopManipulators();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
