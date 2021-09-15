import java.util.Locale;

public class SwitchExample {

    public boolean oldIsWeekend(String day) {
        switch (day) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
                return false;
            case "saturday":
            case "sunday":
                return true;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean newIsWeekend(String day) {
        switch (day) {
            case "monday", "tuesday", "wednesday", "thursday", "friday" -> {
                return false;
            }
            case "saturday", "sunday" -> {
                return true;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public boolean condensedIsWeekend(String day) {
        return switch (day.toLowerCase(Locale.ENGLISH)) {
            case "monday", "tuesday", "wednesday", "thursday", "friday" -> false;
            case "saturday", "sunday" -> true;
            default -> throw new IllegalArgumentException();
        };
    }
}
