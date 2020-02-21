package org.jasonpep.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: TrieTree
 * <p> Build a trie tree, Assume that the string contains only 26 lowercase letters
 * date: 2020/2/21 17:00
 * author: JASONPEP
 * version: 1.0
 */
public class TrieTree {

    /**
     * 根节点 val 为空
     */
    private static TreeNode root = new TreeNode(null);

    static {
        String[] strings = {"adopt", "count", "county", "apple", "apply", "cat", "banana", "peach", "zap", "king"};
        for (String string : strings) {
            insert(string);
//            TreeNode node = root;
//            char[] chars = string.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                int index = chars[i] - 'a';
//                if (node.childes[index] == null) {
//                    TreeNode treeNode = new TreeNode(chars[i]);
//                    treeNode.count++;
//                    node.childes[index] = treeNode;
//                }
//                node = node.childes[index];
//            }
        }
    }

    public static void main(String[] args) {
        insert("a");
        insert("a");
        System.out.println(has("apply"));
        delete("a");
    }

    /**
     * 插入一个 新的字符串
     *
     * @param string new string
     */
    public static void insert(String string) {
        if (string == null || "".equals(string)) {
            return;
        }
        char[] chars = string.toCharArray();
        TreeNode node = null;
        TreeNode[] childes = root.childes;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            node = childes[index];
            if (node == null) {
                node = new TreeNode(chars[i]);
                childes[index] = node;
            }
            node.pathCount++;
            childes = node.childes;
        }
        if (node != null) {
            node.wordEndCount++;
        }

    }

    /**
     * 删除一个字符串
     *
     * @param string
     */
    public static boolean delete(String string) {
        char[] chars = string.toCharArray();
        TreeNode[] nodes = new TreeNode[chars.length + 1];
        int offset = 0;
        TreeNode node = root;
        nodes[offset++] = node;
        for (char c : chars) {
            if ((node = node.childes[c - 'a']) != null && c == node.val) {
                nodes[offset++] = node;
            }
        }
        if (nodes[chars.length].wordEndCount > 0) {
            for (int i = nodes.length - 1; i >= 1; i--) {
                TreeNode deleteNode = nodes[i];
                if (--deleteNode.wordEndCount == 0 & --deleteNode.pathCount == 0) {
                    TreeNode[] childes = nodes[i - 1].childes;
                    childes[deleteNode.val - 'a'] = null;
                }
            }
        }

        return false;
    }

    /**
     * 是否包含一个字符串
     *
     * @param string
     * @return
     */
    public static boolean has(String string) {
        char[] chars = string.toCharArray();
        TreeNode node = root;
        for (char c : chars) {
            node = node.childes[c - 'a'];
            if (node == null || c != node.val) {
                return false;
            }
        }
        return node.wordEndCount > 0;
    }

    void print() {
        // print the tree
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cLayer = 1;
        int nextLayer = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            cLayer--;
            System.out.print(node.val + " ");
            for (int i = 0; i < node.childes.length; i++) {
                if (node.childes[i] == null) {
                    continue;
                }
                q.add(node.childes[i]);
                nextLayer++;
            }
            if (cLayer == 0) {
                cLayer = nextLayer;
                nextLayer = 0;
                System.out.println();
            }
        }

        System.out.println(1);

    }

    private static class TreeNode {

        /**
         * 经过此字符的字符串数量
         */
        int pathCount = 0;

        /**
         * 是否有字符串在这里终结
         */
        int wordEndCount = 0;

        char val;

        TreeNode[] childes = new TreeNode[26];

        public TreeNode(char val) {
            this.val = val;
        }

        public TreeNode(String val) {
            this.val = val == null ? 0 : val.charAt(0);
        }
    }
}
