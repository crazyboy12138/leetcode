package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 简化路径
 *
 * @author lintingmin
 * @date 2020-02-23
 */
public class LeetCode71 {
    public static void main(String[] args) {
        String[] arr = new String[] {"/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/a/../../b/../c//.//", "/a//b////c/d//././/.."};
        for (String str: arr) {
            System.out.println(str + ": " + new LeetCode71().simplifyPath(str));
        }
        System.out.println(new LeetCode71().simplifyPath("/."));
        System.out.println(new LeetCode71().simplifyPath("/home/of/foo/../../bar/../../is/./here/."));

    }


    /**
     * 遍历一次，标记无效的文件夹，然后stringBuilder拼接
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        if (Objects.isNull(path) || path.trim().length() == 0) {
            return null;
        }

//        while (path.contains("//")) {
//            path = path.replaceAll("//", "/");
//        }
//        while (path.contains("/./")) {
//            path = path.replaceAll("/\\./", "/");
//        }
        if (path.endsWith("/.")) {
            path = path.substring(0, path.length() - 2);
        }


        String[] array = path.split("/");
        int length = array.length;
        // 0无效，1有效
        int[] valid = new int[length];
        int pointer = 0;
        int[] dirIndex = new int[length];

        for (int i = 0; i < length; i++) {
            String str = array[i];
            if (str.trim().length() == 0 || str.equals(".")) {
                continue;
            }

            if (str.equals("..")) {
                valid[i] = 0;
                if (pointer > 0) {
                    valid[dirIndex[pointer]] = 0;
                    pointer--;
                }
            } else {
                valid[i] = 1;
                ++pointer;
                dirIndex[pointer] = i;
            }
        }

        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < array.length; i++) {
            String ch = array[i];
            if (valid[i] == 1 && pointer > 0) {
                sb.append(ch).append("/");
                pointer --;
            }
        }

        String result = sb.toString();
        if (!Objects.equals(result, "/")) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }
}
