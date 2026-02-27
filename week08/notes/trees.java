// ==========================================
// TREE BASICS (CSE143)
// ==========================================
//
// A tree is a recursive data structure:
// - either empty
// - or a root node with left/right subtrees
//
// Trees are naturally recursive.
//
// Real-world examples:
// - File systems
// - Organizational charts
// - Expression trees
// - Decision trees
//
// ==========================================
// TERMINOLOGY
// ==========================================
//
// Root      → top node
// Leaf      → node with no children
// Branch    → node with ≥ 1 child
// Edge      → connection between nodes
//
// Parent / Child / Sibling
// Ancestor  → parent or parent’s ancestor
// Descendant → child or child’s descendant
//
// ==========================================
// STRUCTURE MEASUREMENTS
// ==========================================
//
// Degree(node) → number of children
// Degree(tree) → max degree among all nodes
//
// Level → distance from root (root is level 0)
//
// Depth(node) → number of edges from root to node
// Height(node) → longest path DOWN to a leaf
//
// Height(tree) = height(root)
//
// Important:
// Depth goes DOWN from root.
// Height goes DOWN from node.
//
// Leaf height = 0
// Root depth = 0
//
// ==========================================
// BASIC TREE NODE (INTEGER VERSION)
// ==========================================

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

//
// Each node contains:
// - data
// - reference to left child
// - reference to right child
//

// ==========================================
// TREE TRAVERSALS
// ==========================================
//
// Traversal = visiting every node exactly once
//
// There are 3 main recursive patterns:
//
// Pre-order  → Node, Left, Right
// In-order   → Left, Node, Right
// Post-order → Left, Right, Node
//
// ==========================================

class BinaryTree {

    private TreeNode root;

    // --------------------------------------
    // PREORDER
    // --------------------------------------
    // process node BEFORE subtrees
    //
    // Useful when copying a tree

    private void preorder(TreeNode current) {
        if (current == null) {
            return;
        }

        System.out.print(current.data + " ");
        preorder(current.left);
        preorder(current.right);
    }

    // --------------------------------------
    // INORDER
    // --------------------------------------
    // process node BETWEEN subtrees
    //
    // In a BST, this prints sorted order

    private void inorder(TreeNode current) {
        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.data + " ");
        inorder(current.right);
    }

    // --------------------------------------
    // POSTORDER
    // --------------------------------------
    // process node AFTER subtrees
    //
    // Useful for deleting/freeing tree

    private void postorder(TreeNode current) {
        if (current == null) {
            return;
        }

        postorder(current.left);
        postorder(current.right);
        System.out.print(current.data + " ");
    }

    // ======================================
    // SIZE OF TREE
    // ======================================
    //
    // Count all nodes
    //
    // size = 1 + size(left) + size(right)

    private int size(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = size(current.left);
        int right = size(current.right);

        return 1 + left + right;
    }

    // ======================================
    // HEIGHT OF TREE
    // ======================================
    //
    // Height = longest path downward
    //
    // height = 1 + max(left, right)
    //
    // If measuring edges instead of nodes:
    // height(root) - 1

    private int height(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = height(current.left);
        int right = height(current.right);

        return 1 + Math.max(left, right);
    }
}

//
// ==========================================
// TYPES OF BINARY TREES
// ==========================================
//
// Full      → every node has 0 or 2 children
// Complete  → filled level by level, left to right
// Perfect   → full + all leaves same level
// Balanced  → height difference ≤ 1 everywhere
// Degenerate → each node has only one child
// Skewed    → degenerate leaning entirely left/right
//
// ==========================================
// BINARY SEARCH TREE (BST)
// ==========================================
//
// BST property:
//
// For every node R:
//
// All values in left subtree ≤ R.data
// All values in right subtree > R.data
//
// BSTs keep data SORTED implicitly.
//
// In-order traversal of BST = sorted output.
//
// ==========================================
// GENERIC BST NODE
// ==========================================

class BST<Type extends Comparable<Type>> {

    private TreeNode<Type> root;

    class TreeNode<Type> {
        Type data;
        TreeNode<Type> left;
        TreeNode<Type> right;

        public TreeNode(Type data) {
            this.data = data;
        }
    }

    // ======================================
    // ADD METHOD (RECURSIVE)
    // ======================================

    public void add(Type value) {
        root = add(value, root);
    }

    private TreeNode<Type> add(Type value, TreeNode<Type> current) {

        if (current == null) {
            return new TreeNode<Type>(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = add(value, current.left);
        } else {
            current.right = add(value, current.right);
        }

        return current;
    }

    // ======================================
    // REMOVE METHOD
    // ======================================
    //
    // Cases:
    // 1) Leaf → return null
    // 2) One child → return that child
    // 3) Two children →
    //      - find in-order successor
    //      - replace value
    //      - delete successor

    public void remove(Type value) {
        root = remove(value, root);
    }

    private TreeNode<Type> remove(Type value, TreeNode<Type> current) {

        if (current == null) {
            return null;
        }

        if (value.compareTo(current.data) < 0) {
            current.left = remove(value, current.left);
        } else if (value.compareTo(current.data) > 0) {
            current.right = remove(value, current.right);
        } else {

            // case 1: no left child
            if (current.left == null) {
                return current.right;
            }

            // case 2: no right child
            if (current.right == null) {
                return current.left;
            }

            // case 3: two children
            Type min = findMin(current.right);
            current.data = min;
            current.right = remove(min, current.right);
        }

        return current;
    }

    private Type findMin(TreeNode<Type> current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
}

//
// ==========================================
// KEY EXAM PATTERNS
// ==========================================
//
// 1) Every tree problem is recursive.
// 2) Always define:
//      - base case (current == null)
//      - recursive case
// 3) In BST:
//      left < node < right
// 4) In-order traversal of BST is sorted.
// 5) Removal with two children always uses:
//      in-order successor (smallest in right subtree)
//
// ==========================================