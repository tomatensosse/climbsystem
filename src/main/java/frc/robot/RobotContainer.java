package frc.robot;


import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final ClimbSubsystem m_climb = new ClimbSubsystem();

    PS4Controller m_driverController = new PS4Controller(0);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new JoystickButton(m_driverController, 4)
        .whileTrue(new InstantCommand (()->m_climb.climbActive()))
        .whileFalse(new InstantCommand(()->m_climb.climbStop())); 
            
        new JoystickButton(m_driverController, 5)
        .whileTrue(new InstantCommand (()->m_climb.climbDisable()))
        .whileFalse(new InstantCommand(()->m_climb.climbStop()));
    }
}
