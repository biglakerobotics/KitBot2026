package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class Drive extends Command {
    private final DriveTrain m_drivetrain;

    private double DriveX;
    private double DriveY;
    public CommandXboxController joystick = new CommandXboxController(Constants.joyPort);

    public Drive(CommandXboxController joystick1, DriveTrain DriveTrain) {
        m_drivetrain = DriveTrain;
        addRequirements(m_drivetrain);
    }

    @Override
    public void execute() {
        DriveX = joystick.getLeftX()*Constants.steerSpeed;
        DriveY = joystick.getLeftY()*Constants.driveSpeed;
        m_drivetrain.mDifferentialDrive.arcadeDrive(DriveX, DriveY);
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
