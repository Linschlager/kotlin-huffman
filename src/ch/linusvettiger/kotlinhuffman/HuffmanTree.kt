package ch.linusvettiger.kotlinhuffman

/*
    Class Structure to store all nodes in the tree
 */
open class Node(val key: String)
class LeafNode(key: String, val char: Char): Node(key)
class BranchNode(key: String, var left: Node?, var right: Node?): Node(key)

/**
 * Generates a Huffman tree based on the frequency of characters in the input string
 */
fun createHT(frequency: CharFrequency): BranchNode {
    val nodes = HashMap<String, Node>()
    // Create a LeafNode for each Char
    frequency.keys().forEach { nodes[it] = LeafNode(it, it[0]) }

    while (frequency.keys().count() > 1) {
        // First minValue
        val minLeft = frequency.min()
        val minLeftV = frequency.remove(minLeft)

        // second minValue
        val minRight = frequency.min()
        val minRightV = frequency.remove(minRight)

        // Combine the two minimal frequencies
        frequency.setValue(minLeft+minRight, minLeftV+minRightV)

        // Create the new bottom branch
        val newB = BranchNode(minLeft+minRight, nodes[minLeft], nodes[minRight])
        nodes.remove(minLeft)
        nodes.remove(minRight)
        nodes[newB.key] = newB
    }
    // Output the left
    return (nodes[nodes.keys.first()] as BranchNode?)!!

}