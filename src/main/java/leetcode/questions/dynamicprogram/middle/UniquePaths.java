package leetcode.questions.dynamicprogram.middle;

/**
 * 62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角
 * 每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问总共有多少条不同的路径？
 *
 * <p>链接：https://leetcode-cn.com/problems/unique-paths
 * @author liujin
 * @date 2019/7/17
 * @describe
 */
public class UniquePaths {

  public static void main(String[] args) {
    int m = 99;
    int n = 99;
    Long t1 = System.currentTimeMillis();
    int count = uniquePaths5(m,n);
    Long t2 = System.currentTimeMillis();
    System.out.println("cost time:"+(t2-t1)+"ms");
    System.out.println(count);
  }

  public static int uniquePaths(int m, int n) {
    if(m==2&&n==1) return 1;
    if(m==1&&n==2) return 1;
    if(m==1&&n==1) return 0;
    if(m<=0||n<=0) return 0;
    return uniquePaths(m-1,n)+uniquePaths(m,n-1);
  }

  public static int uniquePaths1(int m, int n) {
    int[][] array = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          array[i][j] = 1;
        } else {
          array[i][j] = array[i - 1][j] + array[i][j - 1];
        }
      }
    }
    return array[m - 1][n - 1];
  }

  //解法2 记忆搜索法
  public static int uniquePaths3(int m, int n){
    int[][] mem = new int[n+1][m+1];
    return uniquePaths2(m, n,1,1,mem);
  }

  //从第x列, 第y行为起点的路径数量 (1 <= x <=m, 1 <= y <=n)
  private static int uniquePaths2(int m, int n, int x, int y, int[][] mem) {
    if (mem[y][x] == 0) {
      if (y == n || x == m) {
        mem[y][x] = 1;
      }else {
        mem[y][x] = uniquePaths2(m, n, x + 1, y, mem) + uniquePaths2(m, n, x, y + 1, mem);
      }
    }
    return mem[y][x];
  }

  //解法3 公式法
  public static int uniquePaths4(int m, int n){
    int down = m+n;
    int up = Math.min(m,n);
    int a = nl(down,up);
    int b = nl(up,up);
    return a/b;
  }

  public static int nl(int down,int up){
    int mul = 1;
    for (int i = down; i >= (down-up+1); i--) {
      mul*=i;
    }
    return mul;
  }

  public static int uniquePaths5(int m, int n) {
    int N = n + m - 2;
    int k = m - 1;
    long res = 1;
    for (int i = 1; i <= k; i++)
      res = res * (N - k + i) / i;
    return (int) res;
  }

}
