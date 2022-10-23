package com.crazy.leetcode;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author lintingmin
 * @date 2020-08-02
 */
public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new LeetCode49().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String sortStr = sort(str);
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(str);
            } else {
                map.put(sortStr, new ArrayList<>());
                map.get(sortStr).add(str);
            }
        }

        List<List<String>> result = new ArrayList<>(map.size());
        map.values().forEach(x -> {
            result.add(x);
        });
        return result;
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
