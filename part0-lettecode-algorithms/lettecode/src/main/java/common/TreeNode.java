package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item)); // 创建根节点
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);  // 放入根节点

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove(); //从头部取出一个节点值 ,如果取出前队列是空会抛出异常

            if (index == parts.length) {
                break;
            }

            item = parts[index++];  //将parts中的值通过创建节点放入树中，先左后右
            item = item.trim();     //去除两边空格，便于转int
            if (!item.equals("null")) { //当节点值不等于 ‘null’字符串时，就放入左子树
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);   // 创建节点
                nodeQueue.add(node.left);               // 将新创建的节点放入节点队列中
            }

            if (index == parts.length) {   //如果放完左儿子节点之后，到头了，就退出
                break;
            }

            // 继续放 右儿子节点到LinkedList中
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root; // 返回根节点,也就是链表的头节点
    }

    public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {         //  如果是空则直接返回
            System.out.println("Empty tree");
            return;
        }

        // 由于输出时必须是从上向下，就规定了必须是先打印右子节点，然后打印父节点，最后打印左子节点

        if (node.right != null) {   // 先打印右子树,如果当前节点的右叶子节点还有值，则继续递归; 如果子节点为null则会跳过，什么都不打
            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val); // 任意一个节点都需要打印，根据是否是左右子节点来判断

        if (node.left != null) {    //后打印左子树,如果当前节点的左叶子节点还有值，则继续递归；如果子节点为null则会跳过，什么都不打
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void prettyPrintTree(TreeNode node) {
        prettyPrintTree(node,  "", true);
    }

    public static void main(String[] args) {
        // 二叉树都可以使用一个数组或者
        String tree = "[1,2,3,4,5,6,7,8,null,9]";
        TreeNode treeNode = TreeNode.stringToTreeNode(tree);
        TreeNode.prettyPrintTree(treeNode);
    }
}