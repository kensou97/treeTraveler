##用栈遍历树的通用方法

####简介
用栈实现树的遍历，网上大多数方法差异较大，前序中序后序仿佛是三种截然不同的实现。在这里用纯模拟递归的方式实现。
定义一个栈帧，保存局部变量（这里只有node变量）与程序计数器（pc）。程序计数器总是指向下一条要执行的语句，定义如下，以前序遍历为例子：

    public static void preOrder(TreeNode node) {

        System.out.print(node.value + " ");/*pc==0*/

        /*---------------------------------------------------------------*/
        if (node.left != null) {
            preOrder(node.left); /*pc==1*/
        }
        /*---------------------------------------------------------------*/

        /*---------------------------------------------------------------*/
        if (node.right != null) {
            preOrder(node.right);/*pc==2*/
        }
        /*---------------------------------------------------------------*/


        return;/*pc==3*/
    }
可以认为树的遍历需要4条执行语句，其中pc==3代表return语句，执行到此，当前栈帧退出，如果堆栈中还有其他的方法栈帧，此时就需要退栈。
而前序中序后序的区别，不过只在于pc==0,1,2的顺序：

1. 对于前序来说，pc==0为访问根，pc==1为访问左子树，pc==2为访问右子树；
2. 对于中序来说，pc==0为访问左子树，pc==1为访问根，pc==2为访问右子树；
3. 对于后序来说，pc==0为访问左子树，pc==1为访问右子树，pc==2为访问根；

当然，你还可以定义其他奇怪的遍历顺序，比如右左根、根右左，这只是改变几个参数的问题。

我们定义一个栈帧来保存程序的执行情况：

    public class StackFrame {

        TreeNode node;
        int pc;

        public StackFrame(TreeNode node, int pc) {
            this.node = node;
            this.pc = pc;
        }   

    }

####示例

    //前序（根左右）
    TreeTraveler.travelUsingStack(tree, 0, 1, 2);
    System.out.println();

    //中序（左根右）
    TreeTraveler.travelUsingStack(tree, 1, 0, 2);
    System.out.println();

    //后序（左右根）
    TreeTraveler.travelUsingStack(tree, 2, 0, 1);
    System.out.println();