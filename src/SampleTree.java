/**
 * title: <br/>
 * description: 描述<br/>
 * Copyright: Copyright (c)2014<br/>
 * Company: 易宝支付(YeePay)<br/>
 *
 * @author wenkang.zhang
 * @version 1.0.0
 * @since 17/4/11 下午1:43
 */
public class SampleTree {

    public static TreeNode createTree(int size) {
        TreeNode[] nodes = new TreeNode[size + 1];
        return createNode(nodes, 1, size);
    }

    public static TreeNode createNode(TreeNode[] nodes, int i, int size) {
        if (i > size) {
            return null;
        }

        if (nodes[i] != null) {
            return nodes[i];
        }

        nodes[i] = new TreeNode();
        nodes[i].value = i;

        nodes[i].left = createNode(nodes, 2 * i, size);
        nodes[i].right = createNode(nodes, 2 * i + 1, size);
        return nodes[i];
    }

}
