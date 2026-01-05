package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class DriveTrain {

    private DcMotor left_front, right_front, left_back, right_back;
    private Gamepad controller1;
    public DriveTrain(HardwareMap hardwareMap, Gamepad gamepad1)  {

        left_front = hardwareMap.get(DcMotor.class, "left_front");
        left_back = hardwareMap.get(DcMotor.class, "left_back");
        right_front = hardwareMap.get(DcMotor.class, "right_front");
        right_back = hardwareMap.get(DcMotor.class, "right_back");
        controller1 = gamepad1;
        right_front.setDirection(DcMotorSimple.Direction.REVERSE);
        right_back.setDirection(DcMotorSimple.Direction.REVERSE);
        left_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void runLoopInstance() {

        double lfPower = -controller1.left_stick_y + controller1.left_stick_x + controller1.right_stick_x;
        double lbPower = -controller1.left_stick_y - controller1.left_stick_x + controller1.right_stick_x;
        double rbPower = -controller1.left_stick_y + controller1.left_stick_x - controller1.right_stick_x;
        double rfPower = -controller1.left_stick_y - controller1.left_stick_x - controller1.right_stick_x;

        left_front.setPower(lfPower);
        left_back.setPower(lbPower);
        right_front.setPower(rfPower);
        right_back.setPower(rbPower);
    }

}