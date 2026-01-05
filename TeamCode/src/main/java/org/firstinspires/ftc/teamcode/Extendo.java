package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Extendo {


    private DcMotor left_extendo, right_extendo;
    private Gamepad controller2;

    private final int IN_POS = 0;
    private final int OUT_POS = 1000;
    public Extendo(HardwareMap hardwareMap, Gamepad gamepad2) {

        left_extendo = hardwareMap.get(DcMotor.class, "left_extendo");
        right_extendo = hardwareMap.get(DcMotor.class, "right_extendo");
        controller2 = gamepad2;
        left_extendo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_extendo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_extendo.setDirection(DcMotorSimple.Direction.REVERSE);
        left_extendo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_extendo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_extendo.setTargetPosition(IN_POS);
        left_extendo.setTargetPosition(IN_POS);
        left_extendo.setPower(1);
        right_extendo.setPower(1);
        left_extendo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_extendo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void runLoopInstance() {

        if (controller2.right_trigger > 0.1) {
            left_extendo.setTargetPosition(OUT_POS);
            right_extendo.setTargetPosition(OUT_POS);
        }

        if (controller2.left_trigger > 0.1) {
            left_extendo.setTargetPosition(IN_POS);
            right_extendo.setTargetPosition(IN_POS);
        }
        telemetry.addData("Left Extendo Current Position", left_extendo.getCurrentPosition());
        telemetry.addData("Right Extendo Current Position", right_extendo.getCurrentPosition());
        telemetry.addData("Left Extendo Target Position", left_extendo.getTargetPosition());
        telemetry.addData("Right Extendo Target Position", right_extendo.getTargetPosition());


    }

}