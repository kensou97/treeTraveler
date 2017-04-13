import java.util.Stack;

/**
 * title: <br/>
 * description: 描述<br/>
 * Copyright: Copyright (c)2014<br/>
 * Company: 易宝支付(YeePay)<br/>
 *
 * @author wenkang.zhang
 * @version 1.0.0
 * @since 17/4/11 下午1:53
 */
public class TreeTraveler {

    public static void preOrder(TreeNode node) {
        System.out.print(node.value + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
        return;
    }

    public static void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.value + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public static void postOrder(TreeNode node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.value + " ");
    }

    public static void travelUsingStack(TreeNode node, int root, int left, int right) {
        Stack<StackFrame> stack = new Stack<StackFrame>();
        StackFrame current = new StackFrame(node, 0);//当前栈帧，局部变量：node，pc：0
        for (; ; ) {
            if (current.pc == 3) {//当前栈帧已执行到return
                if (stack.isEmpty()) {//如果栈帧已空，执行结束
                    break;
                }
                current = stack.pop();//如果还有栈帧，退栈
            }

            TreeNode currentNode = current.node;

            /*待执行行号是访问root*/
            if (current.pc == root) {
                current.pc++;
                System.out.print(currentNode.value + " ");
                continue;
            }

            /*待执行行号是访问左子树left*/
            if (current.pc == left) {
                current.pc++;
                if (currentNode.left != null) {
                    stack.push(new StackFrame(currentNode, current.pc));//左子树不为null，要递归访问左子树，先将当前栈帧入栈
                    current = new StackFrame(currentNode.left, 0);//然后设置当前栈帧为，局部变量：currentNode.left，pc：0
                }
                continue;
            }

            /*待执行行号是访问右子树right*/
            if (current.pc == right) {
                current.pc++;
                if (currentNode.right != null) {
                    stack.push(new StackFrame(currentNode, current.pc));
                    current = new StackFrame(currentNode.right, 0);
                }
                continue;
            }
        }
    }
}
