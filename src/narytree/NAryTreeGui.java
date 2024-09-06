package narytree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NAryTreeGui extends JFrame {

    private NAryTree tree;
    private TreePanel treePanel;

    public NAryTreeGui() {
        String rootValue = JOptionPane.showInputDialog(this, "Enter the value of the root node:");
        if (rootValue == null || rootValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Root node value cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        tree = new NAryTree(rootValue);
        setTitle("  N-ary Tree  ");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("N-ary Tree");
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Node");
        JButton removeButton = new JButton("Remove Node");
        JButton travelButton = new JButton("Level Order Traversal");
        JButton preOrderButton = new JButton("PreOrder");
        JButton postOrderButton = new JButton("PostOrder");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(travelButton);
        buttonPanel.add(preOrderButton);
        buttonPanel.add(postOrderButton);
        add(buttonPanel, BorderLayout.SOUTH);

        treePanel = new TreePanel(tree);
        JScrollPane scrollPane = new JScrollPane(treePanel);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNode();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeNode();
            }
        });

        travelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" ");
                System.out.println("Level Order: ");
                tree.levelOrder();               
            }
        });
        preOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" ");
                System.out.println("Pre Order: ");
                tree.preOrder();
            }
        });
        postOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" ");
                System.out.println("Post Order: ");
                tree.postOrder();
            }
        });
                

        setVisible(true);
    }

    private void addNode() {

        String parentValue = JOptionPane.showInputDialog(this, "Enter parent node value:");
        String newValue = JOptionPane.showInputDialog(this, "Enter the value of the new node:");

        if (parentValue == null || newValue == null || newValue.isEmpty()) {
            return;
        }

        NAryNode parentNode = tree.findNode(tree.getRoot(), parentValue);
        if (parentNode != null) {
            parentNode.addChild(new NAryNode(newValue));
            treePanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Parent node not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeNode() {
        String valueToRemove = JOptionPane.showInputDialog(this, "Enter the value of the node to remove:");

        if (valueToRemove == null || valueToRemove.isEmpty()) {
            return;
        }

        if (tree.getRoot().getValue().equals(valueToRemove)) {
            JOptionPane.showMessageDialog(this, "Cannot remove the root node.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (tree.removeNode(tree.getRoot(), valueToRemove)) {
                treePanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Node not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new NAryTreeGui();
    }
}
