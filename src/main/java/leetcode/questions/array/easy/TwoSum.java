package leetcode.questions.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>示例:
 * <ul>给定 nums = [2, 7, 11, 15], target = 9; 返回 [0, 1].
 * <p>因为 nums[0] + nums[1] = 2 + 7 = 9 </ul>
 *
 * <p>链接：https://leetcode-cn.com/problems/two-sum
 * @author liujin
 * @date 2019/6/22
 * @describe
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {3,2,3};
    int target = 6;
    int[] result =twoSum2(nums,target);
    System.out.println(Arrays.toString(result));
  }

  /**
   * 时间复杂度：O(n^2)
   * 空间复杂度：O(1)
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    if(nums==null||nums.length<2)return new int[]{};
    for (int i = 0; i < nums.length-1; i++) {
      for(int j=i+1;j<nums.length;j++)
      if(nums[i]+nums[j]==target){
        result[0] = i;result[1] = j;break;
      }
    }
    return result;
  }


  /**
   * 时间复杂度：O(n)
   * 空间复杂度：O(n)
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums, int target) {
    if(nums==null||nums.length<2)return new int[]{};
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    return new int[]{};
  }
}
