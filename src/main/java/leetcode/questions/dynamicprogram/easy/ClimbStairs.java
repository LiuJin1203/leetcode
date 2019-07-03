package leetcode.questions.dynamicprogram.easy;

/**
 * 70. 爬楼梯
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶
 * <p>示例：</>
 *
 * <p>链接:https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author liujin
 * @date 2019/7/3
 * @describe
 */
public class ClimbStairs {

  public static void main(String[] args) {
    int n= 44; //1134903170
    Long t1 = System.currentTimeMillis();
    int ways = climbStairs2(n);
    Long t2 = System.currentTimeMillis();
    System.out.println(ways);
    System.out.println("cost time:"+(t2-t1)+"ms");
  }

  /**
   * 斐波那契数列的直接递归调用
   * <p>此方法性能极差
   * <p>时间复杂度：O(2^n)，树形递归的大小为 2^n。
   * <p>空间复杂度：O(n)，递归树的深度可以达到 n。
   * @param n
   * @return
   */
  public static int climbStairs(int n) {
    if(n<=0) return 0;
    if(n==1)return 1;
    if(n==2)return 2;
    return climbStairs(n-1)+climbStairs(n-2);
  }

  /**
   * 斐波那契数列的非递归调用(演进式写法)
   * <p>时间复杂度：O(n)，单循环到 n，需要计算第 n 个斐波那契数
   * <p>空间复杂度：O(1)，使用常量级空间。
   * @param n
   * @return
   */
  public static int climbStairs2(int n) {
    //int型整数越界情况暂不考虑
    if(n<=0) return 0;
    if(n==1)return 1;
    if(n==2)return 2;
    int lastOne = 1 ;
    int lastTwo = 2 ;
    for (int i = 3; i <= n; i++) {
      lastTwo = lastOne + lastTwo;//向后演进一个数
      lastOne = lastTwo - lastOne;//向后演进一个数
    }
    return lastTwo;
  }
}
