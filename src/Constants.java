public class Constants {
    public static int getCardValue(String number){
        if ("A".equals(number)) {
            return 1;
        } else if ("J".equals(number) || "K".equals(number) || "Q".equals(number) || "10".equals(number)) {
            return 10;
        }
        return Integer.parseInt(number);
    }
}
