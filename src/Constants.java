import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static int getCardValue(String number){
        if ("A".equals(number)) {
            return 1;
        } else if ("J".equals(number) || "K".equals(number) || "Q".equals(number) || "10".equals(number)) {
            return 10;
        }
        return Integer.parseInt(number);
    }

    public static List<String> CARDNUMBERS = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
}
