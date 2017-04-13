/**
 * title: <br/>
 * description: 描述<br/>
 * Copyright: Copyright (c)2014<br/>
 * Company: 易宝支付(YeePay)<br/>
 *
 * @author wenkang.zhang
 * @version 1.0.0
 * @since 17/4/12 下午11:19
 */
public class StackFrame {

    TreeNode node;
    int pc;

    public StackFrame(TreeNode node, int pc) {
        this.node = node;
        this.pc = pc;
    }

}
