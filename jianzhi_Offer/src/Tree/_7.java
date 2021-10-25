package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @Description: 剑指 Offer 07. 重建二叉树
 * @Author: Hypocrite30
 * @Date: 2021/10/25 12:12
 */
public class _7 {

    private int[] preorder;
    // 保存中序遍历结果,k-结点值 v-索引,方便找根节点在中序遍历的索引，划分左右子树
    private Map<Integer, Integer> indexOfInorder = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            indexOfInorder.put(inorder[i], i);
        return recursionBuildTree(0, 0, inorder.length - 1);
    }

    /**
     * 「i」为中序遍历里 根 的位置
     * 左子树：根 pre「root+1」 中序范围：「left, i - 1」
     * 右子树：根 pre「root+(i-left)+1」(根+左子树长度+1) 中序范围：「i + 1, right」
     * @param pre_root 前序遍历 根索引
     * @param in_left  中序遍历 左边界索引
     * @param in_right 中序遍历 右边界索引
     */
    private TreeNode recursionBuildTree(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        //每次递归只构造当前根节点，从前序遍历里面拿值
        TreeNode node = new TreeNode(preorder[pre_root]);
        int i = indexOfInorder.get(preorder[pre_root]); // 划分左右子树
        node.left = recursionBuildTree(pre_root + 1, in_left, i - 1);
        node.right = recursionBuildTree(pre_root + i - in_left + 1, i + 1, in_right);
        return node;
    }
}
