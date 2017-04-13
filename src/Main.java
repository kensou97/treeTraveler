/**
 * title: <br/>
 * description: 描述<br/>
 * Copyright: Copyright (c)2014<br/>
 * Company: 易宝支付(YeePay)<br/>
 *
 * @author wenkang.zhang
 * @version 1.0.0
 * @since 17/4/11 下午1:55
 */
public class Main {
    public static void main(String[] args) {
        TreeNode tree = SampleTree.createTree(19);

        TreeTraveler.preOrder(tree);
        System.out.println();
        TreeTraveler.inOrder(tree);
        System.out.println();
        TreeTraveler.postOrder(tree);
        System.out.println();


        TreeTraveler.travelUsingStack(tree, 0, 1, 2);
        System.out.println();

        TreeTraveler.travelUsingStack(tree, 1, 0, 2);
        System.out.println();

        TreeTraveler.travelUsingStack(tree, 2, 0, 1);
        System.out.println();
    }
}
