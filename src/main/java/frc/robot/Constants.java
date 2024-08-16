// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final Mode currentMode = Mode.SIM;

  public static final class FieldConstants {
    public static final double speakerHeight = 2; // meters
    public static final double fieldLength = Units.inchesToMeters(651.223);
    public static final double fieldWidth = Units.inchesToMeters(323.277);
    public static final Pose2d BLUE_SOURCE = new Pose2d(15.9, 0.4, Rotation2d.fromDegrees(-45));
    public static final Pose2d RED_SOURCE = new Pose2d(0.6, 0.25, Rotation2d.fromDegrees(45));
    // public static final Pose2d BLUE_SHUTTLE = new Pose2d(2.9, 7, new Rotation2d());
    // public static final Pose2d RED_SHUTTLE = new Pose2d(13.8, 7, new Rotation2d());
    public static final Pose2d BLUE_SHUTTLE = new Pose2d(1.86, 6.0, new Rotation2d());
    public static final Pose2d RED_SHUTTLE = new Pose2d(14.6, 6.0, new Rotation2d());
    public static final Pose2d RED_SPEAKER = new Pose2d(16.379342, 5.547868, new Rotation2d());
    public static final Pose2d BLUE_SPEAKER = new Pose2d(0.1619, 5.547868, new Rotation2d());
    public static double RED_WING_X = 10.0;
    public static double BLUE_WING_X = 6.5;

    public static final class StagingLocations {
      public static final double centerlineX = fieldLength / 2.0;

      // need to update
      public static final double centerlineFirstY = fieldWidth - Units.inchesToMeters(29.638);
      public static final double centerlineSeparationY = Units.inchesToMeters(66);
      public static final double spikeX = Units.inchesToMeters(114);
      // need
      public static final double spikeFirstY = Units.inchesToMeters(161.638);
      public static final double spikeSeparationY = Units.inchesToMeters(57);

      public static final Translation2d[] centerlineTranslations = new Translation2d[9];
      public static final Translation2d[] spikeTranslations = new Translation2d[3];

      static {
        for (int i = 4; i < centerlineTranslations.length; i++) {
          centerlineTranslations[i] =
              new Translation2d(centerlineX, centerlineFirstY - ((i - 4) * centerlineSeparationY));
        }
      }

      static {
        for (int i = 0; i < spikeTranslations.length; i++) {
          spikeTranslations[i] = new Translation2d(spikeX, spikeFirstY + (i * spikeSeparationY));
        }
      }
    }
  }

  public static enum Mode {
    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }
}
