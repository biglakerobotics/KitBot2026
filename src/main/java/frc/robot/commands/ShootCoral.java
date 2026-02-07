package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShootCoral extends Command {

    private final Shooter mshooter;

    public ShootCoral(Shooter shooter) {
        mshooter = shooter;
    }

    @Override
    public void execute() {
        mshooter.depositCoral();;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        mshooter.stopMotor();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
