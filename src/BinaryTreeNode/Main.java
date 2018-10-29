package BinaryTreeNode;

public class Main {

    /**
     * 二叉树的树结点
     */

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 完成一个函数，输入一个二叉树，该和拿书输出它的镜像。
     * 实现思想：左右两个结点进行交换。
     */

    public static void mirror(BinaryTreeNode node){
        //当前结点不为空则进行操作
        if (node != null){
            //交换结点左右两个子树
            BinaryTreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            //对结点的左右两个子树进行处理
            mirror(node.left);
            mirror(node.right);
        }
    }

    //中序遍历
    public static void printTree(BinaryTreeNode node){
        if (node != null){
            printTree(node.left);
            System.out.print(node.value + " ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        //       8
        //     /   \
        //    6     10
        //   / \    / \
        //   5  7   9  11

        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 8;
        root.left = new BinaryTreeNode();
        root.left.value = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.value = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.value = 11;

        System.out.print("原二叉树为：");
        printTree(root);
        System.out.println();
        System.out.print("镜像翻转后的二叉树为：");
        mirror(root);
        printTree(root);
    }
}
