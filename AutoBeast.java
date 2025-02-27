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

    // Here, we declare the int positions for the two Four Stage Vipers:

    final int HIGH_BASKET_SCORE = 3000;
    final int HIGH_CHAMBER_POSITION = 2000;
    final int HIGH_CHAMBER_SCORE = 1300;
    final int HOME_POSITION = 10;

    // Here we declare the double positions for the Four Stage Servos:

    final double FOUR_COLLECT = 0.98;
    final double FOUR_RELEASE = 0.8;

    final double FOUR_WRIST_TRANSFER = 0.15;
    final double FOUR_WRIST_FULL_SCORE = 0.77;

    // Here we declare the double positions for the Three Stage Servos:

    final double THREE_WRIST_TRANSFER = 0.99;
    final double THREE_WRIST_PICK = 0.129;
    final double THREE_COLLECT = 0.64;
    final double THREE_RELEASE = 0.0;
    final double VIPER_COLLECT = 0.20;
    final double VIPER_TRANSFER = 0.578;

    // Declaring the positions/modes for the rotational claw:

    final double rotationClawIncrement = 0.02;
    final double rotationClawHome = 0.2;

    /* Here, we declare the references for each of the int and double
    positions for both the Four Stage Vipers as well as the rotational
    Claws
     */

    double rotationClawPosition = rotationClawHome;

    int victorPosition = HOME_POSITION;
    int johnPosition = HOME_POSITION;

    @Override
    public void runOpMode() {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftRearDrive = hardwareMap.get(DcMotor.class, "left_rear_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightRearDrive = hardwareMap.get(DcMotor.class, "right_rear_drive");

        johnFourStageRightViper = hardwareMap.get(DcMotor.class, "four_stage_right_viper");
        victorFourStageLeftViper = hardwareMap.get(DcMotor.class, "four_stage_left_viper");

        fourStageClaw = hardwareMap.get(Servo.class, "four_stage_claw");
        fourStageWrist = hardwareMap.get(Servo.class, "four_stage_wrist");

        threeStageClaw = hardwareMap.get(Servo.class, "three_stage_claw");
        threeStageWrist = hardwareMap.get(Servo.class, "three_stage_wrist");
        rotationalClaw = hardwareMap.get(Servo.class, "rotational_claw");

        threeStageRightViper = hardwareMap.get(Servo.class, "three_stage_right_viper");
        threeStageLeftViper = hardwareMap.get(Servo.class, "three_stage_left_viper");

        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);

        victorFourStageLeftViper.setDirection(DcMotor.Direction.REVERSE);
        johnFourStageRightViper.setDirection(DcMotor.Direction.FORWARD);

        threeStageLeftViper.setDirection(Servo.Direction.FORWARD);
        threeStageRightViper.setDirection(Servo.Direction.REVERSE);

        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        johnFourStageRightViper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        victorFourStageLeftViper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        johnFourStageRightViper.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        johnFourStageRightViper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        victorFourStageLeftViper.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        victorFourStageLeftViper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fourStageClaw.setPosition(FOUR_RELEASE);
        fourStageWrist.setPosition(FOUR_WRIST_TRANSFER);

        threeStageRightViper.setPosition(VIPER_TRANSFER);
        threeStageLeftViper.setPosition(VIPER_TRANSFER);
        threeStageClaw.setPosition(THREE_WRIST_TRANSFER);
        rotationalClaw.setPosition(rotationClawHome);

        telemetry.addLine("Robot Initialized. Waiting for Start...");
        telemetry.update();


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Drive Forward
        goForward(4.0, 500);

        // Strafe to the left
        strafeLeft(0.4, 1500);

        /* Elevators would go up, the four stage wrist would go out
        and the four stage claw would open in order to score the
        sample. Right after this, and the four stage wrist would go back down 
        in order to get ready for the collection 
        at the spike marks. 
         */
        goToPosition(HIGH_BASKET_SCORE);
        depositSample();

        /* The robot would move a little bit forward
        in order to avoid scratching the baskets.
         */
        outOfTheWay(0.4, 200);

        /* The climbers & four Stage Wrist would go back down
         at the same time that the four stage claw opens in order
        to get ready for the sample collection at the
        spikeMarks
         */

        goToPosition(HOME_POSITION);
          /* Once the robot moves forward, it would try to align with the sample at the
        spike mark. First, the three stage vipers would come out before  Then,the three 
         taking the three stage wrist out. Then,the three stage claw would open up
        in order to pick up the sample from the spike mark.
         */
        spikeMarkExtension();


        /* In this case, the robot would drive towards one of the SpikeMarks
        in order to align with one of the samples
         */
        spikeMarkDrive(0.4, 700);
      
        /* Once at this point, the robot would try to align to one of the
        spike marks.
         */
        spikeMarkAlignmentOne(0.4, 100);


        /* What would happen here is that the three stage claw would close,
        the three stage wrist would go in, then the four stage claw would close before
        letting the three stage claw to open up.
         */
        spikeMarkRetraction();

        //  Right after this, the robot would align with the basket:

        basketAlignmentOne(0.4, 100);

        // Then, it would head back to the basket:

        basketDrive(4.0, 700);

        /* At this point, the scoring procedure for the
        high basket would repeat again as it did so through
        the beginning:
         */

        goToPosition(HIGH_BASKET_SCORE);
        depositSample();

        outOfTheWay(4.0, 200);

        goToPosition(HOME_POSITION);
        spikeMarkExtension();

        // Stops the robot:
        stopMotors();

        telemetry.addLine("Successful Auto");
        telemetry.update();

    }

        private void goForward(double power, long timeMs) {
            leftFrontDrive.setPower(power);
            leftRearDrive.setPower(power);
            rightFrontDrive.setPower(power);
            rightRearDrive.setPower(power);

            sleep(timeMs);

            stopMotors();
        }

        private void strafeLeft(double power,long timeMs) {
            leftFrontDrive.setPower(-power);
            leftRearDrive.setPower(power);
            rightFrontDrive.setPower(power);
            rightRearDrive.setPower(-power);

            sleep(timeMs);
            stopMotors();
        }
        private void outOfTheWay(double power,long timeMs) {
            leftFrontDrive.setPower(power);
            leftRearDrive.setPower(power);
            rightFrontDrive.setPower(power);
            rightRearDrive.setPower(power);

            sleep(timeMs);

            stopMotors();
        }

        private void spikeMarkDrive(double power,long timeMs) {
            leftFrontDrive.setPower(power);
            leftRearDrive.setPower(power);
            rightFrontDrive.setPower(power);
            rightRearDrive.setPower(power);

            sleep(timeMs);

            stopMotors();
        }
        private void spikeMarkAlignmentOne(double power, long timeMs) {
            leftFrontDrive.setPower(power);
            leftRearDrive.setPower(-power);
            rightFrontDrive.setPower(-power);
            rightRearDrive.setPower(power);

            sleep(timeMs);

            stopMotors();
        }

        private void basketAlignmentOne(double power, long timeMs) {
            leftFrontDrive.setPower(-power);
            leftRearDrive.setPower(power);
            rightFrontDrive.setPower(power);
            rightRearDrive.setPower(-power);

            sleep(timeMs);

            stopMotors();
        }
        
        private void basketDrive(double power, long timeMs) {
            leftFrontDrive.setPower(-power);
            leftRearDrive.setPower(-power);
            rightFrontDrive.setPower(-power);
            rightRearDrive.setPower(-power);

            sleep(timeMs);

            stopMotors();
        }
        
        private void goToPosition(int position) {
            victorFourStageLeftViper.setTargetPosition(position);
            victorFourStageLeftViper.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            victorFourStageLeftViper.setPower(1.0);

            johnFourStageRightViper.setTargetPosition(position);
            johnFourStageRightViper.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            johnFourStageRightViper.setPower(1.0);

            while (victorFourStageLeftViper.isBusy() || johnFourStageRightViper.isBusy()) {
                telemetry.addData("Victor Pos", victorFourStageLeftViper.getCurrentPosition());
                telemetry.addData("JOhn Pos", johnFourStageRightViper.getCurrentPosition());
                telemetry.update();
            }

            victorFourStageLeftViper.setPower(0);
            johnFourStageRightViper.setPower(0);

        }   
        private void depositSample() {
            fourStageWrist.setPosition(FOUR_WRIST_FULL_SCORE);
            sleep(1500);
            fourStageClaw.setPosition(FOUR_RELEASE);
            sleep(500);
            fourStageWrist.setPosition(FOUR_WRIST_TRANSFER); 
            sleep(100);
         }
         private void spikeMarkExtension() {
             threeStageLeftViper.setPosition(VIPER_COLLECT);
             threeStageRightViper.setPosition(VIPER_COLLECT);
             sleep(200);
             threeStageWrist.setPosition(THREE_WRIST_PICK);
             sleep(400);
             threeStageClaw.setPosition(THREE_RELEASE);
             sleep(100);
         }
         
         private void spikeMarkRetraction() {
             threeStageClaw.setPosition(THREE_COLLECT);
             sleep(600);
             threeStageWrist.setPosition(THREE_WRIST_TRANSFER);
             sleep(800);
             fourStageClaw.setPosition(FOUR_COLLECT);
             sleep(600);
             threeStageClaw.setPosition(THREE_RELEASE);
             sleep(300);
         }
            
         
            
            private void stopMotors() {
                leftFrontDrive.setPower(0);
                leftRearDrive.setPower(0);
                rightFrontDrive.setPower(0);
                rightRearDrive.setPower(0);
            }
    }
