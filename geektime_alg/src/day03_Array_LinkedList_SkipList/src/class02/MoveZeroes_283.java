package day03_Array_LinkedList_SkipList.src.class02;

public class MoveZeroes_283 {

    /**
     * j 记录往前交换的位置，i 作为滑动指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {       // 重合的时候，不能把后面的数置0
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
