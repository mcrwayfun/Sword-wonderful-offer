package utils;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/19
 */
public class TreeNodeUtil {

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        if (root == null) {
            return reList;
        }
        preOrder(root, reList);

        return reList;
    }

    private static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        if (root == null) {
            return reList;
        }
        inOrder(root, reList);

        return reList;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
