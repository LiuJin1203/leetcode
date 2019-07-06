package leetcode.questions.dynamicprogram.easy;

/**
 * 198. 打家劫舍
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 链接：https://leetcode-cn.com/problems/house-robber
 *
 * @author liujin
 * @date 2019/7/5
 * @describe
 */
public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = {8,3,1,8,2};
    int money = rob(nums);
    System.out.println(money);
  }

  /**
   * 迭代式将最大获利向后演进，而不是关心具体的下标索引
   * <p>时间复杂度：O(n)，单循环到 n
   * <p>空间复杂度：O(1)，使用常量级空间。
   * @param nums
   * @return
   */
  public static int rob(int[] nums) {
    if(nums==null||nums.length==0)return 0;
    if(nums.length==1)return nums[0];
    int sumOdd = 0;//奇数和
    int sumEven = 0;//偶数和
    for (int i = 0; i < nums.length; i++) {
      if(i%2==0){
        sumEven += nums[i];
        //累加到这个偶数时，还不如加到前一项的奇数和大，
        //那么把更大的数替换到偶数和上,让偶数和保持最大值向后演进
        sumEven = Math.max(sumEven,sumOdd);
      }else{
        sumOdd += nums[i];
        sumOdd = Math.max(sumEven,sumOdd);
      }
    }
    return Math.max(sumOdd,sumEven);
  }
}
