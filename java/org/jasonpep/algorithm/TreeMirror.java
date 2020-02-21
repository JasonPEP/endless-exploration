package org.jasonpep.algorithm;

import java.util.Stack;

/**
 * description: TreeMirror 二叉树的镜像
 * <p> 输入一个二叉树  返回他的镜像
 * date: 2020/2/21 14:50
 * author: JASONPEP
 * version: 1.0
 */
public class TreeMirror {

    /**
     * 基于递归
     *
     * @param node 根节点
     * @return 新的节点
     */
    private static TreeNode mirrorWithRecursive(TreeNode node) {
        if (node != null) {
            if (node.getRightChildNode() != null) {
                node.setLeftChildNode(mirrorWithRecursive(node.getRightChildNode()));
            }

            if (node.getLeftChildNode() != null) {
                node.setRightChildNode(mirrorWithRecursive(node.getLeftChildNode()));
            }
        }
        return node;
    }

    /**
     * 基于容器
     *
     * @param node 根节点
     * @return
     */
    private static TreeNode mirrorWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        TreeNode c;
        while (!stack.isEmpty()) {
            c = stack.pop();
            if (c.getLeftChildNode() != null) {
                stack.push(c.getLeftChildNode());
            }
            if (c.getRightChildNode() != null) {
                stack.push(c.getRightChildNode());
            }

            TreeNode tmp = c.getLeftChildNode();
            c.setLeftChildNode(c.getRightChildNode());
            c.setRightChildNode(tmp);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        TreeNode cLeft = new TreeNode(20);
        cLeft.setLeftChildNode(new TreeNode(10));
        cLeft.setRightChildNode(new TreeNode(30));
        TreeNode cRight = new TreeNode(70);
        cRight.setLeftChildNode(new TreeNode(60));
        cRight.setRightChildNode(new TreeNode(80));
        root.setRightChildNode(cRight);
        root.setLeftChildNode(cLeft);
//        mirrorWithStack(root);
        mirrorWithRecursive(root);
    }

    /**
     * 数据结构
     */
    public static class TreeNode {

        private int value;

        private TreeNode leftChildNode;

        private TreeNode rightChildNode;

        public TreeNode(int value, TreeNode leftChildNode, TreeNode rightChildNode) {
            this.value = value;
            this.leftChildNode = leftChildNode;
            this.rightChildNode = rightChildNode;
        }

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeftChildNode() {
            return leftChildNode;
        }

        public void setLeftChildNode(TreeNode leftChildNode) {
            this.leftChildNode = leftChildNode;
        }

        public TreeNode getRightChildNode() {
            return rightChildNode;
        }

        public void setRightChildNode(TreeNode rightChildNode) {
            this.rightChildNode = rightChildNode;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
