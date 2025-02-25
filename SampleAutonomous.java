/* Created by ousseynou camara. 2025.
    This class illustrates my simplified Odometry Strategy.
    It implements basic straight line motions but with heading and drift controls to limit drift.
  /*
   package org.first.thinkingfrc.team2train
   // Drive a large rectangle, turning at each corner
TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(-39.96, -56.69, Math.toRadians(90.00)))
.splineTo(new Vector2d(-39.96, 46.37), Math.toRadians(90.00))
.splineTo(new Vector2d(34.09, 46.55), Math.toRadians(0.14))
.splineTo(new Vector2d(39.60, -60.25), Math.toRadians(-87.04))
.splineTo(new Vector2d(-39.25, -58.83), Math.toRadians(178.97))
.build();
// Drive the path again without turning.
TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(-40.49, -60.07, Math.toRadians(90.00)))
.splineTo(new Vector2d(-38.00, 41.38), Math.toRadians(88.59))
.splineTo(new Vector2d(24.30, 45.30), Math.toRadians(3.60))
.splineTo(new Vector2d(38.89, -8.81), Math.toRadians(-74.90))
.splineTo(new Vector2d(32.13, -61.68), Math.toRadians(262.71))
.splineTo(new Vector2d(-1.51, -64.35), Math.toRadians(184.54))
.splineTo(new Vector2d(-41.03, -63.46), Math.toRadians(178.71))
.build();
}
}
  }
