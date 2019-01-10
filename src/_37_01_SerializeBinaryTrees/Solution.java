package _37_01_SerializeBinaryTrees;

import pojo.TreeNode;

import java.io.Serializable;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/10
 */
public class Solution {

    public String Serialize(TreeNode root) {

        StringBuilder res = new StringBuilder();
        if (root == null) {
            res.append("#,");
            return res.toString();
        }

        res.append(root.val);
        res.append(",");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));

        return res.toString();
    }


    public TreeNode Deserialize(String str) {

        if (str == null || str.length() == 0) {
            return null;
        }


        String[] strr = str.split(",");


        return deserializeHelper(strr, -1);

    }

    private TreeNode deserializeHelper(String[] strr, int index) {

        index++;

        TreeNode node = null;
        if (!"#".equals(strr[index])) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = deserializeHelper(strr, index);
            node.right = deserializeHelper(strr, index);
        }

        return node;
    }
}
