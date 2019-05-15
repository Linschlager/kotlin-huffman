package ch.linusvettiger.kotlinhuffman

class CharFrequency() {
    private val internalList: HashMap<Char, Int> = HashMap()

    fun addChar(char: Char) {
        if (internalList.containsKey(char)) {
            internalList[char] = internalList[char]!!+1
        } else {
            internalList[char] = 1
        }
    }

    fun get(char: Char): Int {
        return if (internalList.containsKey(char)) {
            internalList[char]!!
        } else {
            0
        }
    }

    override fun toString(): String {
        return internalList.toString()
    }
}