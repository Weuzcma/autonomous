/* Created by ousseynou camara. 2025.
  this class illustrates my strategy of autonomy of piece advance.
it allows the robots to better manage its movements when it goes to take the piece and return.
/*
  @Override
public void autonomousInit(Take.first.piece.round.trip.to.the.basket) {
 TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(-42.63, -66.84, Math.toRadians(90.00)))
.splineTo(new Vector2d(-55.27, -65.95), Math.toRadians(175.97))
.splineTo(new Vector2d(-68.08, -65.24), Math.toRadians(90.00))
.splineTo(new Vector2d(-70.40, -27.68), Math.toRadians(93.53))
.splineTo(new Vector2d(-65.41, -64.88), Math.toRadians(-82.37))
.build();
}
@Override
public void autonomousInit(Take.second.piece.round.trip.to.the.basket) 
TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(-65.95, -66.84, Math.toRadians(90.00)))
.splineTo(new Vector2d(-59.72, -65.24), Math.toRadians(14.42))
.splineTo(new Vector2d(-59.54, -27.50), Math.toRadians(89.73))
.splineTo(new Vector2d(-66.48, -61.85), Math.toRadians(258.58))
.build();
}
@OVerride
public void autonomousInit(Take.third.piece.round.trip.to.the.basket) {
TrajectorySequence trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(-66.84, -62.39, Math.toRadians(90.00)))
.splineTo(new Vector2d(-57.23, -63.99), Math.toRadians(-9.46))
.splineTo(new Vector2d(-48.86, -63.46), Math.toRadians(3.65))
.splineTo(new Vector2d(-47.79, -30.17), Math.toRadians(88.16))
.splineTo(new Vector2d(-50.11, -30.53), Math.toRadians(188.75))
.splineTo(new Vector2d(-52.06, -59.36), Math.toRadians(266.12))
.splineTo(new Vector2d(-62.57, -65.41), Math.toRadians(209.95))
.build();
}
  }
    }
