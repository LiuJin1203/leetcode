package leetcode.questions.dynamicprogram.easy;

/**
 * @author liujin
 * @date 2019/12/31
 * @since JDK8
 */
public class ReviewTest {

  public static void main(String[] args) {
    climbStairs();
    System.out.println();
    houseRobber();
    System.out.println();
    bestTimeBuySellStock();
    System.out.println();
    maxSumSubarray();
  }

  private static void maxSumSubarray() {
    int[] nums = {2,7,1,2,-9,2,-15};
    int r = maxSumSubarray(nums);
    System.out.printf("Subarray maxSum : %d",r);
  }

  private static int maxSumSubarray(int[] nums) {
    //dp[i] = max(n[i],dp[i-1]+n[i])
    if(nums==null) return 0;
    int current = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      current = Math.max(nums[i],current+nums[i]);
      if (max<current)max=current;
    }
    return max;
  }

  private static void bestTimeBuySellStock() {
    int[] nums = {2,7,1,2,9,2,15};
    int r = bestTimeBuySellStock2(nums);
    System.out.printf("SellStock : %d",r);
  }

  private static int bestTimeBuySellStock(int[] nums) {
    int last = 0 ;
    int profile = 0;
    for (int i = 0; i < nums.length-1; i++) {
      last = Math.max(0,last+nums[i+1]-nums[i]);
      profile = Math.max(profile,last);
    }
    return profile;
  }

  private static int bestTimeBuySellStock2(int[] price) {
    int min = Integer.MAX_VALUE ;
    int maxprofile = 0;
    for (int i = 0; i < price.length; i++) {
      if (min>price[i])min = price[i];
      else if(price[i]-min>maxprofile)maxprofile=price[i]-min;
    }
    return maxprofile;
  }



  private static void climbStairs() {
    int n =  44;//1134903170
    int r = climbStairs(n);
    System.out.printf("n is %d,F-climbStatis : %d",n,r);
  }

  private static int climbStairs(int n) {
    if(n<3) return n;
    int lastOne = 2;
    int lastTwo = 1;
    for (int i = 3; i <= n; i++) {
      lastOne += lastTwo;
      lastTwo = lastOne - lastTwo;
    }
    return lastOne;
  }


  private static void houseRobber() {
    int[] nums = {8,3,1,8,2};
    int[] nums2 = {2,7,1,2,9,1};
    int[] nums3 = {1,2,3,1};
    int r = houseRobber(nums2);
    System.out.printf("houseRobber : %d",r);
  }

  //dp[i] = Max( dp[i-1],num[i]+dp[i-2],num[i]+dp[i-3] )
  private static int houseRobber(int[] nums) {
    if (nums==null||nums.length==0)return 0;
    if (nums.length==1)return nums[0];
    if (nums.length==2)return Math.max(nums[0],nums[1]);
    if (nums.length==3)return Math.max(nums[1],nums[0]+nums[2]);
    //初始条件
    int current = nums[3];
    int last1 = Math.max(nums[1],nums[0]+nums[2]);
    int last2 = Math.max(nums[0],nums[1]);
    int last3 = nums[0];
    int max = nums[3];
    for (int i = 3; i < nums.length; i++) {
      current =  Math.max( Math.max(last1,nums[i]+last2),nums[i]+last3);
      max = Math.max(current,max);
      last3 = last2;
      last2 = last1;
      last1 = current;
    }
    return current;
  }


}
