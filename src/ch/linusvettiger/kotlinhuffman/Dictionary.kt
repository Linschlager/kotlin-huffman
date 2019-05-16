package ch.linusvettiger.kotlinhuffman

fun generateSubTree(node: BranchNode, prefix: String, map: HashMap<Char, String>) {
    if (node.left is BranchNode) {
        generateSubTree(node.left as BranchNode, prefix+"0", map)
    } else {
        map[(node.left as LeafNode).char] = prefix+"0"
    }
    if (node.right is BranchNode) {
        generateSubTree(node.right as BranchNode, prefix+"1", map)
    } else {
        map[(node.right as LeafNode).char] = prefix+"1"
    }
}

fun generateDictionary(ht: BranchNode): Map<Char, String> {
    val map = HashMap<Char, String>()
    if (ht.left is BranchNode) {
        generateSubTree(ht.left as BranchNode, "0", map)
    } else {
        map[(ht.left as LeafNode).char] = "0"
    }
    if (ht.right is BranchNode) {
        generateSubTree(ht.right as BranchNode, "1", map)
    } else {
        map[(ht.right as LeafNode).char] = "1"
    }
    return map
}