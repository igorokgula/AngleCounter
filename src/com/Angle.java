package com;

/**
 * Created by Igor on 27.07.2015.
 */
public final class Angle {

    private final int hours;
    private final int minutes;
    private final double angle;

    public Angle(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        angle = countAngle();
    }

    private double countAngle() {
        double hoursAngle = (hours % 12) * 30 + minutes / 2.0;
        double minutesAngle = minutes * 6;
        double angle = Math.abs(hoursAngle - minutesAngle);
        return Math.min(360 - angle, angle);
    }

    public double getAngle() {
        return angle;
    }
}
