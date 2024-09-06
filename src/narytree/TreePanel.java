package narytree;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private NAryTree tree;

    public TreePanel(NAryTree tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, tree.getRoot(), getWidth() / 2, 50, getWidth() / 4);
    }

    private void drawTree(Graphics g, NAryNode node, int x, int y, int xOffset) {
        if (node == null) return;

        int nodeDiameter = 40; 
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x - nodeDiameter / 2, y - nodeDiameter / 2, nodeDiameter, nodeDiameter);
        g.setColor(Color.BLACK);
        g.drawOval(x - nodeDiameter / 2, y - nodeDiameter / 2, nodeDiameter, nodeDiameter);
        g.drawString(node.getValue(), x - 10, y + 5); 

        if (node.getChildren().isEmpty()) return;

        int childX = x - xOffset * (node.getChildren().size() - 1) / 2;
        int childY = y + 100;

        for (NAryNode child : node.getChildren()) {
            g.drawLine(x, y + nodeDiameter / 2, childX, childY - nodeDiameter / 2); 
            drawTree(g, child, childX, childY, xOffset / 2);
            childX += xOffset;
        }
    }
}