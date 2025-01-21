import java.util.*;
public class Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Binary Tree is Created");
        
        System.out.print("Preorder Traversal");
        System.out.println();
        preorder(root);
        System.out.println();
        System.out.print("Inorder Traversal");
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.print("Postorder Traversal");
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.print("Level Order Traversal");
        System.out.println();
        levelOrder(root);
    }
        // Preorder Traversal
        public static void preorder(TreeNode root){
            if(root==null) return;
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
        // Inorder Traversal
    public static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // Postorder Traversal
    public static void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // Level Order Traversal
    public static void levelOrder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }
}
