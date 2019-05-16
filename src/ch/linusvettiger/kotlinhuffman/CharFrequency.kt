package ch.linusvettiger.kotlinhuffman

/**
 * Keep track of the frequency of characters in a text
 */
class CharFrequency {
    /*
        Structure used internally for data storage
     */
    private val internalList: HashMap<String, Int> = HashMap()

    /**
     * Add a value directly to the internalList
     * Used when merging chars
     * @param char Character combination
     * @param value combined frequency
     */
    fun setValue(char: String, value: Int) {
        internalList[char] = value
    }

    /**
     * Register a single occurrence of a character
     */
    fun addChar(char: String) {
        if (internalList.containsKey(char)) { // Check if character has already occurred
            internalList[char] = internalList[char]!!+1
        } else {
            internalList[char] = 1
        }
    }

    /**
     * Get the frequency of a character
     * @param char Character to look for
     */
    fun get(char: String): Int {
        return if (internalList.containsKey(char)) {
            internalList[char]!!
        } else {
            0
        }
    }

    /**
     * Remove a character from the list
     * @param char character to remove
     * @return Frequency of the removed char
     */
    fun remove(char: String): Int {
        return internalList.remove(char) ?: -1
    }

    /**
     * @return the least frequent item in the list
     */
    fun min(): Map.Entry<String, Int>? {
        return internalList.minBy { it.value }
    }

    /**
     * @return all characters currently tracked
     */
    fun keys(): Iterable<String> {
        return internalList.keys
    }

    /**
     * @return the entire internal list as a string for debugging
     */
    override fun toString(): String {
        return internalList.toString()
    }
}