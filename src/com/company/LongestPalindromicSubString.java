package com.company;

public class LongestPalindromicSubString {

    //4 最长回文子串
    /*
    给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：
    输入：s = "cbbd"
    输出："bb"
     */

    public String longestPalindrome(String s) {

        int maxLength = 0;
        int maxLenStart = -1;
        int maxLenEnd = -1;


        // 暴力解法，枚举每个subString，判断是否是回文
        //枚举字符串时间复杂度O(n方)，判断回文时间复杂度最坏O(n)，总体O(n三次方)

        //明显涉及拆分子问题和推导，使用动态规划

        //如果f(start, end) 是一个回文子串
        //start-1与end+1都存在且相等，则f(start-1,end+1)也是回文的
        //如果不存在或者不相等，则一定不是回文子串
        //即长串问题的结果 依赖于  短串问题的结果，先从短串开始计算

        int targetStrLen = s.length();

        //存储计算过程结果，[i][j]表示start和end的位置，值存储是否是回文
        int[][] dp = new int[targetStrLen][targetStrLen];
//        //初始化
        for (int i = 0; i<targetStrLen; i++) {
            dp[i][i] = 1;
        }

        //遍历开始，从短串开始计算
        //长度固定，从1开始到最大长度
        for (int length = 1; length <= targetStrLen; length++) {
            //start的index从0到targetStrLen-1
            for (int i = 0; i < targetStrLen; i++) {
                //end index
                int j = i + length - 1;

                //边界判定条件
                //j越界，非法跳过
                if (j > targetStrLen - 1) {
                    continue;
                }

                //现在得到了从i到j的字符串，计算过程如下

                //同递归，先确定边界条件, 边界条件如何确定参考状态转移过程中的依赖{1}
                //i+1 <= j-1 的相反条件是 i+1 > j-1，即 j-i < 2，两个index的差小于2，即等于1或0

                //两者指向同一个字符
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j - i == 1) {
                    //两者是相邻的两个字符
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
                } else {
                    //再确定状态转移表达式
                    //如果两个字符相等，需要依赖i+1,j-1子串状态，所以{1}子问题推导只适用于 i+1 <= j-1时
                    //如果i+1,j-1也是回文，则当前子串也是回文，记录长度是否是最大
                    if (s.charAt(i) == s.charAt(j)) {
                        //子串也是回文
                        if (dp[i + 1][j - 1] == 1) {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        //如果i+1,j-1不是回文，当前也不是回文，跳过当前循环遍历下一个子串
                        dp[i][j] = 0;
                    }
                }

                if (dp[i][j] == 1) {
                    //当前为回文，如果是最大数，则替换全局记录
                    if (length > maxLength) {
                        maxLength = length;
                        maxLenStart = i;
                        maxLenEnd = j;
                    }
                }
            }
        }

        //java subString打印到第二个index的前一个，需要+1
        return s.substring(maxLenStart, maxLenEnd + 1);
    }

    //中心扩展法
    public String longestPalindrome2(String s) {


        int maxLenStartIndex = 0;
        int maxLenEndIndex = 0;

        int length = s.length();

        for (int i = 0; i < length; i++) {
            int leftMaxLen = maxPalindromicSubStringLen(s, i, i);
            int rightMaxLen = maxPalindromicSubStringLen(s, i, i + 1);

            boolean isSingleCenter = leftMaxLen > rightMaxLen;
            int longerLen = isSingleCenter ? leftMaxLen : rightMaxLen;

            if (longerLen > (maxLenEndIndex - maxLenStartIndex + 1)) {
                maxLenStartIndex = isSingleCenter ? i - (longerLen-1)/2 : i - (longerLen/2 - 1);
                maxLenEndIndex = isSingleCenter ? i + (longerLen-1)/2 : i + 1 + (longerLen/2 - 1);
            }
        }

        return s.substring(maxLenStartIndex, maxLenEndIndex + 1);
    }

    private int maxPalindromicSubStringLen(String s, int possibleLeftCenterIndex, int possibleRightCenterIndex) {

        while(possibleLeftCenterIndex >= 0 && possibleRightCenterIndex < s.length()
                && s.charAt(possibleLeftCenterIndex) == s.charAt(possibleRightCenterIndex)) {
            possibleLeftCenterIndex--;
            possibleRightCenterIndex++;
        }

        //由于while循环条件，possibleRightCenterIndex - 1 和 possibleLeftCenterIndex + 1 才是真正的对称边界
        return (possibleRightCenterIndex - 1) - (possibleLeftCenterIndex + 1) + 1;
    }


    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter1(s, i, i);
            int len2 = expandAroundCenter1(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start ) {
                if(len==len1){
                    start = i - (len - 1) / 2;
                    end = i + (len-1) / 2;
                }else{
                    start = i - (len - 2) / 2;
                    end = i + len/ 2 ;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter1(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = longestPalindrome1("ccccbk");
        System.out.println(s);
    }

}
