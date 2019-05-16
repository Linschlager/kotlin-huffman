package ch.linusvettiger.kotlinhuffman

class CharFrequency {
    private val internalList: HashMap<String, Int> = HashMap()

    fun setValue(char: String, value: Int) {
        internalList[char] = value
    }

    fun addChar(char: String) {
        if (internalList.containsKey(char)) {
            internalList[char] = internalList[char]!!+1
        } else {
            internalList[char] = 1
        }
    }

    fun get(char: String): Int {
        return if (internalList.containsKey(char)) {
            internalList[char]!!
        } else {
            0
        }
    }

    fun combine(left: String, right: String): Boolean {
        if (!internalList.containsKey(left) || !internalList.containsKey(right)) {
            return false
        }
        val leftV = remove(left)
        val rightV = remove(right)
        setValue(left+right, leftV+rightV)
        return true
    }

    fun remove(char: String): Int {
        return internalList.remove(char) ?: -1
    }

    @Deprecated("Please don't use") fun all(): Map<String, Int> {
        return internalList
    }

    fun min(): Map.Entry<String, Int>? {
        return internalList.minBy { it.value }
    }

    fun keys(): Iterable<String> {
        return internalList.keys
    }

    override fun toString(): String {
        return internalList.toString()
    }
}