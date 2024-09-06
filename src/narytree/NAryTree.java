package narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NAryTree {

    private NAryNode root;

    public NAryTree(String rootValue) {
        this.root = new NAryNode(rootValue);
    }

    public NAryNode getRoot() {
        return root;
    }

    public NAryNode findNode(NAryNode node, String value) {
        if (node.getValue().equals(value)) {
            return node;
        }
        for (NAryNode child : node.getChildren()) {
            NAryNode result = findNode(child, value);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public boolean removeNode(NAryNode node, String valueToRemove) {
        for (NAryNode child : node.getChildren()) {
            if (child.getValue().equals(valueToRemove)) {
                node.removeChild(valueToRemove);
                return true;
            }
            if (removeNode(child, valueToRemove)) {
                return true;
            }
        }
        return false;
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<NAryNode> queue = new LinkedList<>();
        queue.offer(root);
        levelOrderRecursive(queue);
    }

    private void levelOrderRecursive(Queue<NAryNode> queue) {
        if (queue.isEmpty()) {
            return;
        }
        NAryNode currentNode = queue.poll();
        System.out.print(currentNode.getValue() + " ");

        for (NAryNode child : currentNode.getChildren()) {
            queue.offer(child);
        }
        levelOrderRecursive(queue);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(NAryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        for (NAryNode child : node.getChildren()) {
            preOrder(child);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(NAryNode node) {
        if (node == null) {
            return;
        }
        for (NAryNode child : node.getChildren()) {
            postOrder(child);
        }
        System.out.print(node.getValue() + " ");
    }
}
