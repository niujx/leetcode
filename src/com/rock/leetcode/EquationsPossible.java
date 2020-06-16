package com.rock.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-06-08
 * Time: 09:40
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 * <p>
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 * <p>
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EquationsPossible {


    //创建了一个图
    public boolean equationsPossible(String[] equations) {
        Map<String, Node> test = new HashMap<>();
        boolean flag = true;

        for (String equation : equations) {
            if (equation.contains("==")) {
                String[] split = equation.split("==");
                Node n1 = test.computeIfAbsent(split[0], k -> new Node(split[0]));
                Node n2 = test.computeIfAbsent(split[1], k -> new Node(split[1]));
                n1.nodes.add(n2);
                n2.nodes.add(n1);
            }
        }

        for (String equation : equations) {
            Set<Node> findNode = new HashSet<>();
            if (equation.contains("!=")) {
                String[] split = equation.split("!=");
                if (split[0].equals(split[1])) {
                    flag = false;
                    continue;
                }
                Node node = test.get(split[0]);
                List<String> allNode = getAllNode(node, findNode);
                flag &= !allNode.contains(split[1]);
            }
        }

        return flag;
    }

    public List<String> getAllNode(Node node, Set<Node> findNode) {
        List<String> ns = new ArrayList<>();
        if (node == null) return ns;
        findNode.add(node);
        for (Node n : node.nodes) {
            ns.add(n.key);
            if (!findNode.contains(n)) {
                ns.addAll(getAllNode(n, findNode));
            }
        }
        return ns;
    }

    static class Node {
        String key;
        List<Node> nodes = new ArrayList<>();

        public Node(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    private boolean equationsPossible2(String[] equations) {

        int[] letter = new int[26];
        for (int i = 0; i < 26; i++) {
            letter[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                letter[find(letter, a)] = find(letter, b);
            }
        }

        boolean flag = true;
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                flag &= find(letter, a) != find(letter, b);
            }
        }
        return flag;
    }


    public int find(int[] letter, int index) {
        while (letter[index] != index) {
            letter[index] = letter[letter[index]];
            index = letter[index];
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"a!=a"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"b==a", "a!=b"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"}));
        System.out.println(new EquationsPossible().equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c"}));
        System.out.println("---------------------");
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"a!=a"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"b==a", "a!=b"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"b==a", "a==b"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"c==c", "b==d", "x!=z"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"a==b", "e==c", "b==c", "a!=e"}));
        System.out.println(new EquationsPossible().equationsPossible2(new String[]{"c==c", "f!=a", "f==b", "b==c"}));

    }
}
