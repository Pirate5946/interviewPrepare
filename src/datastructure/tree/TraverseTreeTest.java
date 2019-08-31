package datastructure.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by lt on 2019/1/25.
 */
public class TraverseTreeTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void preOrderRecur() throws Exception {
        TraverseTree traverseTree = new TraverseTree();
        TraverseTree.Node root = new TraverseTree.Node(1);
        TraverseTree.Node nodel = new TraverseTree.Node(11);
        TraverseTree.Node noder = new TraverseTree.Node(12);
        root.left = nodel;
        root.right = noder;

        TraverseTree.Node nodell = new TraverseTree.Node(111);
        nodel.left = nodell;

        traverseTree.preOrderRecur(root);
    }

    @Test
    public void inOrderRecur() throws Exception {
        TraverseTree traverseTree = new TraverseTree();
        TraverseTree.Node root = new TraverseTree.Node(1);
        TraverseTree.Node nodel = new TraverseTree.Node(11);
        TraverseTree.Node noder = new TraverseTree.Node(12);
        root.left = nodel;
        root.right = noder;

        TraverseTree.Node nodell = new TraverseTree.Node(111);
        nodel.left = nodell;

        traverseTree.inOrderRecur(root);
    }

    @Test
    public void postOrderRecur() throws Exception {
        TraverseTree traverseTree = new TraverseTree();
        TraverseTree.Node root = new TraverseTree.Node(1);
        TraverseTree.Node nodel = new TraverseTree.Node(11);
        TraverseTree.Node noder = new TraverseTree.Node(12);
        root.left = nodel;
        root.right = noder;

        TraverseTree.Node nodell = new TraverseTree.Node(111);
        nodel.left = nodell;

        traverseTree.postOrderRecur(root);
    }

    @Test
    public void preOrderUnRecur() throws Exception {
        TraverseTree traverseTree = new TraverseTree();
        TraverseTree.Node root = new TraverseTree.Node(1);
        TraverseTree.Node nodel = new TraverseTree.Node(11);
        TraverseTree.Node noder = new TraverseTree.Node(12);
        root.left = nodel;
        root.right = noder;

        TraverseTree.Node nodell = new TraverseTree.Node(111);
        nodel.left = nodell;

        traverseTree.preOrderUnRecur(root);
    }

    @Test
    public void inOrederUnRecur() throws Exception {
        TraverseTree traverseTree = new TraverseTree();
        TraverseTree.Node root = new TraverseTree.Node(1);
        TraverseTree.Node nodel = new TraverseTree.Node(11);
        TraverseTree.Node noder = new TraverseTree.Node(12);
        root.left = nodel;
        root.right = noder;

        TraverseTree.Node nodell = new TraverseTree.Node(111);
        nodel.left = nodell;

        traverseTree.inOrderUnRecur(root);
    }

}