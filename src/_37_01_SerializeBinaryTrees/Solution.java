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


    private int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
