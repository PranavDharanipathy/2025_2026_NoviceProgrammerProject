package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {

    private Servo wrist;

    private Gamepad controller2;
    private final double LEFT_POS = 0.2;

    private final double CENTER_POS = 0.5;
    private final double RIGHT_POS = 0.8;

    public Wrist(HardwareMap hardwareMap, Gamepad gamePad) {

        wrist = hardwareMap.get(Servo.class, "wrist");
        wrist.setDirection(Servo.Direction.FORWARD);
        wrist.setPosition(CENTER_POS);
    }

    public void runLoopInstance () {

        if (controller2.dpad_left) {
            wrist.setPosition(LEFT_POS);
        }

        if (controller2.dpad_right) {
            wrist.setPosition(RIGHT_POS);
        }

        if (controller2.dpad_up) {
            wrist.setPosition(CENTER_POS);
        }
    }
}
