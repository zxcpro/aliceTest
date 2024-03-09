package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class CanFinish {

    /*
    207 课程表
    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

    示例 1：
    输入：numCourses = 2, prerequisites = [[1,0]]
    输出：true
    解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    示例 2：
    输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    输出：false
    解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     */

    /*
    思路，深度遍历，没有环就能遍历，有环就不行
    借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
    i == 0 ： 干净的，未被 DFS 访问
    i == -1：其他节点启动的 DFS 访问过了，路径没问题，不需要再访问了
    i == 1  ：本节点启动的 DFS 访问过了，一旦遇到了也说明有环了
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dependenceList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            dependenceList.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            dependenceList.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs(dependenceList, flags, i)) return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }
}
