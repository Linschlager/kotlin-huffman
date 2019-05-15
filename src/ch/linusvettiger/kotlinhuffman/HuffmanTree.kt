package ch.linusvettiger.kotlinhuffman

class HuffmanTree() {
    private val internalMap: HashMap<Char, String> = HashMap()

    fun getByChar(c: Char): String? {
        return internalMap[c]
    }

    fun getBySeq(seq: String): Char? {
        return internalMap.entries.first { it.value === seq }.key
    }

    fun add(c: Char, seq: String): Boolean {
        return when {
            internalMap.containsValue(seq) -> false
            internalMap.containsKey(c) -> false
            else -> {
                internalMap[c] = seq
                true
            }
        }

    }

    fun length(): Int {
        return internalMap.size
    }
}