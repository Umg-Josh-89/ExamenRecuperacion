/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreeNode;

/**
 *
 * @author rodol
 */


import com.beesion.ms.test.service.targetsum.TargetSumNode;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import com.beesion.ms.test.service.treenode.TreeNode;
public class TreenodeTest {

    @Test
    public void testPathSum() {
        // Árbol: [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        TargetSumNode sol = new TargetSumNode();
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(5, 4, 11, 2),
            Arrays.asList(5, 8, 4, 5)
        );
        List<List<Integer>> actual = sol.pathSum(root, 22);

        // Comparamos listas sin importar el orden
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }
}
