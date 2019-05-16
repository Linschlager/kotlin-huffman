package ch.linusvettiger.kotlinhuffman

import java.io.File

fun readHuffmanTree(fileName: String): HashMap<String, Char> {
    try {
        val map = HashMap<String, Char>()
        // Only use the first line and split it on all "-" and ":"
        File(fileName).readLines().first().split('-').forEach {
            val pair = it.split(':')
            val key = pair[0].toByte().toChar() // Get the ASCII representation
            map[pair[1]] = key
        }
        return map
    } catch(e: Exception) {
        e.printStackTrace()
    }
    return HashMap()
}

fun readInputFile(fileName: String): List<String> {
    try {
        return File(fileName).readBytes().map {
            var s = it.toUByte().toString(2) // Parse each byte to unsigned byte to not have negative numbers and then parse to binary number
            while (s.length % 8 != 0) s = "0$s" // Add Padding to fill the byte
            s
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return emptyList()
}

fun readFile(path: String): String {
    val f = File(path)
    return f.readText() // Read all lines as normal text
}