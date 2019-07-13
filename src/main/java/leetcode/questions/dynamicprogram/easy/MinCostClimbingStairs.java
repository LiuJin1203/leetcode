package leetcode.questions.dynamicprogram.easy;

/**
 * 746. 使用最小花费爬楼梯
 * <p>数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * <p>链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 *
 * @author liujin
 * @date 2019/7/7
 * @describe
 */
public class MinCostClimbingStairs {

  public static void main(String[] args) {
    int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int[] cost2 = {10, 15, 20};
    Long t1 = System.currentTimeMillis();
    int minCost = minCostClimbingStairs1(cost1);
    Long t2 = System.currentTimeMillis();
    System.out.println("cost time:"+(t2-t1)+"ms");
    System.out.println(minCost);
  }

  /**
   * <p>假设爬到第i阶梯需要的花费f(i),第i+1阶梯需要f(i+1)
   * <p>根据爬楼梯规则，从第i阶只能网上爬1阶或者2阶，且花费都是cost[i]
   * <p>那么可以推出：f(i+2) = min( (f(i)+cost[i]),(f(i+1)+cost[i+2]) )
   * <p>初始条件：爬到第0个阶梯和第1个阶梯需要花费0，即f(0)=0,f(1)=0
   * <p>终止条件：爬到楼顶的最小花费为达到数组长度(数组里数值个数比数组长度小1)台阶的位置，即f(cost.length)
   * <p>时间复杂度：O(n)，单循环到 n
   * <p>空间复杂度：O(n)。
   * @param cost
   * @return
   */
  public static int minCostClimbingStairs(int[] cost) {
    if (cost==null) return  -1;
    if(cost.length==1)return 0;
    int[] f = new int[cost.length+1];
    f[0] = 0;
    f[1] = 0;
    for (int i = 0; i < cost.length-1; i++) {
      f[i+2] = Math.min((f[i]+cost[i]),(f[i+1]+cost[i+1]));
      System.out.println(f[i+2]);
    }
    return f[cost.length];
  }

  /**
   * <p>假设爬到第i阶梯需要的花费f(i),第i+1阶梯需要f(i+1)
   * <p>根据爬楼梯规则，从第i阶只能网上爬1阶或者2阶，且花费都是cost[i]
   * <p>那么可以推出：f(i+2) = min( (f(i)+cost[i]),(f(i+1)+cost[i+2]) )
   * <p>初始条件：爬到第0个阶梯和第1个阶梯需要花费0，即f(0)=0,f(1)=0
   * <p>终止条件：爬到楼顶的最小花费为达到数组长度(数组里数值个数比数组长度小1)台阶的位置，即f(cost.length)
   * <p>时间复杂度：O(n)，单循环到 n
   * <p>空间复杂度：O(1)，使用常量级空间。
   * @param cost
   * @return
   */
  public static int minCostClimbingStairs1(int[] cost) {
    if (cost==null) return  -1;
    if(cost.length==1)return 0;
    int fa = 0;
    int fb = 0;
    int temp =0;
    for (int i = 0; i < cost.length-1; i++) {
      temp = Math.min((fa+cost[i]),(fb+cost[i+1]));
      fa = fb;
      fb = temp;
      System.out.println(fb);
    }
    return fb;
  }
}
