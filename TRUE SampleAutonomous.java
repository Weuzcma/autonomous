/* Created by ousseynou camara. 2025.
   This class implements a simplified Odometry strategy for autonomous robot movement.
   It includes trajectory control with heading, drift correction, and smoother motion.
*/

package org.first.thinkingfrc.team2train;

// Import relevant classes (assume these exist)
import com.acme.robot.Odometry;
import com.acme.robot.TrajectorySequence;
import com.acme.robot.TrajectorySequenceBuilder;
import com.acme.robot.Vector2d;
import com.acme.robot.Pose2d;

public class AutonomousDrive {
    private RobotDrive drive; // Assume this is the drive system object

    public AutonomousDrive(RobotDrive drive) {
        this.drive = drive;
    }

    // Create a method to build a trajectory to reduce redundancy
    private TrajectorySequence buildRectangleTrajectory(Pose2d startPose) {
        return drive.trajectorySequenceBuilder(startPose)
            // Add splines with appropriate speed, heading, and drift control
            .splineTo(new Vector2d(-39.96, 46.37), Math.toRadians(90.00))
            .splineTo(new Vector2d(34.09, 46.55), Math.toRadians(0.14))
            .splineTo(new Vector2d(39.60, -60.25), Math.toRadians(-87.04))
            .splineTo(new Vector2d(-39.25, -58.83), Math.toRadians(178.97))
            .build();
    }

    // Another method to drive the path without turns
    private TrajectorySequence buildStraightPath(Pose2d startPose) {
        return drive.trajectorySequenceBuilder(startPose)
            .splineTo(new Vector2d(-38.00, 41.38), Math.toRadians(88.59))
            .splineTo(new Vector2d(24.30, 45.30), Math.toRadians(3.60))
            .splineTo(new Vector2d(38.89, -8.81), Math.toRadians(-74.90))
            .splineTo(new Vector2d(32.13, -61.68), Math.toRadians(262.71))
            .splineTo(new Vector2d(-1.51, -64.35), Math.toRadians(184.54))
            .splineTo(new Vector2d(-41.03, -63.46), Math.toRadians(178.71))
            .build();
    }

    // Execute both trajectories sequentially
    public void executeAutonomous() {
        // Start driving the rectangle path
        TrajectorySequence trajectory0 = buildRectangleTrajectory(new Pose2d(-39.96, -56.69, Math.toRadians(90.00)));
        drive.followTrajectorySequence(trajectory0);

        // Drive the second path without turning
        TrajectorySequence trajectory1 = buildStraightPath(new Pose2d(-40.49, -60.07, Math.toRadians(90.00)));
        drive.followTrajectorySequence(trajectory1);
    }
}
