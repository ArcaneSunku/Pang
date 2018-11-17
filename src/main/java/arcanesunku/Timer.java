package arcanesunku;

public class Timer {

    public static double gameTime;

    private static int s, m, h, tS, tM;

    public static void update() {
        if (gameTime % 60 == 0) {
            s++;
            tS++;
        }

        if (s >= 60) {
            s = 0;
            m++;
            tM++;
        }

        if (m >= 60) {
            m = 0;
            h++;
        }
    }

    public static int getSecond() {
        return s;
    }

    public static int getMinute() {
        return m;
    }

    public static int getSeconds() {
        return tS;
    }

    public static int getMinutes() {
        return tM;
    }

    public static int getHours() {
        return h;
    }

    public static String getTimeSM() {
        String sec = "", min = "";

        if (s < 10)
            sec = "0" + s;
        else
            sec = "" + s;

        if (m < 10)
            min = "0" + m;
        else
            min = "" + m;

        return min + ":" + sec;
    }


}
