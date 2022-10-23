package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 实现 Trie (前缀树)
 *
 * @author lintingmin
 * @date 2020-04-12
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    private List<String> list;

    public Trie() {
        list = new ArrayList<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        list.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        for (String str: list) {
            if (Objects.equals(word, str)) {
                return true;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String str: list) {
            if (str.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
