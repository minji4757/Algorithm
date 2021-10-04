import java.util.*;

public class Player {
    //완주하지 못한 선수
    //1. 해시풀이 생각안난 첫번째 풀이
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    //2. solution1보다 해시로 사용하는게 더 빠르다 (300ms -> 60mx)
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                answer = e.getKey();
                break;
            }
        }
        return answer;
    }

    //3. getOrDefault 모를 때
    public String solution3(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.get(p) != null) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        /*Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        return null;*/
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Player().solution(new String[]{"mislav", "stanko", "mislav", "ana" }, new String[]{"stanko", "ana", "mislav" }));
    }
}
