package com.crazy.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * 399. 除法求值
 *
 * @author lintingmin
 * @date 2020-09-26
 */
public class LeetCode399 {
    public static void main(String[] args) {
//        new LeetCode399().test1();
        new LeetCode399().test2();
//        new LeetCode399().test3();
    }

    public void test1(){
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = new double[equations.size()];
        values[0] = 2.0;
        values[1] = 3.0;

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }

    public void test2(){
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "e"));
        equations.add(Arrays.asList("b", "e"));

        double[] values = new double[equations.size()];
        values[0] = 4;
        values[1] = 3.0;

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("e", "e"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }

    public void test3(){
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x1", "x4"));
        equations.add(Arrays.asList("x2", "x5"));

        double[] values = new double[equations.size()];
        values[0] = 3;
        values[1] = 0.5;
        values[2] = 3.4;
        values[3] = 5.6;

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x1", "x3"));

        double[] result = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }


    Map<String, Set<Pair<String, Double>>> map;

    /**
     * 计算结果
     * @param equations 方程式
     * @param values 方程式结果
     * @param queries 问题方程式
     * @return 计算结果
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 注: a ÷ b = c中，a为被除数，b为除数，c为商

        // map的key为除数，value为Set<pair>
        // pair中，key为被除数，value为商
        // 比如a÷b=2, b÷c=3,则map的内容为:
        // map.put(b, [<a, 2>])
        // map.put(c, [<b, 3>, <a, 6>])
        map = new HashMap<>(equations.size());

        // 存所有的被除数和除数
        Set<String> allNum = new HashSet<>(equations.size());

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            // 被除数
            String dividend = equation.get(0);
            // 除数
            String divisor = equation.get(1);

            // 构造map
            buildMap(dividend, divisor, values[i]);
            // 交换被除数和除数，再次构造map
            buildMap(divisor, dividend, 1 / values[i]);

            allNum.add(dividend);
            allNum.add(divisor);
        }


        // 结果集
        double[] results = new double[queries.size()];
        // 结果不存在，则返回 -1.0
        double noResult = -1.0;

        // 遍历问题方程式
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            // 被除数或除数在equations中不曾出现过
            if (!(allNum.contains(dividend) && allNum.contains(divisor))) {
                results[i] = noResult;
                continue;
            }
            // 被除数与除数相等
            if (Objects.equals(dividend, divisor)) {
                results[i] = 1;
                continue;
            }

            Double result = calculate(dividend, divisor);
            results[i] = null == result ? noResult : result;
        }

        return results;
    }

    /**
     * 构造map
     * @param dividend 被除数
     * @param divisor 除数
     * @value value 商
     */
    private void buildMap(String dividend, String divisor, Double value) {
        // 被除数等于除数，或者map中已存在，退出方法
        if (dividend.equals(divisor) || exist(dividend, divisor)) {
            return;
        }

        // key为被除数，value为商
        Pair pair = new Pair(dividend, value);

        Set<Pair<String, Double>> pairs = null;
        if (map.containsKey(divisor)) {
            pairs = map.get(divisor);
            pairs.add(pair);
        } else {
            pairs = new HashSet<>();
            pairs.add(pair);
            map.put(divisor, pairs);
        }

        List<Triple<String, String, Double>> triples = new ArrayList<>();

        // 如果被除数有被除数
        if (map.containsKey(dividend)) {
            // 被除数的被除数集合
            Set<Pair<String, Double>> pairsForDividend = map.get(dividend);
            for (Pair<String, Double> pairForDividend: pairsForDividend) {
                String pairKey = pairForDividend.getKey();
                Double pairValue = pairForDividend.getValue();
                pairs.add(new Pair(pairKey, pairValue * value));
                if (!exist(divisor, pairKey)) {
                    triples.add(new Triple(divisor, pairKey, 1 / (pairValue * value)));
                }
            }
        }

        // 直接在for循环里递归buildMap可能有并发修改map的风险，因此提到外面
        // 交换被除数和除数，再次构造map
        for (Triple<String, String, Double> triple: triples) {
            buildMap(triple.left, triple.middle, triple.right);
        }
    }

    /**
     * 根据被除数和除数计算结果
     * @param dividend 被除数
     * @param divisor 除数
     * @return 计算结果
     */
    private Double calculate(String dividend, String divisor) {
        Set<Pair<String, Double>> pairs = map.get(divisor);
        if (null == pairs) {
            return null;
        }
        for (Pair<String, Double> pair: pairs) {
            if (pair.getKey().equals(dividend)) {
                return pair.getValue();
            }
        }
        return null;
    }

    /**
     * 判断map中是否已存在重复数据
     * 注意: 比较被除数和除数即可，不用比较商，会有浮点数精度问题
     * @param dividend 被除数
     * @param divisor 除数
     * @return 是否已存在
     */
    private boolean exist(String dividend, String divisor) {
        Set<Pair<String, Double>> pairs = map.get(divisor);
        if (null == pairs) {
            return false;
        }
        for (Pair<String, Double> pair: pairs) {
            if (pair.getKey().equals(dividend)) {
                return true;
            }
        }
        return false;
    }

    class Triple<L, M, R> {
        private L left;
        private M middle;
        private R right;

        public Triple(L left, M middle, R right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }
    }
}
