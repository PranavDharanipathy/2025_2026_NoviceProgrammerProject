package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Extendo {


    private DcMotor left_extendo, right_extendo;
    private Gamepad controller2;
    public Extendo(HardwareMap hardwareMap, Gamepad gamepad2) {

        left_extendo = hardwareMap.get(DcMotor.class, "le");
        right_extendo = hardwareMap.get(DcMotor.class, "re");
        controller2 = gamepad2;
        left_extendo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_extendo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_extendo.setDirection(DcMotorSimple.Direction.REVERSE);
        left_extendo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_extendo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void runLoopInstance() {
        double power = controller2.right_trigger - controller2.left_trigger;
        left_extendo.setPower(power);
        right_extendo.setPower(power);

    }

}
