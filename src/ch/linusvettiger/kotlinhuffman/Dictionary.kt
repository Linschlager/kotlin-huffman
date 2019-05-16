package ch.linusvettiger.kotlinhuffman

/**
 * Recursive function to flatten the given node structure
 * @param node current working node
 * @param path "path" to current node
 * @param map reference of the complete dictionary
 */
fun generateSubTree(node: BranchNode, path: String, map: HashMap<Char, String>) {
    if (node.left is BranchNode) { // If left is a branchnode, it has further children, therefore generateSubTree has to be called again. Adding a 1 to the path
        generateSubTree(node.left as BranchNode, path+"0", map)
    } else {
        map[(node.left as LeafNode).char] = path+"0"
    }
    if (node.right is BranchNode) {// If right is a branchnode, it has further children, therefore generateSubTree has to be called again. Adding a 1 to the path
        generateSubTree(node.right as BranchNode, path+"1", map)
    } else {
        map[(node.right as LeafNode).char] = path+"1"
    }
}

/**
 * Initial invocation of @see generateSubTree
 * @param ht Top level node
 * @return Complete dictionary of all encodable characters
 */
fun generateDictionary(ht: BranchNode): Map<Char, String> {
    val map = HashMap<Char, String>()
    if (ht.left is BranchNode) {
        generateSubTree(ht.left as BranchNode, "0", map) // Call generateSubTree for left side
    } else {
        map[(ht.left as LeafNode).char] = "0" // If the left tree is just one node, use 0
    }
    if (ht.right is BranchNode) {
        generateSubTree(ht.right as BranchNode, "1", map)// Call generateSubTree for right side
    } else {
        map[(ht.right as LeafNode).char] = "1" // If the right tree is just one node, use 1
    }
    return map
}