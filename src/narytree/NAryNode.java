package narytree;
import java.util.ArrayList;

public class NAryNode {
    private String value;
    private ArrayList<NAryNode> children;

    public NAryNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public ArrayList<NAryNode> getChildren() {
        return children;
    }

    public void addChild(NAryNode childNode) {
        this.children.add(childNode);
    }

    public void removeChild(String value) {
        this.children.removeIf(child -> child.getValue().equals(value));
    }
}