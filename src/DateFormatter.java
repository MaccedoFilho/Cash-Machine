public class DateFormatter {

    public static boolean isValid(String date) {
        return !date.matches("\\d{8}");
    }

    public static String format(String date) {
        if (isValid(date)) {
            return "Invalid Date";
        }
        return date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
    }
}
