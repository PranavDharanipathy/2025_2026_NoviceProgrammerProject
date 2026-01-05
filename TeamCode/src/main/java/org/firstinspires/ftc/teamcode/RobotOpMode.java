package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "RobotOpMode")
public class RobotOpMode extends OpMode {

    private DriveTrain driveTrain;
    private Extendo extendo;

    private Wrist wrist;

    private Claw claw;

    @Override
    public void init() {
        driveTrain = new DriveTrain(hardwareMap, gamepad1);
        extendo = new Extendo(hardwareMap, gamepad2);
        wrist = new Wrist(hardwareMap, gamepad2);
        claw = new Claw(hardwareMap, gamepad2);
    }

    @Override
    public void loop() {
        driveTrain.runLoopInstance();
        extendo.runLoopInstance();
        wrist.runLoopInstance();
        claw.runLoopInstance();

    }


}