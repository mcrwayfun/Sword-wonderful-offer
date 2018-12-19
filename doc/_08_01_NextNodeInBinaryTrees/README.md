## 二叉树的下一个结点

### 题目描述

给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。结构如下：

```java
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return val + "";
    }
}
```



### 思路1

这道理的意思是在中序遍历中，找某节点的下一个节点，并输出该节点。（注意，传入的pNode并不是根节点）

![](https://ws1.sinaimg.cn/large/0062R7s4gy1fyc1x0ek9tj309207z74l.jpg)

现有二叉树如果所示，其中序遍历为[d,b,h,e,i,a,f,c,g]则思路可以概括为以下4种：

1. pNode存在右子树，则其next节点必定是右子树的最左节点。比如上图的b节点，其next节点为h
2. pNode不存在右子树且不存在父节点，则它的下一个节点必定不存在（pNode为根节点）
3. pNode不存在右子树，但是存在父节点，且它是父节点的左孩子，则next节点为其父节点。比如上图的d节点，其next节点为b
4. pNode不存在右子树，但是存在父节点，且它是父节点的右孩子，则其next节点需要顺着pNode的父节点向上找到某节点node，node节点是其父节点的左孩子，则node节点的父节点就是pNode的下一个节点。比如上图中的i节点，其next节点为a

### 方法1

```java
public class Solution {

    /**
     * 获取中序遍历的下一个节点
     *
     * @param pNode 某个节点
     * @return pNode的下一个节点
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        // pNode的右子树不为空，则下一个节点必定为其右子树最左节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            if (right.left != null) {
                right = right.left;
            }
            return right;
        }
        // pNode右子树为空且不存在父节点，则pNode为根节点
        // 不存在中序遍历下一个节点，直接返回null
        else if (pNode.next == null) {
            return null;
        }
        // pNode不存在右子树且存在父节点
        else {

            // pNode是其父节点的左孩子
            if (pNode.next.left == pNode) {
                return pNode.next;
            }

            // pNode是其父节点的右孩子
            // 沿着父节点向上找到某个节点，这个节点是其父节点的左孩子
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {
                    return pNode.next;
                }

                pNode = pNode.next;
            }

            return null;
        }
    }
}
```

- time complexity：O(logn)
- space complexity：O(1)