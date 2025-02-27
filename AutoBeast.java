Skip to content
Navigation Menu
2Trainrobotics
2Trainrobotics-24096-FTC-2024-2025
 
Type / to search
Code
Issues
Pull requests
Actions
Projects
Security
Insights
Settings
2Trainrobotics-24096-FTC-2024-2025
/

in
main

Edit

Preview
Indent mode

Indent size

Line wrap mode

Editing AutoBeast.java file contents
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutoBeast", group = "FTC")
public class AutoBeast extends LinearOpMode {

    // We're declaring all of the drivetrain motors

    private DcMotor leftFrontDrive = null;
    private DcMotor leftRearDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightRearDrive = null;

    // Here, we declare the two four stage viper motors:

    private DcMotor johnFourStageRightViper = null;
    private DcMotor victorFourStageLeftViper = null;

    // Here, we declare all of the four stage viper components:

    private Servo fourStageClaw = null;
    private Servo fourStageWrist = null;

    // Here, we declare all of the Three Stage Viper Components:

    private Servo threeStageRightViper = null;
    private Servo threeStageLeftViper = null;
    private Servo threeStageWrist = null;
    private Servo threeStageClaw = null;
    private Servo rotationalClaw = null;

Use Control + Shift + m to toggle the tab key moving focus. Alternatively, use esc then tab to move to the next interactive element on the page.
Editing 2Trainrobotics-24096-FTC-2024-2025/AutoBeast.java at main · 2Trainrobotics/2Trainrobotics-24096-FTC-2024-2025 
