/* Created by ousseynou camara. 2025.
  This class illustrates my strategy of autonomy for piece advancement.
  It allows the robot to better manage its movements when it goes to take the piece and return.
*/

public class AutonomousStrategy {

    // Define trajectory for each piece
    private TrajectorySequence buildTrajectoryForFirstPiece() {
        return drive.trajectorySequenceBuilder(new Pose2d(-42.63, -66.84, Math.toRadians(90.00)))
            .splineTo(new Vector2d(-55.27, -65.95), Math.toRadians(175.97))
            .splineTo(new Vector2d(-68.08, -65.24), Math.toRadians(90.00))
            .splineTo(new Vector2d(-70.40, -27.68), Math.toRadians(93.53))
            .splineTo(new Vector2d(-65.41, -64.88), Math.toRadians(-82.37))
            .build(); 
    }

    private TrajectorySequence buildTrajectoryForSecondPiece() {
        return drive.trajectorySequenceBuilder(new Pose2d(-65.95, -66.84, Math.toRadians(90.00)))
            .splineTo(new Vector2d(-59.72, -65.24), Math.toRadians(14.42))
            .splineTo(new Vector2d(-59.54, -27.50), Math.toRadians(89.73))
            .splineTo(new Vector2d(-66.48, -61.85), Math.toRadians(258.58))
            .build();
    }

    private TrajectorySequence buildTrajectoryForThirdPiece() {
        return drive.trajectorySequenceBuilder(new Pose2d(-66.84, -62.39, Math.toRadians(90.00)))
            .splineTo(new Vector2d(-57.23, -63.99), Math.toRadians(-9.46))
            .splineTo(new Vector2d(-48.86, -63.46), Math.toRadians(3.65))
            .splineTo(new Vector2d(-47.79, -30.17), Math.toRadians(88.16))
            .splineTo(new Vector2d(-50.11, -30.53), Math.toRadians(188.75))
            .splineTo(new Vector2d(-52.06, -59.36), Math.toRadians(266.12))
            .splineTo(new Vector2d(-62.57, -65.41), Math.toRadians(209.95))
            .build();
    }

    // Autonomous initialization method for handling the pieces
    public void autonomousInit(String pieceType) {
        TrajectorySequence trajectory0 = null;

        // Choose the correct trajectory based on the piece type
        switch (pieceType) {
            case "first":
                trajectory0 = buildTrajectoryForFirstPiece();
                break;
            case "second":
                trajectory0 = buildTrajectoryForSecondPiece();
                break;
            case "third":
                trajectory0 = buildTrajectoryForThirdPiece();
                break;
            default:
                System.out.println("Invalid piece type.");
                break;
        }

        // Check if trajectory is successfully created
        if (trajectory0 != null) {
            // Follow the trajectory (assuming the `drive` object has a method for this)
            drive.followTrajectorySequence(trajectory0);
        } else {
            System.out.println("Trajectory initialization succesfully .");
        }
    }
}
