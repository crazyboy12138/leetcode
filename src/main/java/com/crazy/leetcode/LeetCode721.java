package com.crazy.leetcode;


import java.util.*;

/**
 * 账户合并
 *
 * @author lintingmin
 * @date 2020-02-15
 */
public class LeetCode721 {
    public static void main(String[] args) {
        String str = "[\n" +
                "[\"David\",\"David0@m.co\",\"David1@m.co\"],\n" +
                "[\"David\",\"David3@m.co\",\"David4@m.co\"],\n" +
                "[\"David\",\"David4@m.co\",\"David5@m.co\"],\n" +
                "[\"David\",\"David2@m.co\",\"David3@m.co\"],\n" +
                "[\"David\",\"David1@m.co\",\"David2@m.co\"]]";
//        Object parse = JSON.parse(str);
//        List<List<String>> account = (List<List<String>>)parse;
//        System.out.println(new LeetCode721().accountsMerge(account));
    }


    // key为son，value为father
    private Map<String, String> fatherMap = new HashMap<>();

    /**
     * 并查集
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (Objects.isNull(accounts) || accounts.isEmpty()) {
            return null;
        }

        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                // 每个email的father初始化为自己
                fatherMap.put(list.get(j), list.get(j));
                indexMap.put(list.get(j), i);
            }
        }

        // 合并节点
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            if (Objects.isNull(account) || account.isEmpty()) {
                continue;
            }
            String firstEmail = account.get(1);
            for (int j = 2; j < account.size(); j++) {
                merge(firstEmail, account.get(j));
            }
        }

        List<List<String>> result = new ArrayList<>();
        // key为father，value为该father的子节点组成的set
        Map<String, TreeSet> father2SetMap = new HashMap<>();

        // 构造father2SetMap
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                String father = findFather(email);
                if (father2SetMap.containsKey(father)) {
                    father2SetMap.get(father).add(email);
                } else {
                    TreeSet<String> set = new TreeSet<>();
                    set.add(email);
                    father2SetMap.put(father, set);
                }
            }
        }

        // 把father2SetMap转化为List<List<String>>
        Set<String> fatherSet = father2SetMap.keySet();
        for (String father: fatherSet) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(indexMap.get(father)).get(0));
            list.addAll(father2SetMap.get(father));
            result.add(list);
        }

        return result;

    }

    /**
     * 寻找该节点的父节点
     * @param email
     * @return
     */
    private String findFather (String email) {
        if (fatherMap.get(email).equals(email)) {
            return email;
        }
        // 寻找的过程中，把father设置为最上层的father
        String father = findFather(fatherMap.get(email));
        fatherMap.put(email, father);
        return father;
    }

    /**
     * 合并节点
     * @param email1
     * @param email2
     */
    private void merge (String email1, String email2) {
        String father1 = findFather(email1);
        String father2 = findFather(email2);
        if (!father1.equals(father2)) {
            fatherMap.put(father1, father2);
        }
    }
}
