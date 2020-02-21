package org.jasonpep.algorithm;


import java.util.LinkedList;
import java.util.Queue;

/**
 * description: TreePrint
 * date: 2020/2/21 15:47
 * author: JASONPEP
 * version: 1.0
 */
public class TreePrint {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        TreeNode left = new TreeNode(20);
        left.setLeft(10);
        left.setRight(30);
        TreeNode right = new TreeNode(70);
        right.setLeft(60);
        right.setRight(80);
        root.left = left;
        root.right = right;
        print(root);
    }

    /**
     * 利用队列先进先出的特性 进行分层打印
     *
     * @param root 根节点
     */
    private static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // 遍历
        int cLayer = 1;
        int nextLayer = 0;
        while (!q.isEmpty()) {
            TreeNode c = q.poll();
            System.out.print(c.value + " ");
            cLayer--;

            if (c.left != null) {
                q.add(c.left);
                nextLayer++;
            }
            if (c.right != null) {
                q.add(c.right);
                nextLayer++;
            }

            // 换层
            if (cLayer == 0) {
                System.out.println();
                cLayer = nextLayer;
                nextLayer = 0;
            }

        }

    }

    private static class TreeNode {

        int value;

        TreeNode left;

        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public void setLeft(int left) {
            this.left = new TreeNode(left);
        }

        public void setRight(int right) {
            this.right = new TreeNode(right);
        }
    }

}
