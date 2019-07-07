package leetcode.questions.dynamicprogram.easy;

/**
 * 53. 最大子序和
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * <p>返回其最大和。
 *
 * @author liujin
 * @date 2019/7/7
 * @describe
 */
public class MaximumSubarray {

  public static void main(String[] args) {
    int[] array = {-2,1,-3,4,-1,2,1,-5,4};
    Long t1 = System.currentTimeMillis();
    int maxSub = maxSubArray1(array);
    Long t2 = System.currentTimeMillis();
    System.out.println("cost time:"+(t2-t1)+"ms");
    System.out.println(maxSub);
  }

  /**
   * <p>子序和为动态变化的值，只要为正对最终结果就有帮助的可能，
   * <p>最大自序和单独存储，在演进过程中保存最大的即可。
   * <p>时间复杂度：O(n)，单循环到 n
   * <p>空间复杂度：O(1)，使用常量级空间。
   * <p>执行测试时间3ms
   * @param nums
   * @return
   */
  public static int maxSubArray(int[] nums) {
    if(nums==null) return 0;
    if (nums.length==1) return nums[0];
    int result = nums[0];
    int subSum = nums[0];
    //使子序列和的最大值向后演进
    for (int i = 1; i < nums.length; i++) {
      if(subSum>0)subSum+=nums[i];
      else subSum = nums[i];
      if(result<subSum)result = subSum;
    }
    return result;
  }

  public static int maxSubArray1(int[] nums) {
    if(nums==null) return 0;
    if (nums.length==1) return nums[0];
    int result = nums[0];
    int subSum = 0;
    for (int i = 0; i < nums.length; i++) {
      subSum+=nums[i];//向后累加
      if(result<subSum)result = subSum;//记录子序列和的最大值
      if(subSum<0) subSum = 0;//舍弃负增长
    }
    return result;
  }

}
