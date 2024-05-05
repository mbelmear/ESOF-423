package org.example;
public class Bozeman {
    public static final double DANGEROUS_WINDSPEED = 70.0;
    public static final double DANGEROUS_SNOWFALL = 36.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_SNOWFALL = 12.0;

    /**
     * This method returns true. Always.
     */

    public static boolean IsItGrowing() {
        return true; // it's always growing
    }

    /**
     * This method returns "CANCEL", "WARN", or "ALL CLEAR".
     *
     * "CANCEL" will be returned if any of the following conditions are met:
     *
     * <ul>
     * <li>More than 36.0 inches of snow are predicted within the next 24
     * hours.</li>
     * <li>Wind speeds greater than 70.0 mph are predicted within the next 24
     * hours.</li>
     * <li>It is predicted that there will be more than 12.0 inches of snow and wind
     * speeds will be above 45.0 mph.</li>
     * </ul>
     *
     * If "CANCEL" is not returned, then "WARN" will be returned if any of the
     * following conditions are met:
     *
     * <ul>
     * <li>Predicted wind speeds are above 45.0 mph.</li>
     * <li>Predicted precipitation is above 12.0 inches.</li>
     * </ul>
     *
     * In all other cases, this method will return "ALL CLEAR".
     *
     * @param windSpeed     wind speed in miles per hour
     * @param precipitation amount of snow in inches
     * @return "CANCEL", "WARN", or "ALL CLEAR"
     * @throws IllegalArgumentException if either argument is negative
     */

    public static String weatherAdvisory(double windSpeed, double precipitation) {

        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException();
        }

        String advice = "ALL CLEAR";

        if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_SNOWFALL
                || (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_SNOWFALL)) {
            advice = "CANCEL";
        } else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_SNOWFALL) {
            advice = "WARN";
        }

        return advice;
    }
}
