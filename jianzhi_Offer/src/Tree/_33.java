package Tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @Author: Hypocrite30
 * @Date: 2021/10/28 10:01
 */
public class _33 {
    /**
     * 后序遍历结果「左右根」
     * 二叉搜索树 -> 左树 最小，右树 最大，根 排中间
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1);
    }

    /**
     * 递归，限制区间为 [i, j]
     * 后序遍历结果为「左右根」结合二叉搜索树
     * 递归需要将 BST 拆分成左右子树，再单独递归验证后序遍历结果，所以重点是找到左右子树边界
     * 设游标 p，从左区间 i 出发，根据 BST，右树值大于根，p 从左树一直遍历下去
     * 遇到的第一个比根大的位置，就刚好进入右树的范围，设为 mid，此时已经验证了后序遍历的左树正确性
     * 游标继续移动，验证右树的正确性，即值都大于根，直到 p == j「根」
     * 左树范围 [i, mid - 1] 右树 [mid, j - 1] 根 [j]
     * 递归结束条件 i >= j -> 所有区间验证结束
     * @param postorder 后序遍历结果
     * @param i         区间左边界
     * @param j         区间右边界
     */
    private boolean recursion(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) // 找左右树分界，同时验证左数
            p++;
        int mid = p;
        while (postorder[p] > postorder[j])
            p++;
        return p == j && recursion(postorder, i, mid - 1) && recursion(postorder, mid, j - 1);
    }
}
