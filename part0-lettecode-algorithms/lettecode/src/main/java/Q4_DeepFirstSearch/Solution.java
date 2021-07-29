package Q4_DeepFirstSearch;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 **
 **        返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 **
 **        示例 1：
 **
 **        输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 **        输出：[7,4,1]
 **        解释：
 **        所求结点为与目标结点（值为 5）距离为 2 的结点，
 **        值分别为 7，4，以及 1
 **                 3
 *                /   \
 *              5       1
 *            /   \     /   \
 *           6     2   0     8
 *                / \
 *               7    4
 **          注意，输入的 "root" 和 "target" 实际上是树上的结点。
 **          上面的输入仅仅是对这些对象进行了序列化描述。
 **  提示：
 **
 **     给定的树是非空的。
 **     树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 **     目标结点 target 是树上的结点。
 **     0 <= K <= 1000.
 **
 ** 来源：力扣（LeetCode）
 ** 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 ** 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法1：
 *      使用深度优先算法
 *
 * 借用hash表存储已经存在的值及其对应的节点位置
 *
 * 1.向下搜索子节点
 * 2.向上搜索距离自己为2的节点
 *
 * Q：如果搜了一半到根节点，距离还没到2，应该怎么搜？ --> 向没有搜过的节点方向继续搜索
 * 这里就体现了深度优先的特点：只要还没搜过的都会去搜一遍
 * 顺序是  左节点、右节点、父节点
 *
 *
 */
class Solution {
    // 记录已经访问过的父亲节点
    // 为什么是value在前,引用在后？ 因为要记录当前子节点的值以及对应的当前节点引用，体现出相对关系，在findAns中使用到
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    // 结果集
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点,放在parentsMap中
        recordParents(root);

        // 从 目标节点 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);

        return ans;
    }

    public void recordParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            recordParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            recordParents(node.right);
        }
    }

    /**
     * 寻找目标节点-- 可能有多个
     *
     * @param node  当前开始搜索的节点
     * @param from  当前节点是否有被搜索过，如果有就传入，如果没有说明是从当前开始的，就写null
     * @param depth 深度，也就是距离，在每进入一次递归迭代时都会加1
     * @param k     目标距离，题设中是2
     */
    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        // 排除边界情况：本来就是一棵空树
        if (node == null) {
            return;
        }
        // 返回条件：depth与距离k相等
        if (depth == k) {
            ans.add(node.val);
            return;
        }

        if (node.left != from) {    // 如果当前节点的左子树没有被搜索过，那就从该左节点开始搜索
            findAns(node.left, node, depth + 1, k);
        }

        if (node.right != from) {   // 如果当前节点的右子树没有被搜索过，那就从该右节点开始搜索
            findAns(node.right, node, depth + 1, k);
        }

        // 从父节点开始搜索
        if (parents.get(node.val) != from) {  // 这里的开始条件是：如果当前节点的父节点，不是刚刚向下的搜索调用的（向上的），就继续搜索（不能既向下搜索，又向上搜索，实质是给递归过程限定搜索方向的）
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String tree = "[1,2,3,4,5,6,7,8,null,9]";
        TreeNode treeNode = TreeNode.stringToTreeNode(tree);

        List<Integer> res = solution.distanceK(treeNode, treeNode, 2);
        for( Integer i:res){
            System.out.println(i);
        }
    }
}