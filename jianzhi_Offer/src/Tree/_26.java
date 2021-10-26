package Tree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @Description: 剑指 Offer 26. 树的子结构
 * @Author: Hypocrite30
 * @Date: 2021/10/26 17:36
 */
public class _26 {
    /**
     * 1.对 A B 判空
     * 2.三种情况。三者满足一点即可
     * - 2.1 当前 A B 拟合，以 A B 为两树根节点开始递归下去判断
     * - 2.2 A B 不拟合，A 左孩子为根节点 和 B 拟合
     * - 2.3 A B 不拟合，A 右孩子为根节点 和 B 拟合
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recursionJudge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 1. B 遍历到头了，满足
     * 2. A 先到头，或 A B 值不同，不满足
     * 3. 两树同步对它们左右孩子递归判断
     */
    private boolean recursionJudge(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recursionJudge(A.left, B.left) && recursionJudge(A.right, B.right);
    }
}
