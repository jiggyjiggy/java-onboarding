package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of();

        EmailArrayListValuePerSplitedNickNameKeyMap emailArrayListValuePerSplitedNickNameKeyMap = new EmailArrayListValuePerSplitedNickNameKeyMap();
        for (List<String> form :
                forms) {
            emailArrayListValuePerSplitedNickNameKeyMap.insertItem(form);
        }

        return answer;
    }
}

class EmailArrayListValuePerSplitedNickNameKeyMap {
    private final Map<String, ArrayList<String>> map = new HashMap<>();

    public void insertItem(List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);

        List<String> splitedNickNameList = splitByTwoToArrayList(nickname);

        insertValue(splitedNickNameList, email);
    }

    private void insertValue(List<String> KeyList, String value) {
        for (String key :
                KeyList) {
            if (map.containsKey(String.valueOf(key))) {
                map.get(key).add(value);
            } else {
                map.put(key, new ArrayList<>(Collections.singleton(value)));
            }
        }
    }

    private List<String> splitByTwoToArrayList(String str) {
        ArrayList arrayList = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i));
            sb.append(str.charAt(i + 1));

            arrayList.add(String.valueOf(sb));
        }

        return arrayList;
    }
}