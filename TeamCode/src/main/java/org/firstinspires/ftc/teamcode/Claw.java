package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.nio.file.OpenOption;

public class Claw {

    private Servo claw;

    private Gamepad controller2;

    private final double OPEN_POS = 0.8;
    private final double CLOSED_POS = 0.3;

    public Claw(HardwareMap hardwareMap, Gamepad gamePad2) {

        claw = hardwareMap.get(Servo.class, "claw");
        claw.setDirection(Servo.Direction.FORWARD);
        claw.setPosition(CLOSED_POS);
    }

    public void runLoopInstance () {

        if (controller2.right_bumper) {
            claw.setPosition(OPEN_POS);
        }

        if (controller2.left_bumper) {
            claw.setPosition(CLOSED_POS);
        }

    }
}


