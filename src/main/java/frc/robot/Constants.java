/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class MotorConstants {

        // Initialize left drive motors
        public final static int FRONT_LEFT_DRIVE_MOTOR_PORT = Constants.RoboRIOConstants.PWM_PORT_0;
        public final static int REAR_LEFT_DRIVE_MOTOR_PORT = Constants.RoboRIOConstants.PWM_PORT_1;
        
        // Initiailize right drive motors
        public final static int FRONT_RIGHT_DRIVE_MOTOR_PORT = Constants.RoboRIOConstants.PWM_PORT_2;
        public final static int REAR_RIGHT_DRIVE_MOTOR_PORT = Constants.RoboRIOConstants.PWM_PORT_3;

        // Invert Left Motors?
        public final static boolean FRONT_LEFT_DRIVE_MOTOR_INVERTED = false;
        public final static boolean REAR_LEFT_DRIVE_MOTOR_INVERTED = false;
        
        // Invert Right Motors?
        public final static boolean FRONT_RIGHT_DRIVE_MOTOR_INVERTED = false;
        public final static boolean REAR_RIGHT_DRIVE_MOTOR_INVERTED = false;

        // Scissor Lift
        public final static int SCISSOR_LIFT_PORT = Constants.RoboRIOConstants.PWM_PORT_4;
        public final static boolean SCISSOR_LIFT_INVERTED = false;
        
        // Ball Feed
        public final static int BALL_FEED_PORT = Constants.RoboRIOConstants.PWM_PORT_5;
        public final static boolean BALL_FEED_INVERTED = false;

        // Shooter Angle
        public final static int ANGLE_PORT = Constants.RoboRIOConstants.PWM_PORT_8;
        public final static boolean ANGLE_INVERTED = false;

        // Shooter Wheels
        public final static int LEFT_SHOOTER_PORT = Constants.RoboRIOConstants.PWM_PORT_6;
        public final static int RIGHT_SHOOTER_PORT = Constants.RoboRIOConstants.PWM_PORT_7;

        public final static boolean LEFT_SHOOTER_INVERTED = false;
        public final static boolean RIGHT_SHOOTER_INVERTED = false;
    }

    public static final class OIConstants {
        // http://team358.org/files/programming/ControlSystem2009-/XBoxControlMapping.jpg

        public static final int XBOX_PORT = 0;
        
        // Xbox controller button mappings
        public final static int A = 1;
        public final static int B = 2;
        public final static int X = 3;
        public final static int Y = 4;
        public final static int L_BUMPER = 5;
        public final static int R_BUMPER = 6;
        public final static int BACK = 7;
        public final static int START = 8;	

        // Xbox controller axis mappings
        public final static int LEFT_STICK_X_AXIS = 0;
        public final static int LEFT_STICK_Y_AXIS = 1;
        public final static int LEFT_TRIGGER = 2;
        public final static int RIGHT_TRIGGER = 3;
        public final static int RIGHT_STICK_X_AXIS = 4;
        public final static int RIGHT_STICK_Y_AXIS = 5;
    }

    public static final class RoboRIOConstants {
        // PWM Ports
        public final static int PWM_PORT_0 = 0;
        public final static int PWM_PORT_1 = 1;
        public final static int PWM_PORT_2 = 2;
        public final static int PWM_PORT_3 = 3;
        public final static int PWM_PORT_4 = 4;
        public final static int PWM_PORT_5 = 5;
        public final static int PWM_PORT_6 = 6;
        public final static int PWM_PORT_7 = 7;
        public final static int PWM_PORT_8 = 8;
        public final static int PWM_PORT_9 = 9;
        
        // DIO Ports
        public final static int DIO_PORT_0 = 0;
        public final static int DIO_PORT_1 = 1;
        public final static int DIO_PORT_2 = 2;
        public final static int DIO_PORT_3 = 3;
        public final static int DIO_PORT_4 = 4;
        public final static int DIO_PORT_5 = 5;
        public final static int DIO_PORT_6 = 6;
        public final static int DIO_PORT_7 = 7;
        public final static int DIO_PORT_8 = 8;
        public final static int DIO_PORT_9 = 9;
    }   
}