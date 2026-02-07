package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FuelManipulator extends SubsystemBase {
    SparkMax shootMotor = new SparkMax(Constants.motorShooter, MotorType.kBrushed);
    SparkMax intakeMotor = new SparkMax(Constants.motorIntake, MotorType.kBrushed);


    public FuelManipulator() {

        //before
        // leftLeader = new SparkMax(Constants.motorLLead, MotorType.kBrushed);
        // leftFollower = new SparkMax(Constants.motorLFollow, MotorType.kBrushed);
        // rightLeader = new SparkMax(Constants.motorRLead, MotorType.kBrushed);
        // rightFollower = new SparkMax(Constants.motorRFollow, MotorType.kBrushed);
        
        // why isnt it named leftleadconfig????
        SparkMaxConfig globalConfig = new SparkMaxConfig();
        SparkMaxConfig shooterConfig = new SparkMaxConfig();
        SparkMaxConfig intakeConfig = new SparkMaxConfig();

        globalConfig
            .smartCurrentLimit(Constants.stallLimit)
            .idleMode(IdleMode.kBrake);
            // .inverted(true);

        shooterConfig
            .apply(globalConfig)
            .inverted(Constants.shootMotorInverted);

        intakeConfig
            .apply(globalConfig)
            .inverted(Constants.shootMotorInverted);

        shootMotor.configure(shooterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        intakeMotor.configure(intakeConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void ActivateIntake(){
        shootMotor.set(-Constants.shootSpeed);
        intakeMotor.set(-Constants.shootSpeed);
    }

    public void StopManipulators() {
        shootMotor.set(0);
        intakeMotor.set(0);
    }
    public void ActivateShooter(){
        shootMotor.set(-Constants.shootSpeed);
        intakeMotor.set(Constants.shootSpeed);
    }
}
