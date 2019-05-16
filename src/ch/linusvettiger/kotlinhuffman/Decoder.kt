package ch.linusvettiger.kotlinhuffman

fun decode(input: String, map: Map<String, Char>): String {
    var output = ""
    var workingString = input

    while (workingString.isNotEmpty()) {
        var tmp = 1
        while (map[workingString.substring(0, tmp)] === null) {
            tmp++
            if (workingString.length < tmp) return output
        }
        output += map[workingString.substring(0, tmp)]
        workingString = workingString.substring(tmp)
    }

    return output
}