package ch.linusvettiger.kotlinhuffman

/*
    Class Structure to store all nodes in the tree
 */
open class Node(val key: String)
class LeafNode(key: String, val char: Char): Node(key)
class BranchNode(key: String, var left: Node?, var right: Node?): Node(key) {
    constructor(key: String): this(key, null, null)
    constructor(key: String, left: Node?): this(key, left, null)
}

/**
 * Generates a Huffman tree based on the frequency of characters in the input string
 */
fun createHT(frequency: CharFrequency): BranchNode {
    val nodes = HashMap<String, Node>()
    // Create a LeafNode for each Char
    frequency.keys().forEach { nodes[it] = LeafNode(it, it[0]) }

    var pointer = BranchNode("")
    while (frequency.keys().count() > 1) {
        // First minValue
        val minLeft = frequency.min()!!.key
        val minLeftV = frequency.remove(minLeft)

        // second minValue
        val minRight = frequency.min()!!.key
        val minRightV = frequency.remove(minRight)

        // Combine the two minimal frequencies
        frequency.setValue(minLeft+minRight, minLeftV+minRightV)

        // Create the new bottom branch
        val newB = BranchNode(minLeft+minRight, nodes[minLeft], nodes[minRight])
        nodes.remove(minLeft)
        nodes.remove(minRight)
        nodes[newB.key] = newB

        // Add the newly created BranchNode to the rest of the structure
        pointer = BranchNode(newB.key, newB)
    }
    // Output the left
    return (pointer.left as BranchNode?)!!

}