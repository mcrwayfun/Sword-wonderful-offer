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
        res.append(Serialize())

    }


    public TreeNode Deserialize(String str) {

    }
}
