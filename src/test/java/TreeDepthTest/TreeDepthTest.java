/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreeDepthTest;

/**
 *
 * @author rodol
 */
import com.beesion.ms.test.service.treedepth.TreeDepth;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.beesion.ms.test.service.treenode.TreeNode;
public class TreeDepthTest {

    @Test
    public void testDepths() {
        // Árbol:
        //         3
        //       /   \
        //      9     20
        //           /  \
        //         15    7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeDepth depthCalculator = new TreeDepth();

        assertEquals(2, depthCalculator.minDepth(root)); // 3 -> 9
        assertEquals(3, depthCalculator.maxDepth(root)); // 3 -> 20 -> 15 o 7
    }
}
