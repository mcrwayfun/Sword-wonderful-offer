package _34_01_PathInTree;

import pojo.TreeNode;

import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/7
 */
public class Solution {

    private ArrayList<ArrayList<Integer>> reList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return reList;
        }

        // find the path
        findPath(root, target, new ArrayList<>());

        return reList;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        target -= root.val;
        // if target is 0 and the node is leaf node
        if (target == 0 && root.left == null && root.right == null) {
            reList.add(new ArrayList<>(list));
        } else {
            // recursive the tree
            findPath(root.left, target, list);
            findPath(root.right, target, list);
        }

        // remove the last element
        list.remove(list.size() - 1);
    }
}
