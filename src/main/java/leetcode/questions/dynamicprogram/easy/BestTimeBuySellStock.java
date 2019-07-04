package leetcode.questions.dynamicprogram.easy;

/**
 * 121. 买卖股票的最佳时机
 * <p>给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>注意你不能在买入股票前卖出股票。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * @author liujin
 * @date 2019/7/4
 * @describe
 */
public class BestTimeBuySellStock {

  public static void main(String[] args) {
    int[] prices = {1,2,4};
    int profit = maxProfit(prices);
    System.out.println(profit);
  }

  private static int maxProfit(int[] prices) {

    if (prices==null||prices.length<2)return 0;
    int length = prices.length;
    int start = prices[0];
    int end = prices[1];
    int profile = 0;
    for (int i = 1; i < length; i++) {

      if(start>prices[i]){
        start = prices[i];
        end = prices[i];//至少保证结束不在开始位置之前
      }
      if(prices[i]>=end){//如果第i次价格大于上次价格，向后演进为更大数
        end = prices[i];
      }
      if(profile<end-start){//保存获利更大的价差
        profile = end - start;
      }
    }
    return (profile<0)?0:profile;
  }

}
