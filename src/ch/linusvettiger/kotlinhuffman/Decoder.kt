package ch.linusvettiger.kotlinhuffman

/**
 * @param input binary number of the entire string
 * @param map dictionary to map each character to the binary representation
 * @return Decoded input string
 */
fun decode(input: String, map: Map<String, Char>): String {
    var output = ""
    var workingString = input // Copy input string in a var to be able to remove the already translated part

    while (workingString.isNotEmpty()) {
        var tmp = 1 // Pointer to move as far to the right until a character is matched
        while (map[workingString.substring(0, tmp)] === null) {
            tmp++ // Not found anything -> Move pointer to the right
            if (workingString.length < tmp) return output
        }
        output += map[workingString.substring(0, tmp)] // Add translated character to output string
        workingString = workingString.substring(tmp) // remove translated part from workingString
    }

    return output
}