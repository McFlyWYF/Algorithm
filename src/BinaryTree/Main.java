package BinaryTree;

public class Main {

    /**
     * 二叉树节点类
     */

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，重新建造该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含有重复的数字。
     */

    public BinaryTreeNode construct(int[] preorder, int[] inorder) {
        //输入的合法性判断，不能为空，数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */

    public BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        //开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }

        //取前序遍历的第一个数字，就是当前的根结点
        int value = preorder[ps];
        int index = is;

        //中序遍历的数组中找根结点的位置
        while (index <= ie && inorder[index] != value) {
            index++;
        }

        //如果在整个中序遍历的数组中没有找到，说明输入的参数不合法
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        //创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        /*
         *递归构建当前根结点的左子树，元素个数:index-is+1
         * 左子树对应得前序遍历的位置在[ps_1,ps+index-is]
         * 左子树对应的中序遍历的位置在[is,index-1]
         */
        node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);

        /*
         *递归构建当前根结点的右子树，元素个数:ie - index
         * 左子树对应得前序遍历的位置在[ps+index-is+1,pe]
         * 左子树对应的中序遍历的位置在[index+1,ie]
         */
        node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

        //返回创建的根结点
        return node;
    }

    //中序遍历二叉树
    public void printTree(BinaryTreeNode root){
        if (root != null){
            printTree(root.left);
            System.out.println(root.value + " ");
            printTree(root.right);
        }
    }

    //一般二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8

    private void OrdinaryBinaryTree(){
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = construct(preorder,inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private void NoRightNode(){
        int[] preorder = {1,2,3,4,5};
        int[] inorder = {5,4,3,2,1};
        BinaryTreeNode root = construct(preorder,inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5

    private void NoLeftNode(){
        int[] preorder = {1,2,3,4,5};
        int[] inorder = {1,2,3,4,5};
        BinaryTreeNode root = construct(preorder,inorder);
        printTree(root);
    }

    //树中只有一个结点
    private void OnlyOneNode(){
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder,inorder);
        printTree(root);
    }


    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private void FullBinaryTree(){
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,8,1,6,3,7};
        BinaryTreeNode root = construct(preorder,inorder);
        printTree(root);
    }

    //输入的两个序列不匹配
    private void NoSite(){
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,8,1,6,3,7};
        BinaryTreeNode root = construct(preorder,inorder);
        printTree(root);
    }

    //输入空指针
    private void NullPoints(){
        construct(null,null);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.OrdinaryBinaryTree();
        System.out.println();
        main.NoLeftNode();
        System.out.println();
        main.NoRightNode();
        System.out.println();
        main.FullBinaryTree();
        System.out.println();
        main.NoSite();
        System.out.println();
        main.OnlyOneNode();
        System.out.println();
        main.NullPoints();
    }
}
