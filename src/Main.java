import java.util.HashMap;
import java.util.Map;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = textToMap(text);
        System.out.println(maxCharAtMap(map) + " встречается " + map.get(maxCharAtMap(map)));
        System.out.println(minCharAtMap(map) + " встречается " + map.get(minCharAtMap(map)));
    }

    public static Map<Character, Integer> textToMap(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (map.containsKey(ch)) {
                    map.replace(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
        }
        return map;
    }

    public static char maxCharAtMap(Map<Character, Integer> map) {
        int max = 0;
        char maxChar = 0;
        for (Map.Entry<Character, Integer> ch : map.entrySet()) {
            if (ch.getValue() > max) {
                maxChar = ch.getKey();
                max = ch.getValue();
            }
        }
        return maxChar;
    }

    public static char minCharAtMap(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        char minChar = 0;
        for (Map.Entry<Character, Integer> ch : map.entrySet()) {
            if (ch.getValue() < min) {
                minChar = ch.getKey();
                min = ch.getValue();
            }
        }
        return minChar;
    }
}