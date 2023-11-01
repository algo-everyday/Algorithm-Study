import java.util.*;
public class Main {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> player = new HashMap<String, Integer>();
        ArrayList<String> arrayList = new ArrayList<>();

        String name = "";

        for (String key : participant) player.put(key, player.getOrDefault(key, 0) + 1);
        for (String key : completion) player.put(key, player.get(key) - 1);

        for(String key : player.keySet()) {
            if(player.get(key) != 0) {
                name = key;
            }
        }
        return name;
    }
}




